import javax.swing.*;
import java.awt.*;

/**
 * Created by Simon on 5/24/2017.
 */
public class Panel extends JPanel{
    public static void main(String[] args) {

        JFrame window = new JFrame("Template");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, 2560, 1440); //(x, y, w, h)

        Panel panel = new Panel();
        window.add(panel);

        window.setVisible(true);
        panel.setFocusable(true);
        panel.requestFocusInWindow();


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.fillRect(10,10,10,10);
    }
}
