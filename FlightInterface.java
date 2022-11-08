import java.rmi.RemoteException;
import java.rmi.Remote;

public interface FlightInterface extends Remote{
	public String getFlightInformation() throws RemoteException;
	public boolean buyTicket(int numberOfTicket) throws RemoteException;
	public boolean refundTicket(int numberOfTicket) throws RemoteException;
}