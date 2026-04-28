import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseCoordinateTracker {

    private static int x = 0, y = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MouseCoordinateTracker");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setBackground(Color.BLUE);
        frame.setLayout(new GridLayout(1, 2));

        // Анонимный класс
        JPanel panel = new CPanel();
        panel.setSize(500, 500);

        panel.setBackground(Color.GRAY);



        JPanel panel2 = new JPanel();
        panel2.setSize(500, 500);
        panel2.setBackground(Color.YELLOW);
        JButton button = new JButton("Click Me");

        button.addActionListener(e -> {

        });
        panel2.add(button);


        frame.add(panel);
        frame.add(panel2);

        frame.setVisible(true);
    }

}


class CPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 200, 50);
        g.setColor(Color.BLACK);
        g.fillOval(300, 0, 200, 100);
    }
}