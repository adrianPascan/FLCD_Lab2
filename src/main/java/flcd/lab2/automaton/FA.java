package flcd.lab2.automaton;


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
public class FA {
    private Set<String> states;
    private Set<String> alphabet;
    private Map<TransitionInput, String> transitions;
    private String initialState;
    private Set<String> finalStates;

    public FA() {
        states = new HashSet<>();
        alphabet = new HashSet<>();
        transitions = new HashMap<>();
        initialState = null;
        finalStates = new HashSet<>();
    }

    public FA(String filePath) {
        states = new HashSet<>();
        alphabet = new HashSet<>();
        transitions = new HashMap<>();
        initialState = null;
        finalStates = new HashSet<>();

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            // states
            if (!scanner.hasNextLine()) {
                throw new FAException("FAException: no data for states, alphabet, transitions, initial state and final states..");
            }
            List<String> states = Arrays.asList(scanner.nextLine().split("\\|"));
            this.states.addAll(states);

            // alphabet
            if (!scanner.hasNextLine()) {
                throw new FAException("FAException: no data for alphabet, transitions, initial state and final states..");
            }
            List<String> symbols = Arrays.asList(scanner.nextLine().split("\\|"));
            this.alphabet.addAll(symbols);

            // transitions
            if (!scanner.hasNextLine()) {
                throw new FAException("FAException: no data for transitions, initial state and final states..");
            }
            List<String> transitions = Arrays.asList(scanner.nextLine().split("\\|"));
            transitions.forEach(transition -> {
                String[] parameters = transition.split("-");
                if (parameters.length != 3) {
                    throw new FAException("FAException: invalid transition '" + transition + "'");
                }

                TransitionInput input = new TransitionInput(parameters[0], parameters[1]);
                this.transitions.put(input, parameters[2]);
            });

            // initial state
            if (!scanner.hasNextLine()) {
                throw new FAException("FAException: no data for initial state and final states..");
            }
            this.initialState = scanner.nextLine();
            if (!states.contains(this.initialState)) {
                throw new FAException("FAException: initial state must be contained by states");
            }

            // final states
            if (!scanner.hasNextLine()) {
                throw new FAException("FAException: no data for states, alphabet, transitions, initial state and final states..");
            }
            List<String> finalStates = Arrays.asList(scanner.nextLine().split("\\|"));
            this.finalStates.addAll(finalStates);
            if (!states.containsAll(finalStates)) {
                throw new FAException("FAException: final states must be a subset of states");
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public boolean isAccepted(String sequence) {
        return false;
    }
}
