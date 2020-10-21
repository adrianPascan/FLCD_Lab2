package flcd.lab2.symbolTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class SymbolTableImpl implements SymbolTable {
    private int capacity;
    private int noOfElements;
    private List<String> elements;

    public SymbolTableImpl() {
        capacity = 11;
        noOfElements = 0;
        elements = new ArrayList<>(Collections.nCopies(capacity, null));
    }

    @Override
    public int add(String element) {
        int positionInST = hash(element, capacity);
        String elementInST = elements.get(positionInST);

        if (elementInST == null) {
            elements.set(positionInST, element);
        }
        else {
            int newCapacity = nextCapacity(capacity);
            List<String> newElements = new ArrayList<>(Collections.nCopies(newCapacity, null));

            IntStream.range(0, capacity)
                    .forEach(index -> {
                        String oldElement = elements.get(index);
                        if (oldElement != null) {
                            int newPositionInST = hash(oldElement, newCapacity);
                            newElements.set(newPositionInST, oldElement);
                        }
                    });

            capacity = newCapacity;
            elements = newElements;
        }

        noOfElements++;
        return positionInST;
    }

    @Override
    public int remove(String element) throws SymbolTableException {
        int positionInST = search(element);
        noOfElements--;
        elements.set(positionInST, null);
        return positionInST;
    }

    @Override
    public int search(String element) throws SymbolTableException {
        int positionInST = hash(element, capacity);
        String elementInST = elements.get(positionInST);
        if (elementInST == null || !elementInST.equals(element)) {
            throw new SymbolTableException("SymbolTableException -> Could not find element '" + element + "'");
        }
        return positionInST;
    }

    @Override
    public int size() {
        return noOfElements;
    }

    @Override
    public boolean isEmpty() {
        return noOfElements == 0;
    }

    private static int hash(String element, int capacity) {
        return hashCode(element.hashCode()) % capacity;
    }

    private static int hashCode(int hashValue) {
        if (hashValue < 0) {
            hashValue = -hashValue;
        }
        return hashValue;
    }

    private static int nextCapacity(int capacity) {
        int newCapacity = capacity * 2 + 1;
        while (!isPrime(newCapacity)) {
            newCapacity += 2;
        }
        return newCapacity;
    }

    private static boolean isPrime(int no) {
        if (no < 2 || (no != 2 && no % 2 == 0)) {
            return false;
        }
        for (int oddDivisor = 3; oddDivisor * oddDivisor <= no; oddDivisor += 2) {
            if (no % oddDivisor == 0) {
                return false;
            }
        }

        return true;
    }
}
