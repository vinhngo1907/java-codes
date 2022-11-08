import java.util.*;
import java.io.*;
import java.net.*;
public class DirectoryServer extends Thread{
	Socket socket;
	PrintWriter pw;
	String title = "", directory = "";
	public DirectoryServer(Socket socket){
		this.socket = socket;
	}
	public void run(){
		try{
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			Scanner scn = new Scanner(is);
			pw = new PrintWriter(os);
			while(true){
				String request = scn.nextLine();
				System.out.println("Yeu cau tu client: "+request);
				if(request.equals("LIST exit")) break;
				tachYeuCau(request);
				if(title.equals("LIST")){
					File file = new File(directory);
					if(file.isDirectory()){
						duyetThuMuc(file);
						pw.println(".");
						pw.flush();
					}else{
						System.out.println("Thu muc khong ton tai !");
						pw.println(".");
						pw.flush();
					}
				} else{
					System.out.println("Yeu cau khong hop le !");
					pw.println(".");pw.flush();
				}
			}
			socket.close();
			System.out.println("Socket closed: "+socket.getPort());
		}catch(IOException ex){
			System.out.println("LOi processing: "+ex.toString());
		}
	}
	public void tachYeuCau(String request){
		request = request.trim();
		int i = request.lastIndexOf(" ");
		title = request.substring(0,i);
		directory = request.substring(i+1);
	}
	public void duyetThuMuc(File file){
		String path = file.getAbsolutePath();
		pw.println(path);pw.flush();
		if(file.isDirectory()){
			File[] listFile = file.listFiles();
			for(File item: listFile){
				duyetThuMuc(item);
			}
		}
	}
	public static void main(String[] args){
		try{
			ServerSocket server = new ServerSocket(8129);
			System.out.println("Server san sang phuc vu, lang nghe tren port: "+server.getLocalPort());
			while(true){
				Socket connect = server.accept();
				System.out.println("Welcome socket: "+connect.getPort());
				DirectoryServer thread = new DirectoryServer(connect);
				//Thread luong = new Thread(thread);
				//luong.start();
				DirectoryServer luong = new DirectoryServer(connect);
				luong.start();
			}
		}catch(IOException ex){
			System.out.println("Loi server"+ex.toString());
		}
	}
}