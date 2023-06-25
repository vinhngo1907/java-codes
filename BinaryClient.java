import java.util.*;
import java.io.*;
import java.net.*;

public class BinaryClient{
    public static void main(String[]args){
        try{
            Socket socket = new Socket("localhost",9001);
            InputStream is = socket.InputStream();
            OutputStream os = socket.OutputStream();
            Scanner scn = new Scanner(System.in);
            System.out.print("Input String Number: ");
            String inputStr = scn.nextLine();

            byte [] inputByte= inputStr.getBytes();
            os.write(inputByte);

            byte [] resultByte = new byte[500];
            int n = is.read(resultByte);
            String inputStr = new String(inputByte, 0, n);
            System.out.println("Result: "+inputStr);

        }catch(IOException ex){
            System.out.println("Client error: "+ex.toString());
        }
    }
}