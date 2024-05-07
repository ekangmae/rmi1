import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            System.out.println("Server has been started...");

            Product Laptop = new Product(1001, "Laptop", "Lenovo Laptop ", 10, 35900.91, 36000.00);
            Product MobilePhone = new Product(1002, "Mobile Phone", "iPhone 11", 20, 29630.72, 30999.00);
            Product Charger = new Product(1003, "Charger", "Lenovo Charger", 30, 453.55, 499.00);
            Product PowerBank = new Product(1004, "Power Bank", "Panasonic Power Bank", 40, 958.12, 1000.00);
            Cart cart = new Cart();

            ProductInterface stub_laptop = (ProductInterface) UnicastRemoteObject.exportObject(Laptop, 0);
            ProductInterface stub_mobilePhone = (ProductInterface) UnicastRemoteObject.exportObject(MobilePhone, 0);
            ProductInterface stub_charger = (ProductInterface) UnicastRemoteObject.exportObject(Charger, 0);
            ProductInterface stub_powerBank = (ProductInterface) UnicastRemoteObject.exportObject(PowerBank, 0);
            CartInterface stub_cart = (CartInterface) UnicastRemoteObject.exportObject(cart, 0);

            Registry registry = LocateRegistry.createRegistry(2099);

            registry.rebind("laptop", stub_laptop);
            registry.rebind("mobilePhone", stub_mobilePhone);
            registry.rebind("charger", stub_charger);
            registry.rebind("powerBank", stub_powerBank);
            registry.rebind("cart", stub_cart);

            System.out.println("Exporting and binding of Objects has been completed...");

            System.out.println("Processing all products...");
            Laptop.ViewProducts();
            MobilePhone.ViewProducts();
            Charger.ViewProducts();
            PowerBank.ViewProducts();

        } catch (Exception e) {
            System.out.println("Some server error..." + e);
        }
    }
}
