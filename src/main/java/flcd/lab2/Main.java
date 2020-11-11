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

        LexicalAnalyser lexicalAnalyser = new LexicalAnalyser("src/main/java/flcd/lab2/input/token.in");
        lexicalAnalyser.scanning("p0.txt", "src/main/java/flcd/lab2/input", "src/main/java/flcd/lab2/output");
        lexicalAnalyser.scanning("p1.txt", "src/main/java/flcd/lab2/input", "src/main/java/flcd/lab2/output");
        lexicalAnalyser.scanning("p2.txt", "src/main/java/flcd/lab2/input", "src/main/java/flcd/lab2/output");
        lexicalAnalyser.scanning("p3.txt", "src/main/java/flcd/lab2/input", "src/main/java/flcd/lab2/output");
        lexicalAnalyser.scanning("p1err.txt", "src/main/java/flcd/lab2/input", "src/main/java/flcd/lab2/output");
        lexicalAnalyser.scanning("p1err2.txt", "src/main/java/flcd/lab2/input", "src/main/java/flcd/lab2/output");

        System.out.println("\nAPP STOPPED");
    }
}
