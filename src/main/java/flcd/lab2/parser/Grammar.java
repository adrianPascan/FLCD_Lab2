package flcd.lab2.parser;

import flcd.lab2.automaton.TransitionInput;
import flcd.lab2.automaton.TransitionOutput;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Grammar {
    public static final String SEPARATOR = " ";
    public static final String PRODUCTION_SEPARATOR = ":";
    public static final String PRODUCTION_OUTPUT_SEPARATOR = "\\|";

    private Set<String> nonterminals;
    private Set<String> terminals;
    private Map<ProductionInput, List<ProductionOutput>> productions;
    private String startSymbol;

    public Grammar() {
        nonterminals = new HashSet<>();
        terminals = new HashSet<>();
        productions = new HashMap<>();
        startSymbol = null;
    }

    public Grammar(String filePath) {
        nonterminals = new HashSet<>();
        terminals = new HashSet<>();
        productions = new HashMap<>();
        startSymbol = null;

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            // nonterminals
            if (!scanner.hasNextLine()) {
                throw new ParserException("ParserException: no data for nonterminals, terminals, start symbol, productions..");
            }
            List<String> nonterminals = Arrays.asList(scanner.nextLine().split(SEPARATOR));
            this.nonterminals.addAll(nonterminals);

            // terminals
            if (!scanner.hasNextLine()) {
                throw new ParserException("ParserException: no data for terminals, start symbol, productions..");
            }
            List<String> symbols = Arrays.asList(scanner.nextLine().split(SEPARATOR));
            this.terminals.addAll(symbols);

            // start symbol
            if (!scanner.hasNextLine()) {
                throw new ParserException("ParserException: no data for start symbol, productions..");
            }
            this.startSymbol = scanner.nextLine();
            if (!nonterminals.contains(this.startSymbol)) {
                throw new ParserException("ParserException: start symbol must be contained by nonterminals");
            }

            // productions
            if (!scanner.hasNextLine()) {
                throw new ParserException("ParserException: no data for productions..");
            }
            while(scanner.hasNextLine()) {
                String[] tokens = scanner.nextLine().strip().split(PRODUCTION_SEPARATOR);
                ProductionInput input = new ProductionInput(tokens[0].strip());

                productions.put(input, new ArrayList<>());

                List<String> prods = Arrays.asList(tokens[1].strip().split(PRODUCTION_OUTPUT_SEPARATOR));
                prods.forEach(production -> {
                    String[] parameters = production.strip().split(SEPARATOR);

                    ProductionOutput output = new ProductionOutput(Arrays.asList(production.split(SEPARATOR)));
                    productions.get(input).add(output);
                });

            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
