import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        boolean allowSignIn = false;
        try{
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Waiting for Client");
            Socket socket = server.accept();
            System.out.println("Connected with Client");

            String loginFromClient ="";

            DataInputStream dataIS = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOS = new DataOutputStream(socket.getOutputStream());
            while(!allowSignIn) {
                loginFromClient = dataIS.readUTF();
                String passwordFromClient = dataIS.readUTF();

                SignIn signIn = new SignIn(loginFromClient, passwordFromClient);
                String type = dataIS.readUTF();
                if (type.equals("registration")) {
                    signIn.checkInFile();
                    dataOS.writeUTF("Success registration");
                }
                else {
                    allowSignIn = signIn.signIn();
                    dataOS.writeBoolean(allowSignIn);
                }
                System.out.println(loginFromClient + " " + passwordFromClient + " From client");
            }
            //boolean calculatorIsOpen = dataIS.readBoolean();
            //System.out.println(" calculatorIsOpen = "+ calculatorIsOpen);
            boolean needCalculate = dataIS.readBoolean();
            System.out.println(" needCalculate = "+ needCalculate);
            //while(calculatorIsOpen)
            //{
                while (needCalculate)
                {
                    Double a = dataIS.readDouble();
                    System.out.print(" a = "+ a);
                    Double b = dataIS.readDouble();
                    System.out.print("; b = "+ b);
                    char operation = dataIS.readChar();
                    System.out.println("; operation = "+ operation);
                    Operation currentOperation = new Operation(a, b, operation);
                    dataOS.writeDouble(currentOperation.result);
                    LogThread thread = new LogThread(loginFromClient,currentOperation.toString());
                    thread.start();
                    needCalculate = dataIS.readBoolean();
                    System.out.println(" needCalculate = "+ needCalculate);
                }
               // calculatorIsOpen = dataIS.readBoolean();  //get Need continue calculation or NOT
             //   System.out.println(" calculatorIsOpen = "+ calculatorIsOpen);
            //}

            socket.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
