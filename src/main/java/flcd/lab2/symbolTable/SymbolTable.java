package flcd.lab2.symbolTable;

public interface SymbolTable {
    int add(String element);
    int remove(String element) throws SymbolTableException;
    int search(String element) throws SymbolTableException;
    int size();
    boolean isEmpty();
}
