package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Setter
@Getter
@EqualsAndHashCode
public class Product {
    //********************Fields**********************
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

    //************************Counter Product ID*************************************
    public static int currentId = 1;

    {
        currentId++;
    }

}
