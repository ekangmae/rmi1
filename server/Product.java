import java.rmi.RemoteException;

public class Product implements ProductInterface {
    private int productCode;
    private String name;
    private String description;
    private int quantity;
    private double retailPrice;
    private double storePrice;

    public Product(int productCode, String name, String description, int quantity, double retailPrice, double storePrice) throws RemoteException {
        this.productCode = productCode;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.retailPrice = retailPrice;
        this.storePrice = storePrice;
    }

    public int getProductCode() throws RemoteException {
        return productCode;
    }

    public String getName() throws RemoteException {
        return name;
    }

    public String getDescription() throws RemoteException {
        return description;
    }

    public int getQuantity() throws RemoteException {
        return quantity;
    }

    public double getRetailPrice() throws RemoteException {
        return retailPrice;
    }

    public double getStorePrice() throws RemoteException {
        return storePrice;
    }

    public String ViewProducts() throws RemoteException {
        return  "------------------------\nProduct Code: " + this.productCode +
                "\nName: " + this.name +
                "\nDescription: " + this.description +
                "\nQuantity: " + this.quantity +
                "\nRetail Price: " + this.retailPrice +
                "\nStore Price: " + this.storePrice;
    }
    public void decrementQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }
    
}