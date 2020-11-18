package flcd.lab2;


import flcd.lab2.parser.Grammar;
import flcd.lab2.parser.GrammarConsole;

public class Main {
    public static void main(String[] args) {
        System.out.println("APP STARTED..\n");

        Grammar grammar = new Grammar("src/main/java/flcd/lab2/parser/input/parser2.in");

        GrammarConsole console = new GrammarConsole(grammar);
        console.start();

        System.out.println("\nAPP STOPPED");
    }
}
