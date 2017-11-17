import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInWindow extends JFrame {
    private JFrame windowFrame;
    private final int height = 150;
    private final int width = 320;
    private JTextField loginTextField;
    private JLabel inLoginLabel;
    private JPasswordField passwotdTextField;
    private JLabel inPasswordlLabel;
    private JButton inputButton;
    private JButton checkInButton;

    public SignInWindow() {
        windowFrame = new JFrame("Sign In");
        windowFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        windowFrame.setSize(width, height);
        windowFrame.setLocationRelativeTo(null);
        windowFrame.setResizable(false);
        windowFrame.setVisible(true);
        windowFrame.setLayout(null);

        inLoginLabel = new JLabel();
        inLoginLabel.setText("Input login");
        inLoginLabel.setSize(80,15);
        inLoginLabel.setLocation(10,12);
        inLoginLabel.setVisible(true);
        windowFrame.getContentPane().add(inLoginLabel);

        loginTextField = new JTextField();
        loginTextField.setSize(160,20);
        loginTextField.setLocation(137, 10);
        loginTextField.setVisible(true);
        windowFrame.getContentPane().add(loginTextField);

        inPasswordlLabel = new JLabel();
        inPasswordlLabel.setText("Input password");
        inPasswordlLabel.setSize(90,15);
        inPasswordlLabel.setLocation(10,43);
        inPasswordlLabel.setVisible(true);
        windowFrame.getContentPane().add(inPasswordlLabel);

        passwotdTextField = new JPasswordField();
        passwotdTextField.setSize(160,20);
        passwotdTextField.setLocation(137, 40);
        passwotdTextField.setVisible(true);
        passwotdTextField.setEchoChar('*');
        windowFrame.getContentPane().add(passwotdTextField);


        inputButton = new MyButton(windowFrame, "Sign in", 110, 20, 30, 80);
        checkInButton = new MyButton(windowFrame, "Check in", 110, 20, 155, 80);

        checkInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String login = loginTextField.getText();
                String password = passwotdTextField.getText();
                    SignIn signIn = new SignIn(login, password);
                    signIn.checkInFile();
            }
        });
        inputButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String login = loginTextField.getText();
                String password = passwotdTextField.getText();
                SignIn signIn = new SignIn(login, password);
                signIn.signIn();

            }
        });

    }
}
