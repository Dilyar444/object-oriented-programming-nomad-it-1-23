import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Problem01 extends JFrame {

    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();

    JButton redButton = new JButton("RED");
    JButton greenButton = new JButton("GREEN");
    JButton blueButton = new JButton("BLUE");

    public Problem01() {
        setTitle("Problem 01");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        p1.setBackground(Color.RED);
        add(p1, BorderLayout.CENTER);
        p2.setBackground(Color.GRAY);
        p2.setLayout(new FlowLayout(FlowLayout.CENTER));
        p2.add(redButton);
        p2.add(greenButton);
        p2.add(blueButton);
        add(p2, BorderLayout.SOUTH);

        redButton.addActionListener(new ActionsListenerCustom(p1, Color.RED));
        blueButton.addActionListener(new ActionsListenerCustom(p1, Color.BLUE));
        greenButton.addActionListener(new ActionsListenerCustom(p1, Color.GREEN));

    }

    public static void main(String[] args) {
        Problem01 frame = new Problem01();
        frame.setVisible(true);
    }
}

class ActionsListenerCustom implements ActionListener {

    private JPanel panel;
    private Color color;

    public ActionsListenerCustom(JPanel panel, Color color) {
        this.panel = panel;
        this.color = color;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.panel.setBackground(this.color);
    }
}