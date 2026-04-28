import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {

    private final GamePanel contentPane;

    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 900);
        setLocationRelativeTo(null);
        contentPane = new GamePanel();
        add(contentPane, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {

        Main frame = new Main();

        Color c = new Color(255, 255, 255);
        System.out.println(c.getRed());
        System.out.println(c.getGreen());
        System.out.println(c.getBlue());
    }
}