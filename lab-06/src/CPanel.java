import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class CPanel extends JPanel {

    private int ovalX;
    private int ovalY;
    private final int cellHeight;
    private final int cellWidth;

    public CPanel() {
        setBackground(Color.GRAY);
        ovalX = 0;
        ovalY = 0;
        cellWidth = Main.WIDTH / 8;
        cellHeight = Main.HEIGHT / 8;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                int x1 = x * cellWidth;
                int y1 = y * cellHeight;
                if (x % 2 == 0) {
                    if (y % 2 == 0) {
                        g.setColor(Color.BLACK);
                        g.fillRect(x1, y1, cellWidth, cellHeight);
                    } else {
                        g.setColor(Color.WHITE);
                        g.fillRect(x1, y1, cellWidth, cellHeight);
                    }
                } else {
                    if (y % 2 == 0) {
                        g.setColor(Color.WHITE);
                        g.fillRect(x1, y1, cellWidth, cellHeight);
                    } else {
                        g.setColor(Color.BLACK);
                        g.fillRect(x1, y1, cellWidth, cellHeight);
                    }
                }
            }
        }
        g.setColor(Color.RED);
        g.fillOval(ovalX, ovalY, cellWidth, cellHeight);
    }

    public void up() {
        ovalY -= cellHeight;
    }

    public void down() {
        ovalY += cellHeight;
    }

    public void left() {
        ovalX -= cellWidth;
    }

    public void right() {
        ovalX += cellWidth;
    }
}