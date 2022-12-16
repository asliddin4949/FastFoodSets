package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Setter
@Getter
@AllArgsConstructor
public class CurrentOrder {
    Product product;
    double quantity;
    BigDecimal cost;

    @Override
    public String toString() {
        return
                "\nProduct: " + product +
                "\nQuantity: " + quantity +
                "\nCost: " + cost +
                "\n- - - - - - - - - - - -";
    }
}
