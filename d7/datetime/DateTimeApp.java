import javax.swing.*;
import java.awt.*;
import java.util.Date;

 class DateTimeApp extends JFrame implements Runnable {
    private Thread th;
    private JLabel timeLabel = new JLabel();

    public DateTimeApp() {
        this.setTitle("Date & Time Application");
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(timeLabel, BorderLayout.CENTER);
        th = new Thread(this);
        th.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DateTimeApp app = new DateTimeApp();
            app.setBounds(50, 50, 600, 400);
            app.setVisible(true);
        });
    }

    public void run() {
        try {
            while (true) {
                Date d = new Date();
                timeLabel.setText(d.toString());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
