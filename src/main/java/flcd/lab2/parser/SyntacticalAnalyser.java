package flcd.lab2.parser;

public class SyntacticalAnalyser {

// TODO: 24/10/2020 mistakenly written for Lexical Analyser class

//    private static void checkProgramBaseStructure(List<LAEntry> laEntries) throws LexicalError {
//        if (laEntries.size() < 6) {
//            throw new LexicalError("LEXICAL ERROR: program does not suit base structure");
//        }
//
//        List<String> expectedTokens = Arrays.asList("int", "main", "(", ")", "{", "}");
//        List<LAEntry> actualTokens = laEntries.subList(0, 4);
//        actualTokens.add(laEntries.get(laEntries.size()-1));
//
//        for (int index = 0; index < 6; index++) {
//            String expectedToken = expectedTokens.get(index);
//            LAEntry actualToken = actualTokens.get(index);
//            if (!actualToken.getToken().equals(expectedToken)) {
//                throw new LexicalError("LEXICAL ERROR: program does not suit base structure around '" + actualToken.getToken() + "' (line " + actualToken.getLine() + ")");
//            }
//        }
//    }
//
//    private static void checkIdentifier(LAEntry laEntry) throws LexicalError {
//        if (!laEntry.getToken().matches("[a-zA-Z][a-zA-Z]+")) {
//            throw new LexicalError("LEXICAL ERROR: invalid identifier '" + laEntry.getToken() + "' (line " + laEntry.getLine() + ")");
//        }
//    }
//
//    private static void checkConstant(LAEntry laEntry, String type) throws LexicalError {
//        switch(type.toLowerCase()) {
//            case "int":
//                try {
//                    Integer.parseInt(laEntry.getToken());
//                } catch (NumberFormatException nfe) {
//                    throw new LexicalError("LEXICAL ERROR: invalid integer constant '" + laEntry.getToken() + "' (line " + laEntry.getLine() + ")");
//                }
//            case "string":
//                if (!laEntry.getToken().startsWith("\"") || !laEntry.getToken().endsWith("\"")) {
//                    throw new LexicalError("LEXICAL ERROR: invalid string constant '" + laEntry.getToken() + "' (line " + laEntry.getLine() + ")");
//                }
//            default:
//                throw new LexicalError("LEXICAL ERROR: invalid constant type '" + type + "'");
//        }
//    }
}
