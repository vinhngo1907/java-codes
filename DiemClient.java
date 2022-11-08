import java.rmi.*;
import java.net.MalformedURLException;

public class DiemClient{
	public static void main(String[] args){
		try{
			DiemInterface diemReferenceA = (DiemInterface) Naming.lookup("rmi://127.0.0.1/DiemA");
			DiemInterface diemReferenceB = (DiemInterface) Naming.lookup("rmi://127.0.0.1/DiemB");
			DiemInterface diemReferenceC = (DiemInterface) Naming.lookup("rmi://127.0.0.1/DiemC");
			System.out.println("\t\t\tTOA DO DIEM A\t\t\t");
			System.out.println("Diem A"+diemReferenceA.layDiem());
			System.out.println("Diem B"+diemReferenceB.layDiem());
			System.out.println("Diem C"+diemReferenceC.layDiem());
		}catch(NotBoundException ex){
			System.out.println(ex.toString());
		}catch(RemoteException ex){
			System.out.println(ex.toString());
		}catch(MalformedURLException ex){
			System.out.println(ex.toString());
		}
	}
}