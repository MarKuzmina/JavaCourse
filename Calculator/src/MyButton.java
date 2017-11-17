import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {
    MyButton(JFrame mainFrame,String text, int width, int height, int x, int y)
    {
        super(text);
        setSize(width,height);
        setLocation(x,y);
        setVisible(true);
        setFont(new Font("Arial", Font.PLAIN, 18));
        mainFrame.add(this);
    }
}
