import java.io.*;
import java.net.*;
import java.util.*;

public class DirectoryClient{
	public static void main(String[] args){
		try{
			Socket socket = new Socket("localhost",8129);
			System.out.println("Ket noi toi server tren port: "+socket.getPort());
			Scanner sc = new Scanner(System.in);
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			Scanner scn = new Scanner(is);
			PrintWriter pw = new PrintWriter(os);
			
			while(true){
				System.out.print("Nhap yeu cau: ");
				String request = sc.nextLine();
				pw.println("LIST "+request);
				pw.flush();
				if(request.equals("exit")) break;
				System.out.println("Noi dung thu muc: ");
				while(true){
					String resultStr = scn.nextLine();
					if(resultStr.equals(".")) break;
					System.out.println(resultStr);
				}
			}
			socket.close();
		}catch(IOException ex){
			System.out.println("Loi client: "+ex.toString());
		}
	}
}