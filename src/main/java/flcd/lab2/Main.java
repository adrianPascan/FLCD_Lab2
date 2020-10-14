package flcd.lab2;

import flcd.lab2.symbolTable.SymbolTable;
import flcd.lab2.symbolTable.SymbolTableImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("APP STARTED..\n");

        SymbolTable symbolTable = new SymbolTableImpl();

        System.out.println("isEmpty= " + symbolTable.isEmpty());
        System.out.println("size= " + symbolTable.size());

        symbolTable.add("elem");
        symbolTable.add("elem2");
        symbolTable.add("elem3");
        symbolTable.add("elem4");
        symbolTable.add("elem5");

        System.out.println("isEmpty= " + symbolTable.isEmpty());
        System.out.println("size= " + symbolTable.size());

        symbolTable.search("elem");
        symbolTable.search("elem2");
        symbolTable.search("elem3");
        symbolTable.search("elem4");
        symbolTable.search("elem5");

        symbolTable.remove("elem5");
        symbolTable.remove("elem4");

        System.out.println("isEmpty= " + symbolTable.isEmpty());
        System.out.println("size= " + symbolTable.size());

        System.out.println("\nAPP STOPPED");
    }
}
