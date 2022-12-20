package interfaces.implement;

import data.Storage;
import interfaces.Delete;
import model.Product;


public class DeleteProduct implements Delete {

    private static DeleteProduct deleteProduct;

    public static DeleteProduct getInstance() {
        if (deleteProduct == null) {
            deleteProduct = new DeleteProduct();
        }
        return deleteProduct;
    }

    public void delete() {
        Product product = new Product();
        product = product.getProduct();
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

}
