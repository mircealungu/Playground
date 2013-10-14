import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*; 
 
public class RmiServer
    extends UnicastRemoteObject 
    implements RmiServerIntf {
    static int clientCount = 0;
    public static final String MESSAGE = "Hello world";
 
    public RmiServer() throws RemoteException {
        super(0);    // required to avoid the 'mic' step, see below
    }
 
    public String getMessage() {
        clientCount += 1;
        return MESSAGE + " (" + clientCount + ")";
    }
 
    public static void main(String args[]) throws Exception {
        System.out.println("RMI server started");
 
        try { //special exception handler for registry creation
            LocateRegistry.createRegistry(1099); 
            System.out.println("java RMI registry created.");
        } catch (RemoteException e) {
            //do nothing, error means registry already exists
            System.out.println("java RMI registry already exists.");
        }
 
        //Instantiate RmiServer
        RmiServer obj = new RmiServer();
 
        // Bind this object instance to the name "RmiServer"
        Naming.rebind("//localhost/RmiServer", obj);
        System.out.println("PeerServer bound in registry");
    }
}


