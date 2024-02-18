import java.util.*;
import java.io.*;
import java.net.*;

public class FileClient{
	public static void main(String[]args){
		try{
			Socket socket = new Socket("localhost",9001);
			System.out.println("Ket noi toi server tren port: "+socket.getPort());
			Scanner sc = new Scanner(System.in);
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			Scanner scn = new Scanner(is);
			PrintWriter pw = new PrintWriter(os);
			while(true){
				System.out.print("Nhap ho ten: ");
				String request = sc.nextLine();
				pw.println("READ "+request); 
				pw.flush();
				if(request.equals("exit")) 
					//socket.close();
					break;
				System.out.println("...gui yeu cau xong, cho phan hoi tu server");
				String response = br.readLine();
				System.out.println("Phan hoi tu server: "+response);
				switch(response){
					case"OK":
						System.out.println("File ton tai tren server, bat dau download...");
						System.out.print("File "+request+" save as with new name: ");
						sc = new Scanner(System.in);
						String fileName = sc.nextLine();
						FileOutputStream fos = new FileOutputStream(fileName);
						System.out.println("Noi dung file can luu: ");
						while(true){
							int ch = br.read();
							System.out.print((char)ch);
							if(ch == -1) break;
							fos.write(ch);
							pw.flush();
						}
						fos.close();
						System.out.println("Nhan file xong, bat dau luu file....");
						System.out.println("Luu file xong !!!");
						break;
					case"ERROR":
						System.out.println("File khong ton tai tren server\nDownload that bai !!!\n");
						break;
				}
			}
			socket.close();
		}catch(IOException ex){
			System.out.println(ex.toString());
		}
	}
}