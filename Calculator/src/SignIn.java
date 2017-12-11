import javax.swing.*;
import java.io.*;

public class SignIn {
    public String login;
    public  String password;

    public  SignIn (String _login, String _password) {
        login = _login;
        password = _password;
    }

    public void checkInFile(){
        FileWriter writeFile = null;
        File logFile = new File("C:\\GitProject\\JavaCourse\\Calculator\\SignIn.txt");
        String lineSeparator = System.getProperty("line.separator");
        try {
            writeFile = new FileWriter(logFile);
            writeFile.append(login);
            writeFile.append(lineSeparator + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writeFile != null) {
                try {
                    writeFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public  boolean signIn() {
        boolean result = false;
        String loginFile;
        String passwordFile;

        try {
            File file = new File("C:\\GitProject\\JavaCourse\\Calculator\\SignIn.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            loginFile = reader.readLine();
            passwordFile = reader.readLine();

            if (loginFile.equals(login) && passwordFile.equals(password)) {
                result = true;
                //new CalculatorWindow(login);
            }
            else {
                result = false;//JOptionPane.showMessageDialog(null, "Неверный логин или пароль");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}



