import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProductInterface extends Remote {
    int getProductCode() throws RemoteException;
    String getName() throws RemoteException;
    String getDescription() throws RemoteException;
    int getQuantity() throws RemoteException;
    double getRetailPrice() throws RemoteException;
    double getStorePrice() throws RemoteException;
    String ViewProducts() throws RemoteException;
    void setQuantity(int i);
}