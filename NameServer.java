import java.util.*;
import java.io.*;
import java.net.*;
public class NameServer implements Runnable{
	Socket socket;
	String name = "";
	public NameServer(Socket socket){
		this.socket = socket;
	}
	public void run(){
		try{
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			while(true){
				byte[] requestByte = new byte[500];
				String request = new String(requestByte,0,is.read(requestByte));
				if(request.equals("exit")) break;
				tachTen(request);
				os.write(name.getBytes());
			}
			socket.close();
			System.out.println("Socket closed: "+socket.getPort());
		}catch(IOException ex){
			System.out.println("LOi processing: "+ex.toString());
		}
	}
	public void tachTen(String request){
		request = request.trim();
		int i = request.lastIndexOf(" ");
		name = request.substring(i+1);
	}
	public static void main(String[] args){
		try{
			ServerSocket server = new ServerSocket(9001);
			System.out.println("Server san sang phuc vu, lang nghe tren port: "+server.getLocalPort());
			while(true){
				Socket connect = server.accept();
				System.out.println("Welcome socket: "+connect.getPort());
				NameServer thread = new NameServer(connect);
				Thread luong = new Thread(thread);
				luong.start();
			}
		}catch(IOException ex){
			System.out.println("Loi server"+ex.toString());
		}
	}
}