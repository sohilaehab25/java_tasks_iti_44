import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class CombinedApps extends JFrame {
    public CombinedApps() {
        setTitle("Combined Applications");
        setSize(800, 400);
        setLayout(new GridLayout(1, 3)); 

        // instances of classes
        PhotoBannerApp photoBannerApp = new PhotoBannerApp();
        DateTimeApp dateTimeApp = new DateTimeApp();
        TextBannerApp textBannerApp = new TextBannerApp();

        // Add component to frame
        add(photoBannerApp);
        add(dateTimeApp);
        add(textBannerApp);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CombinedApps frame = new CombinedApps();
            frame.setVisible(true);
        });
    }
}

//classes splits into threads

class PhotoBannerApp extends JPanel implements Runnable {
    private ImageIcon imageIcon;
    private int xCoordinate = 0;
    private int yCoordinate = 0;
    private int speedX;
    private int speedY;

    public PhotoBannerApp() {
        imageIcon = new ImageIcon("ball.png"); 
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

        // random speed
        speedX = 2;
        speedY = 2;

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageIcon.getImage(), xCoordinate, yCoordinate, this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    public void run() {
        try {
            while (true) {
                xCoordinate += speedX;
                yCoordinate += speedY;

                // Bounce off window edges
                if (xCoordinate <= 0 || xCoordinate + imageIcon.getIconWidth() >= getWidth()) {
                    speedX = -speedX;
                }
                if (yCoordinate <= 0 || yCoordinate + imageIcon.getIconHeight() >= getHeight()) {
                    speedY = -speedY;
                }

                repaint();
                Thread.sleep(20);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TextBannerApp extends JPanel implements Runnable {
    private String labelText = "Welcome to ITI!";
    private int xCoordinate = 0;

    public TextBannerApp() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(labelText, xCoordinate, getHeight() / 2);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    public void run() {
        try {
            while (true) {
                xCoordinate += 3; // speed of the movement

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
}

class DateTimeApp extends JLabel implements Runnable {
    public DateTimeApp() {
        setHorizontalAlignment(JLabel.CENTER);
        Thread thread = new Thread(this);
        thread.start();
    }

    public void run() {
        try {
            while (true) {
                Date d = new Date();
                setText(d.toString());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
