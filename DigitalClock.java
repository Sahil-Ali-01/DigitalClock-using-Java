import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends JFrame {

    private JLabel clockLabel;  // Clock ka label

    public DigitalClock() {
        // Window properties
        setTitle("Digital Clock");
        setSize(300, 150);
        setLocationRelativeTo(null); // Center me open karega
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Label for clock
        clockLabel = new JLabel("", SwingConstants.CENTER);
        clockLabel.setFont(new Font("Arial", Font.BOLD, 40)); // Stylish font
        add(clockLabel, BorderLayout.CENTER);

        // Clock ko start karna
        startClock();

        setVisible(true);
    }

    private void startClock() {
        Timer timer = new Timer(1000, e -> updateClock()); // Har second update hoga
        timer.start();
    }

    private void updateClock() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss"); // Time format
        String time = formatter.format(new Date()); // Current time
        clockLabel.setText(time);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DigitalClock::new); // Thread-safe execution
    }
}
