import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RollingTextApplet extends JPanel {
    private String text1 = "Happy";
    private String text2 = "Deepavali";
    private int y1 = 0; // Initial position of text1
    private int y2 = 300; // Initial position of text2

    public RollingTextApplet() {
        Timer timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (y1<=140){
                    y1 += 5; // Move text1 downwards
                }
                if (y2>=165){
                    y2 -= 5; // Move text2 upwards
                }
                repaint(); // Repaint the panel
            }
        });
        timer.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(text1, 100, y1);
        g.drawString(text2, 100, y2);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rolling Text Applet");
        RollingTextApplet applet = new RollingTextApplet();
        frame.add(applet);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }}
