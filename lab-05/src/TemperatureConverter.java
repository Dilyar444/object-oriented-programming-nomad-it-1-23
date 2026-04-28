import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class TemperatureConverter {

    static int temperature = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Temperature Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2,1));
        JPanel panel2 = new JPanel();

        JTextField textField = new JTextField(10);
        textField.setSize(200, 50);

        JLabel label = new JLabel("Temperature: " + temperature + "C");
        panel.add(label, BorderLayout.WEST);

        panel.add(textField, BorderLayout.CENTER);

        JLabel label2 = new JLabel("Farenheit: ");
        panel.add(label2, BorderLayout.EAST);

        JButton button = new JButton("Convert");
        panel2.add(button, BorderLayout.EAST);
        button.addActionListener(e -> {
            temperature = Integer.parseInt(textField.getText());
            label.setText("Temperature: " + temperature + "C");

            double newTemp = (double) (temperature * 9) / 5 + 32;
            label2.setText("Farenheit: " + String.format("%.2f", newTemp) + "F");
        });
        frame.add(panel, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}