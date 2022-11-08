import java.rmi.*;
import java.util.*;
import java.net.MalformedURLException;

public class FlightClient{
	public static void main(String[] args){
		try{
			Scanner sc = new Scanner(System.in);
			FlightInterface flightReference1 = (FlightInterface) Naming.lookup("rmi://127.0.0.1/Flight1");
			FlightInterface flightReference2 = (FlightInterface) Naming.lookup("rmi://127.0.0.1/Flight2");
			System.out.println("\t\tTHONG TIN CHUYEN BAY 1\t\t");
			System.out.println(flightReference1.getFlightInformation());
			System.out.println("============================");
			System.out.println("\t\tTHONG TIN CHUYEN BAY 2\t\t");
			System.out.println(flightReference2.getFlightInformation());
			System.out.println("============================");
			System.out.println();
			while(true){
				System.out.print("Nhap so hieu may bay: ");
				int soHieu = sc.nextInt();

				if(soHieu  == 10001){
					System.out.println("1: Dat ve");
					System.out.println("2: Tra ve");
					System.out.print("Nhap lua chon: ");
					int flag = sc.nextInt();
					if(flag == 1){
						System.out.print("Nhap so ve can dat: ");
						int soVe = sc.nextInt();
						if(flightReference1.buyTicket(soVe)){
							System.out.println("Dat ve thanh cong !");
						}else{
							System.out.println("Dat ve that bai !");
						}
					}else if(flag == 2){
						System.out.print("Nhap so ve can tra: ");
						int soVe = sc.nextInt();
						if(flightReference1.refundTicket(soVe)){
							System.out.println("Tra ve thanh cong !");
						}else{
							System.out.println("Tra ve that bai !");
						}
					}
					System.out.println("\t\tTHONG TIN CHUYEN BAY 1\t\t");
					System.out.println(flightReference1.getFlightInformation());
				}else if(soHieu == 10002){
					System.out.println("1: Dat ve");
					System.out.println("2: Tra ve");
					System.out.print("Nhap lua chon: ");
					int flag = sc.nextInt();
					if(flag == 1){
						System.out.print("Nhap so ve can dat: ");
						int soVe = sc.nextInt();
						if(flightReference2.buyTicket(soVe)){
							System.out.println("Dat ve thanh cong !");
						}else{
							System.out.println("Dat ve that bai !");
						}
					}else if(flag == 2){
						System.out.print("Nhap so ve can tra: ");
						int soVe = sc.nextInt();
						if(flightReference2.refundTicket(soVe)){
							System.out.println("Tra ve thanh cong !");
						}else{
							System.out.println("Tra ve that bai !");
						}
					}
					System.out.println("\t\tTHONG TIN CHUYEN BAY 2\t\t");
					System.out.println(flightReference2.getFlightInformation());
				}else if(soHieu == 0){
					System.out.println("END");
					break;
				}else{
					System.out.println("Chuyen bay khong ton tai!");
					break;
				}
			}
		}catch(NotBoundException ex){
			System.out.println(ex.toString());
		}catch(RemoteException ex){
			System.out.println(ex.toString());
		}catch(MalformedURLException ex){
			System.out.println(ex);
		}
	}
}