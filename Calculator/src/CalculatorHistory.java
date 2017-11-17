import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalculatorHistory {
    private String login;
    public File logFile;
    public int lineCount = 0;
    public int fileCount = 0;


    public CalculatorHistory(String _login) {
        login = _login;
        createFile("calc.log");
    }

    private void createFile(String name)
    {
        FileWriter writeFile = null;
        try {
            logFile = new File("C:\\GitProject\\JavaCourse\\Calculator\\" + name + ".txt");
            writeFile = new FileWriter(logFile.getPath(), true);
            writeFile.append("USER\t" + "Operation\t" + "Date/time");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writeFile != null) {
                try {
                    writeFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void createAndWriteLog(String str) {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd 'и время' hh:mm:ss a zzz");
        try {
            String data = System.getProperty("line.separator") + login + "\t" + str + "\t" + formatForDateNow.format(dateNow);
            FileWriter writer = new FileWriter(logFile.getPath(), true);
            writer.append(System.getProperty("line.separator") + login + "\t" + str + "\t" + formatForDateNow.format(dateNow));
            lineCount++;
            writer.close();
            if ((lineCount%10)==0)
            {
                fileCount++;
                logFile.renameTo(new File("C:\\GitProject\\JavaCourse\\Calculator\\calc.log"+ fileCount + ".txt"));
                createFile("calc.log");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
