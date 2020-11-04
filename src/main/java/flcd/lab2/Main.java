package flcd.lab2;

import flcd.lab2.automaton.FA;
import flcd.lab2.automaton.FAConsole;
import flcd.lab2.hashTable.HashTable;
import flcd.lab2.hashTable.HashTableImpl;
import flcd.lab2.scanner.LexicalAnalyser;

public class Main {
    public static void main(String[] args) {
        System.out.println("APP STARTED..\n");

        FA fa = new FA("src/main/java/flcd/lab2/automaton/input/fa.in");
        FAConsole faConsole = new FAConsole(fa);
        faConsole.start();

        System.out.println("\nAPP STOPPED");
    }
}
