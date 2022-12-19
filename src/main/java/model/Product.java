package model;

import data.Storage;
import interfaces.Admin;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@Setter
@Getter
@EqualsAndHashCode
public class Product implements CheckStorage<Product> {
    //********************Fields**********************
    int id;
    String name;
    BigDecimal price;

    //*******************Behaviors******************************
    public void addProduct() {
        System.out.println("Enter Product Name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Product product = new Product();
        if (product.isExist(Storage.products, name)) {
            System.out.println("This Product has already added!");
            Admin.adminMenu();
        } else {
            scanner = new Scanner(System.in);
            System.out.println("Price: ");
            BigDecimal price = scanner.nextBigDecimal();
            product.setId(Product.currentId);
            product.setName(name);
            product.setPrice(price);
            Storage.products.add(product);
            System.out.println("Product successfully added!");
            Admin.adminMenu();
        }
    }

    public Product getProduct() {
        Product product = new Product();
        product.showProducts();
        System.out.println("Choose Product Id :");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        return Storage.products.stream().filter(product1 -> product1.getId() == id).findFirst().orElse(null);
    }

    public void showProducts() {
        Storage.products.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "\nProductId: " + id +
                "\nName: " + name +
                "\nPrice: " + price +
                "\n- - - - - - - - - - ";
    }

    @Override
    public boolean isExist(List<Product> list, String name) {
        var product1 = list.stream().filter(product -> product.getName().equals(name)).findFirst().orElse(null);
        return product1 != null;
    }

    //************************Counter Product ID*************************************
    public static int currentId = 0;

    {
        currentId++;
    }
}
