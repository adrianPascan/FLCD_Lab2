package flcd.lab2.PIF;

import flcd.lab2.symbolTable.SymbolTable;
import flcd.lab2.symbolTable.SymbolTableImpl;
import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Getter
public class PIFImpl implements PIF {
    private Map<String, Integer> tokensToReservedCode;
    private Map<String, Integer> tokensToPositionInST;
    private SymbolTable symbolTable;
    private String tokenFilePath;

    public PIFImpl(String tokenFilePath) {
        this.tokenFilePath = tokenFilePath;
        tokensToReservedCode = readTokenToReservedCode(tokenFilePath);
        tokensToPositionInST = new HashMap<>();
        symbolTable = new SymbolTableImpl();
    }

    public static Map<String, Integer> readTokenToReservedCode(String tokenFilePath) {
        Map<String, Integer> tokenToCode = new HashMap<>();

        try {
            File file = new File(tokenFilePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineTokens = line.split(",");
                String token = lineTokens[0];
                int code = Integer.parseInt(lineTokens[1]);

                tokenToCode.put(token, code);
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

        return tokenToCode;
    }

    @Override
    public int add(String token) {
        if (tokensToReservedCode.containsKey(token)) {
            return -1;
        }
        return symbolTable.add(token);
    }
}
