package flcd.lab2.PIF;

import flcd.lab2.symbolTable.SymbolTable;

import java.util.Map;

public interface PIF {
    int add(String token);
    Map<String, Integer> getTokensToReservedCode();
    Map<String, Integer> getTokensToPositionInST();
    SymbolTable getSymbolTable();
}
