import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost",12345);
            System.out.println("Connected with Server!");

            DataOutputStream dataOS = new DataOutputStream(socket.getOutputStream());
            dataOS.writeUTF("Hello, ITs CLIENT!!");
            dataOS.flush();

            DataInputStream dataIS = new DataInputStream(socket.getInputStream());
            System.out.println(dataIS.readUTF() + "From SERVER");
        }
        catch (IOException e){
            e.printStackTrace();
        }



    }
}
