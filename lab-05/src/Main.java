import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JButton button = new JButton("Press1");
        JButton button2 = new JButton("Press2");



        JPanel panel = new CustomJPanel();
        panel.add(button);
        panel.add(button2);

        button.addActionListener(e -> {
            CustomJPanel.colorIndex.set(1);
            panel.repaint();
        });

        button2.addActionListener(e -> {
            CustomJPanel.colorIndex.set(2);;
            panel.repaint();
        });

        frame.getContentPane().add(panel);

        frame.setVisible(true);

    }
}

class CustomJPanel extends JPanel {

    Color[] colors = {Color.RED, Color.BLUE, Color.GREEN};
    static AtomicInteger colorIndex = new AtomicInteger();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(colors[colorIndex.get()]);
        g.fillOval(100, 100, 200, 200);
    }

}