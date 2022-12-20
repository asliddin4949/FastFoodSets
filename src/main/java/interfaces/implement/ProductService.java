package interfaces.implement;

import Console.AdminConsole;
import data.Storage;
import interfaces.CreateReadUpdateDelete;
import model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ProductService implements CreateReadUpdateDelete {

    private static ProductService productService;

    public static ProductService getInstance() {
        if (productService != null) {
            productService = new ProductService();
        }
        return productService;
    }

    @Override
    public void add() {
        System.out.println("Enter Product Name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if (isExist(Storage.products, name)) {
            System.out.println("This Product has already added!");
        } else {
            scanner = new Scanner(System.in);
            System.out.println("Price: ");
            BigDecimal price = scanner.nextBigDecimal();
            Product product = new Product();
            product.setId(Product.currentId);
            product.setName(name);
            product.setPrice(price);
            Storage.products.add(product);
            System.out.println("Product successfully added!");
        }
        AdminConsole.adminConsole();
    }

    @Override
    public void show() {
        Storage.products.forEach(System.out::println);
    }

    @Override
    public void update() {
        Product product = getProduct();
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

    @Override
    public void delete() {
        Product product = getProduct();
        if (product != null) {
            for (Product stProduct : Storage.products) {
                if (stProduct.equals(product)) {
                    Storage.products.remove(product);
                }
            }
            System.out.println("Product Deleted!");
        } else {
            System.out.println("Wrong Product Id!");
        }
    }

    boolean isExist(List<Product> list, String name) {
        var productCheck = list.stream().filter(product -> product.getName().equals(name)).findFirst().orElse(null);
        return productCheck != null;
    }

    public Product getProduct() {
        show();
        System.out.println("Choose Product Id :");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        return Storage.products.stream().filter(product1 -> product1.getId() == id).findFirst().orElse(null);
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
