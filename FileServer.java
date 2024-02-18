import java.util.*;
import java.io.*;
import java.net.*;
public class FileServer implements Runnable{
	Socket socket;
	PrintWriter pw;
	String title = "", fileName = "";
	public FileServer(Socket socket){
		this.socket = socket;
	}
	public void run(){
		try{
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			Scanner scn = new Scanner(is);
			pw = new PrintWriter(os);
			//while(true){
				String request = scn.nextLine();
				System.out.println("Yeu cau tu client: "+request);
				if(request.equals("READ exit")) 
					socket.close();//break;
				tachFile(request);
				if(title.equals("READ")){
					File file = new File(fileName);
					if(file.exists()){
						pw.write("OK\n");
						//pw.flush();
						duyetFile(file);
					}else{
						System.out.println("Yeu cau khong hop le !");
						pw.write("ERROR\n");
						//pw.flush();
					}
					
					//pw.write("OK\n");
					//pw.flush();
					//duyetFile(file);
				}else{
					System.out.println("Yeu cau khong hop le !");
					pw.write("ERROR\n");
					//pw.flush();
				}
				
			socket.close();
			System.out.println("\n\nSocket closed: "+socket.getPort());
			//}
		}catch(IOException ex){
			System.out.println("LOi processing: "+ex.toString());
		}
	}
	public void tachFile(String request){
		request = request.trim();
		int i = request.lastIndexOf(" ");
		title = request.substring(0,i);
		fileName = request.substring(i+1);
	}
	public void duyetFile(File file){
		try{
			FileInputStream fis = new FileInputStream(file);
			System.out.println("Noi dung file yeu cau: ");
			while(true){
				int ch = fis.read();
				System.out.print((char)ch);
				if(ch == -1) break;
				pw.write(ch);
				pw.flush();
			}
			fis.close();
		}
		//catch(FileNotFoundException ex){
			//System.out.println("File khong ton tai !");	
			//pw.write("ERROR\n"); pw.flush();
		//}
		catch(IOException ex){
			System.out.println("Loi doc file !!!");
			//pw.write("ERROR\n"); pw.flush();
		}
	}
	public static void main(String[] args){
		try{
			ServerSocket server = new ServerSocket(9001);
			System.out.println("Server san sang phuc vu, lang nghe tren port: "+server.getLocalPort());
			while(true){
				Socket connect = server.accept();
				System.out.println("Welcome socket: "+connect.getPort());
				FileServer thread = new FileServer(connect);
				Thread luong = new Thread(thread);
				luong.start();
			}
		}catch(IOException ex){
			System.out.println("Loi server"+ex.toString());
		}
	}
}