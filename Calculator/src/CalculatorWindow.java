import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorWindow extends JFrame {
    private JFrame windowFrame2;
    private final int height = 400;
    private final int width = 300;
    public JTextField resultTextField;
    private JButton numeral0Button;
    private JButton numeral1Button;
    private JButton numeral2Button;
    private JButton numeral3Button;
    private JButton numeral4Button;
    private JButton numeral5Button;
    private JButton numeral6Button;
    private JButton numeral7Button;
    private JButton numeral8Button;
    private JButton numeral9Button;
    private JButton sumButton;
    private JButton differenceButton;
    private JButton multiplicationButton;
    private JButton divisionButton;
    private JButton calculateButton;
    private JButton pointButton;
    public  char operation;
    private String login;
    private Calculate calc;
    private MyCache myCache;
    private LogThread logThread;

    public CalculatorWindow(String _login) {
        myCache = new MyCache();
        login = _login;
        windowFrame2 = new JFrame("Calculator");
        windowFrame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        windowFrame2.setSize(width, height);
        windowFrame2.setLocationRelativeTo(null);
        windowFrame2.setResizable(false);
        windowFrame2.setVisible(true);
        windowFrame2.setLayout(null);

        resultTextField = new JTextField();
        resultTextField.setSize(265, 45);
        resultTextField.setLocation(10, 10);
        resultTextField.setVisible(true);
        windowFrame2.getContentPane().add(resultTextField);

        sumButton = new MyButton(windowFrame2, "+", 45, 45, 10, 65);
        differenceButton = new MyButton(windowFrame2, "-", 45, 45, 64, 65);
        multiplicationButton = new MyButton(windowFrame2, "*", 45, 45, 119, 65);
        divisionButton = new MyButton(windowFrame2, "/", 45, 45, 174, 65);
        calculateButton = new MyButton(windowFrame2, "=", 45, 45, 229, 65);
        numeral1Button = new MyButton(windowFrame2, "1", 80, 50, 10, 120);
        numeral2Button = new MyButton(windowFrame2, "2", 80, 50, 102, 120);
        numeral3Button = new MyButton(windowFrame2, "3", 80, 50, 194, 120);
        numeral4Button = new MyButton(windowFrame2, "4", 80, 50, 10, 180);
        numeral5Button = new MyButton(windowFrame2, "5", 80, 50, 102, 180);
        numeral6Button = new MyButton(windowFrame2, "6", 80, 50, 194, 180);
        numeral7Button = new MyButton(windowFrame2, "7", 80, 50, 10, 240);
        numeral8Button = new MyButton(windowFrame2, "8", 80, 50, 102, 240);
        numeral9Button = new MyButton(windowFrame2, "9", 80, 50, 194, 240);
        numeral0Button = new MyButton(windowFrame2, "0", 170, 50, 10, 300);
        pointButton = new MyButton(windowFrame2, ".", 80, 50, 194, 300);


        numeral0Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultTextField.setText(resultTextField.getText() + "0");
            }
        });
        numeral1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultTextField.setText(resultTextField.getText() + "1");
            }
        });
        numeral2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultTextField.setText(resultTextField.getText() + "2");
            }
        });
        numeral3Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultTextField.setText(resultTextField.getText() + "3");
            }
        });
        numeral4Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultTextField.setText(resultTextField.getText() + "4");
            }
        });
        numeral5Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultTextField.setText(resultTextField.getText() + "5");
            }
        });
        numeral6Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultTextField.setText(resultTextField.getText() + "6");
            }
        });
        numeral7Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultTextField.setText(resultTextField.getText() + "7");
            }
        });
        numeral8Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultTextField.setText(resultTextField.getText() + "8");
            }
        });
        numeral9Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultTextField.setText(resultTextField.getText() + "9");
            }
        });
        pointButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultTextField.setText(resultTextField.getText() + ".");
            }
        });
        sumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultTextField.setText(resultTextField.getText() + "+");
                operation = '+';
            }
        });
        differenceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultTextField.setText(resultTextField.getText() + "-");
                operation = '-';
            }
        });
        multiplicationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultTextField.setText(resultTextField.getText() + "*");
                operation = '*';
            }
        });
        divisionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultTextField.setText(resultTextField.getText() + "/");
                operation = '/';
            }
        });
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = resultTextField.getText();
                calc = new Calculate(str,myCache);
                logThread = new LogThread(login,str);
                logThread.start();
                String S1 = Double.toString(calc.fCalculate());
                resultTextField.setText(S1);
            }
        });
    }
}

