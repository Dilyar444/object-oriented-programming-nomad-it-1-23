import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CustomKeyAdapter extends KeyAdapter {

    private final GameBoard gameBoard;
    private final GamePanel gamePanel;

    public CustomKeyAdapter(GameBoard gameBoard, GamePanel gamePanel) {
        this.gameBoard = gameBoard;
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed: " + e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            gameBoard.right();
            gamePanel.repaint();
            System.out.println("Right arrow");
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            gameBoard.left();
            gamePanel.repaint();
        }
    }
}