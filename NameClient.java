import java.util.*;
import java.io.*;
import java.net.*;

public class NameClient{
	public static void main(String[]args){
		try{
			Socket socket = new Socket("localhost",9001);
			System.out.println("Ket noi toi server tren port: "+socket.getPort());
			Scanner sc = new Scanner(System.in);
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			while(true){
				System.out.print("Nhap ho ten: ");
				String request = sc.nextLine();
				os.write(request.getBytes());
				if(request.equals("exit")) break;
				byte[] inputByte = new byte[500];
				String resultStr = new String(inputByte,0,is.read(inputByte));
				System.out.println("Result: "+resultStr);
			}
			socket.close();
		}catch(IOException ex){
			System.out.println(ex.toString());
		}
	}
}