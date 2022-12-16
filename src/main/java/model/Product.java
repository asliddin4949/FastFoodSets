package model;

import data.Storage;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
public class Product implements CheckStorage<Product> {

    int id;
    String name;
    BigDecimal price;

    public static int currentId = 0;
    {
        currentId++;
    }
    @Override
    public String toString() {
        return "\nProductId: " + id +
                "\nName: " + name  +
                "\nPrice: " + price +
                "\n- - - - - - - - - - ";
    }
    @Override
    public boolean isExist(List<Product> list, String name) {
        var product1 = list.stream().filter(product -> product.getName().equals(name)).findFirst().orElse(null);
        return product1 != null;
    }
}
