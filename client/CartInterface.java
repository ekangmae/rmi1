import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CartInterface extends Remote {
    String addProduct(ProductInterface product) throws RemoteException;
    String viewAddedProducts() throws RemoteException;
    String summary() throws RemoteException;
}
