package flcd.lab2.parser;

import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ProductionOutput {
    private List<String> symbols;

    public ProductionOutput() {
        symbols = new ArrayList<>();
    }
}
