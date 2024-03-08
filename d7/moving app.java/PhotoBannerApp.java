import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PhotoBannerApp extends JFrame {
    private ImageIcon imageIcon;
    private int xCoordinate = 0;
    private int yCoordinate = 0;
    private int speedX;
    private int speedY;

    public PhotoBannerApp() {
        setTitle("moving ball Application");
        imageIcon = new ImageIcon("moving app.java//ball.png");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

        setSize(600, 400);

        // random speed
        Random random = new Random();
        speedX = random.nextInt(5) + 1;
        speedY = random.nextInt(5) + 1;

        //  JPanel for moving the ball
        JPanel ballPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imageIcon.getImage(), xCoordinate, yCoordinate, this);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(600, 400); 
            }
        };

        // Add panel to the frame
        add(ballPanel);

        // Start moving the ball
        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xCoordinate += speedX;
                yCoordinate += speedY;

                // Bounce off window edges
                if (xCoordinate <= 0 || xCoordinate + imageIcon.getIconWidth() > getWidth()) {
                    speedX = -speedX;
                }
                if (yCoordinate <= 0 || yCoordinate + imageIcon.getIconHeight() > getHeight()) {
                    speedY = -speedY;
                }

                ballPanel.repaint();
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PhotoBannerApp().setVisible(true));
    }
}
