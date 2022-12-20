package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Setter
@Getter
@EqualsAndHashCode
public class Product {

    int id;
    String name;
    BigDecimal price;

    @Override
    public String toString() {
        return "\nProductId: " + id +
                "\nName: " + name +
                "\nPrice: " + price +
                "\n- - - - - - - - - - ";
    }

    public static int currentId = 1;

    {
        currentId++;
    }

}
