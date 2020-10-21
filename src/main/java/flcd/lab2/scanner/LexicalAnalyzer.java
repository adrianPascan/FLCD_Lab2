package flcd.lab2.scanner;

import flcd.lab2.PIF.PIF;
import flcd.lab2.PIF.PIFImpl;
import flcd.lab2.symbolTable.SymbolTable;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Getter
@Setter
public class LexicalAnalyzer {
    private PIF pif;
    private String tokenFilePath;
    private String outputFilePath;

    public LexicalAnalyzer(String tokenFilePath) {
        this.tokenFilePath = tokenFilePath;
        pif = new PIFImpl(tokenFilePath);
    }

    public void readProgram(String programFilePath) {
        try {
            File file = new File(programFilePath);
            System.out.println(file.getPath());
            Scanner scanner = new Scanner(file);

            scanner.tokens().forEach(token -> {
                System.out.println(token);
                pif.add(token);
            });

            System.out.println(pif.getTokensToPositionInST());
            System.out.println(pif.getSymbolTable());
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
