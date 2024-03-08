import javax.swing.*;
import java.awt.*;

public class TextBannerApp extends JFrame implements Runnable {
    private Thread th;
   // private JLabel textLabel;
    private String labelText = "Welcome to ITI!"; 
    private int xCoordinate = 0; 

    public TextBannerApp() {
        this.setTitle("Text Banner Application");
        th = new Thread(this);
        th.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TextBannerApp app = new TextBannerApp();
            app.setBounds(50, 50, 600, 500);
            app.setVisible(true);
        });
    }

    public void run() {
        try {
            while (true) {
                // Move the text horizontally
                xCoordinate += 3; //speed of the movement

                // If the text reaches the right edge, reset its position to the left edge
                if (xCoordinate > getWidth()) {
                    xCoordinate = -getFontMetrics(getFont()).stringWidth(labelText);
                }

                repaint();

                Thread.sleep(50); 
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Draw the text label with updated position
        g.drawString(labelText, xCoordinate, getHeight() / 2);
    }
}
