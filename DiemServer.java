import java.rmi.*;
import java.net.MalformedURLException;

public class DiemServer{
	public static void main(String[] args){
		if(System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());
		try{
			Diem a = new Diem();
			Diem b = new Diem(10,20);
			Diem c = new Diem();
			System.out.println("Nhap gia tri diem c");
			c.nhapDiem();
			Naming.rebind("DiemA",a);
			Naming.rebind("DiemB",b);
			Naming.rebind("DiemC",c);
			System.out.println("Tao cac diem toa do thanh cong !");
		}catch(RemoteException ex){
			System.out.println(ex.toString());
		}catch(MalformedURLException ex){
			System.out.println(ex.toString());
		}
	}
}