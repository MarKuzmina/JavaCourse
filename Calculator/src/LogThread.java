import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogThread extends Thread {
    private String login;
    public static File logFile;
    private static boolean isFileExist = false;
    private String printStr;
    public static int lineCount = 1;
    public static int fileCount = 0;

    LogThread(String login, String str)
    {
        this.login = login;
        printStr = str;
    }

    @Override
    public void run() {
        createAndWriteLog(printStr);
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
            if(!isFileExist)
            {
                createFile("calc.log");
                isFileExist = true;
            }
            FileWriter writer = new FileWriter(logFile.getPath(), true);
            writer.append(System.getProperty("line.separator") + login + "\t" + str + "\t" + formatForDateNow.format(dateNow));
            lineCount++;
            writer.close();
            if ((lineCount%10)==0)
            {
                lineCount = 0;
                fileCount++;
                logFile.renameTo(new File("C:\\GitProject\\JavaCourse\\Calculator\\calc.log"+ fileCount + ".txt"));
                createFile("calc.log");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
