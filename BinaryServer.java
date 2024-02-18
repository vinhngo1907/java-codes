import java.util.*;
import java.io.*;
import java.net.*;

public class BinaryServer{
    public static void main(String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(9000);
            System.out.println("Server started on port 9000");
            System.out.println("New client connection");
            while(true){
                Socket socket = ServerSocket.accept();
                System.out.println("Welcome socket "+socket.getPort());
                InputStream is = socket.getInputStream();
                OuputStream os = socket.getOutputStream();

                byte [] inputByte = new byte[500];
                int n = is.read(inputByte);
                String inputStr = new String(inputByte, 0, n);
                if(inputStr.equals("exit")){
                    break;
                }

                int inputInt = Integer.parseInt(inputStr);
                String binaryStr = Integer.toBinaryString(inputInt);
                os.write(binaryStr.getBytes());
            }
            socket.close();
            System.out.println("Socket close: "+socket.getPort());
        }catch(IOException ex){
            System.out.println("Server error: ", ex.toString());
        }
    }
}