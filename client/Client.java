import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 2099);

            ProductInterface p1 = (ProductInterface) registry.lookup("laptop");
            ProductInterface p2 = (ProductInterface) registry.lookup("mobilePhone");
            ProductInterface p3 = (ProductInterface) registry.lookup("charger");
            ProductInterface p4 = (ProductInterface) registry.lookup("powerBank");
            CartInterface cart = (CartInterface) registry.lookup("cart");

            System.out.print("Enter user type (1=user-admin, 2=user-customer): ");
            int userType = scanner.nextInt();
            if (userType == 1) {
                System.out.println("\nAll Products");
                System.out.println(p1.ViewProducts());
                System.out.println(p2.ViewProducts());
                System.out.println(p3.ViewProducts());
                System.out.println(p4.ViewProducts());

                System.out.print("\nType 'summary' to view summary: ");
                String summaryOption = scanner.next();
                if ("summary".equalsIgnoreCase(summaryOption)) {
                    System.out.println("\nSummary:");
                    System.out.println(cart.summary());
                }

                
            } else if (userType == 2) {
            int choice = 0;
            while (choice != 4) {
                System.out.println("\n\n ==== Menu ==== \n");
                System.out.println("1. View All Products");
                System.out.println("2. Add product to cart");
                System.out.println("3. View added products in cart");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                    System.out.println("\nAll Products");
                    System.out.println(p1.ViewProducts());
                    System.out.println(p2.ViewProducts());
                    System.out.println(p3.ViewProducts());
                    System.out.println(p4.ViewProducts());
                        break;
                    case 2:
                        System.out.print("\nEnter product code to add to cart: ");
                        int productCode = scanner.nextInt();
                        ProductInterface selectedProduct = getProductByCode(productCode, p1, p2, p3, p4);
                        if (selectedProduct != null) {
                            System.out.println("\nProduct added to cart:\n"+ cart.addProduct(selectedProduct));
                        } else {
                            System.out.println("Invalid product code.");
                        }
                        break;
                    case 3:
                        System.out.println("\nProducts in cart:\n"+ cart.viewAddedProducts()); 
                        break;
                    case 4:
                        System.out.println("\nExiting...");
                        break;  
                    default:
                        System.out.println("\nInvalid choice. Please try again.");
                        break;
                    }
                }
            } else {
                System.out.println("Invalid user type.");
            }
        } catch (Exception e) {
            System.out.println("Client exception: " + e.toString());
            e.printStackTrace();
        } finally {
            scanner.close(); // Close the Scanner
        }
    }

    private static ProductInterface getProductByCode(int code, ProductInterface... products) {
        for (ProductInterface product : products) {
            try {
                if (product.getProductCode() == code) {
                    return product;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}