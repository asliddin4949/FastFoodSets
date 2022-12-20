package interfaces.implement;

import data.Storage;
import interfaces.Update;
import model.Product;

import java.math.BigDecimal;
import java.util.Scanner;

public class UpdateProduct implements Update {
    private static UpdateProduct updateProduct;

    public static UpdateProduct getInstance() {
        if (updateProduct == null) {
            updateProduct = new UpdateProduct();
        }
        return updateProduct;
    }

    @Override
    public void update() {
        Product product = new Product();
        product = product.getProduct();
        if (product != null) {
            while (true) {
                int command = chooseUpdateField(product);
                if (command == 1) {
                    changeName(product);
                } else if (command == 2) {
                    changePrice(product);
                } else if (command == 0) {
                    break;
                } else {
                    System.out.println("Wrong command!");
                }
            }

        } else {
            System.out.println("Entered wrong Id!");
        }
    }

    private int chooseUpdateField(Product product) {
        System.out.println(product);
        System.out.println("'1' - \"Change Name\"  '2' - \"Change Price\"  '0' - \"go back\"");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void changeName(Product product) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter New Product Name:");
        String name = scanner.nextLine();
        for (Product storageProduct : Storage.products) {
            if (storageProduct.equals(product)) {
                storageProduct.setName(name);
            }
        }
        System.out.println("Product Name Changed!");
    }

    private void changePrice(Product product) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter New Product Price:");
        BigDecimal price = scanner.nextBigDecimal();
        for (Product storageProduct : Storage.products) {
            if (storageProduct.equals(product)) {
                storageProduct.setPrice(price);
            }
        }
        System.out.println("Product Price Changed");
    }
}
