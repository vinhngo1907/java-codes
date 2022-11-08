import java.rmi.*;

public interface DiemInterface extends Remote{
	public String layDiem() throws RemoteException;
	public void ganDiem(int h, int t) throws RemoteException;
	public void doiDiem(int dx, int dy) throws RemoteException;
}