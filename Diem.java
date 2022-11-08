import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
public class Diem extends UnicastRemoteObject implements DiemInterface{
	private int x;
	private int y;
	public Diem() throws RemoteException{
		super();
	}
	public  Diem(int dx, int dy) throws RemoteException{
		super();
		this.x = dx;
		this.y = dy;
	}
	public String layDiem(){
		String result = "";
		result+="("+x+", "+y+")";
		return result;
	}
	
	public void nhapDiem(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap hoanh do x = ");
		x = sc.nextInt();
		System.out.print("Nhap tung do y = ");
		y = sc.nextInt();
	}

	public void ganDiem(int h, int t){
		x = h; y = t;
	}
	public void doiDiem(int dx, int dy){
		x+=dx; 
		y+=dy;
	}
}