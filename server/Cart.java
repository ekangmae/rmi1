import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Cart implements CartInterface {
    private List<ProductInterface> addedProducts;
    private int totalProducts;
    private double totalAmount;

    public Cart() throws RemoteException {
        this.addedProducts = new ArrayList<>();
        this.totalProducts = 0;
        this.totalAmount = 0.0;
    }

   
    public String addProduct(ProductInterface product) throws RemoteException {
        addedProducts.add(product);
        product.getName();
        product.decrementQuantity();
        totalProducts++;
        totalAmount += product.getStorePrice();
        System.out.println("Customer has successfully added product to cart.");
        return product.getName();
    }


    public String viewAddedProducts() throws RemoteException {
        StringBuilder stringBuilder = new StringBuilder();
        for (ProductInterface product : addedProducts) {
            stringBuilder.append(product.getName()).append("\n");
        }
        System.out.println("Customer is now viewing the cart.");
        return stringBuilder.toString();
    }

    public String summary() throws RemoteException {
        System.out.println("Admin is now viewing the summary of products.");
        return "Total products: " + totalProducts + "\nTotal amount: " + totalAmount;
    }
}
