import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RollingTextApplet extends JApplet implements ActionListener {
    private String message1 = "Happy";
    private String message2 = "Deepavali";
    private Timer timer;

    private int yOffset1 = 0;
    private int yOffset2 = 0;

    public void init() {
        timer = new Timer(50, this); // 50 milliseconds delay between actions
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g.create(); // create a copy of the graphics object
        Font font = new Font("Arial", Font.BOLD, 20);
        g2d.setFont(font);

        // Calculate the center of the applet
        int centerX = getWidth() / 2;

        // Draw "Happy" rolling from top to bottom
        int textWidth1 = g2d.getFontMetrics().stringWidth(message1);
        g2d.drawString(message1, centerX - textWidth1 / 2, yOffset1);

        // Draw "Deepavali" rolling from bottom to top
        int textWidth2 = g2d.getFontMetrics().stringWidth(message2);
        g2d.drawString(message2, centerX - textWidth2 / 2, getHeight() - yOffset2);

        // Check if both messages reached the center
        if (yOffset1 >= getHeight() / 2 && yOffset2 >= getHeight() / 2) {
            timer.stop(); // Stop the animation when both messages reach the center
        }

        g2d.dispose(); // dispose the graphics object
    }

    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(() -> {
            yOffset1 += 5; // Adjust the speed as needed
            yOffset2 += 5; // Adjust the speed as needed
            repaint();
        });
    }
}
