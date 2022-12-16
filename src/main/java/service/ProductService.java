package service;

import data.Storage;
import interfaces.Admin;
import model.Product;

import java.math.BigDecimal;
import java.util.Scanner;

public class ProductService {
    public static void addProduct(){
        System.out.println("Enter Product Name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Product product = new Product();
        if(product.isExist(Storage.products,name)){
            System.out.println("This Product has already added!");
            Admin.adminMenu();
        }else {
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
    public static void showProducts() {
        Storage.products.forEach(System.out::println);
    }
}
