import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class Main extends JFrame {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    public static CPanel cPanel;

    public Main() {
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cPanel = new CPanel();
        cPanel.requestFocus();
        cPanel.setFocusable(true);
        cPanel.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    cPanel.up();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    cPanel.down();
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    cPanel.left();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    cPanel.right();
                }
                repaint();
            }
        });
        add(cPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        Main frame = new Main();


    }
}





















//Tile.java → Хранит данные одной плитки (число, цвет фона, цвет текста)
//
//Main.java → Создаёт окно приложения (JFrame) и запускает программу
//
//GamePanel.java → Рисует игровое поле и плитки на экране (JPanel + Graphics2D)
//
//CustomKeyAdapter.java → Ловит нажатия клавиш (← →) и вызывает движение плиток
//
//GameBoard.java → Вся логика игры: доска 4×4, сдвиг, слияние, спавн новых плиток