import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoard {

    public static final int BOARD_COLUMNS = 4;
    public static final int BOARD_ROWS = 4;
    public Tile[][] board = new Tile[BOARD_ROWS][BOARD_COLUMNS];
    public int[] powers = new int[10];

    public GameBoard() {

        initPowers();
        int rV = randomValue();

        board[randomRow()][randomColumn()] = new Tile(rV, getTileColor(rV), Color.BLACK);
        for (int i = 0; i < BOARD_ROWS; i++) {
            for (int j = 0; j < BOARD_COLUMNS; j++) {
                if (board[i][j] == null) {
                    board[i][j] = new Tile(1, getTileColor(1), Color.BLACK);
                }
            }
        }
    }

    public int randomColumn() {
        return new Random().nextInt(BOARD_COLUMNS);
    }

    public int randomRow() {
        return new Random().nextInt(BOARD_ROWS);
    }

    public int randomValue() {
        return Math.random() < 0.8 ? 2 : 4;
    }


    private void spawnTile() {
        while (true) {
            int i = randomRow();
            int j = randomColumn();

            if (board[i][j].getValue() == 1) {
                int val = randomValue();
                board[i][j] = new Tile(val, getTileColor(val), Color.BLACK);
                break;
            }
        }
    }

    public void initPowers() {
        for (int i = 1; i < powers.length; i++) {
            powers[i] = (int) Math.pow(2, i);
            System.out.println(powers[i]);
        }
    }

    private Color getTileColor(int value) {
        // Начальный цвет — белый
        Color start = new Color(255, 255, 255);
        // Конечный цвет — оранжевый
        Color end = new Color(255, 100, 0);

        // value от 2 до 2048, переводим в диапазон 0.0 — 1.0
        int maxPower = 11; // 2^11 = 2048
        int currentPower = (int) (Math.log(value)/Math.log(2)); // степень текущей плитки // 5
        float t = (float) currentPower / maxPower; // от 0.0 до 1.0 // 5/11 = 0.45454545454....

        // Интерполируем каждый канал RGB
        int r = (int) (start.getRed() + t * (end.getRed()
                - start.getRed())); // 255 + 0.454545... * (255 - 255) = 255
        int g = (int) (start.getGreen() + t * (end.getGreen()
                - start.getGreen())); // 255 + 0.454545... * (100 - 255) = 184.545454
        int b = (int) (start.getBlue() + t * (end.getBlue()
                - start.getBlue())); // 255 + 0.454545... * (0 - 255) = 139.090909
        System.out.println(b);
        return new Color(r, g, b);
    }



    public void right() {
        for (int i = 0; i < BOARD_ROWS; i++) {

            // 1. Собираем все ненулевые плитки строки
            ArrayList<Integer> tiles = new ArrayList<>();
            for (int j = 0; j < BOARD_COLUMNS; j++) {
                if (board[i][j].getValue() != 1) {
                    tiles.add(board[i][j].getValue());
                }
            }

            // 2. Сливаем соседние одинаковые (справа налево)
            for (int j = tiles.size() - 1; j > 0; j--) {
                if (tiles.get(j).equals(tiles.get(j - 1))) {
                    tiles.set(j, tiles.get(j) * 2);
                    tiles.remove(j - 1);
                }
            }

            // 3. Заполняем строку — сначала пустые, потом плитки
            int emptyCount = BOARD_COLUMNS - tiles.size();
            for (int j = 0; j < BOARD_COLUMNS; j++) {
                if (j < emptyCount) {
                    board[i][j] = new Tile(1, getTileColor(1), Color.BLACK);
                } else {
                    int val = tiles.get(j - emptyCount);
                    board[i][j] = new Tile(val, getTileColor(val), Color.BLACK);
                }
            }
        }

        // 4. Добавляем новую плитку
        spawnTile();
    }


    public void left() {
        for (int i = 0; i < BOARD_ROWS; i++) {
            // 1. Собираем все ненулевые плитки строки
            ArrayList<Integer> tiles = new ArrayList<>();
            for (int j = 0; j < BOARD_COLUMNS; j++) {
                if (board[i][j].getValue() != 1) {
                    tiles.add(board[i][j].getValue());
                }
            }
            // ДЕЛАЕМ ПОДСЧЕТ ДЛЯ КАЖДОГО ДВИЖЕНИЯ НАПРАВО ЧИТАЯ С ЛЕВО НА ПРАВО
            for (int j = 0; j < tiles.size() - 1; j++) {
                if (tiles.get(j).equals(tiles.get(j + 1))) {
                    tiles.set(j, tiles.get(j) * 2);
                    tiles.remove(j + 1);
                }
            }
            // 3. Заполняем строку — сначала пустые, потом плитки
            for (int j = 0; j < BOARD_COLUMNS; j++) {
                if (j < tiles.size()) {
                    // сначала идут плитки
                    int val = tiles.get(j);
                    board[i][j] = new Tile(val, getTileColor(val), Color.BLACK);
                } else {
                    // потом пустые
                    board[i][j] = new Tile(1, getTileColor(1), Color.BLACK);
                }
            }
        }
        spawnTile();
    }

    public void up() {
        for (int i = 0; i < BOARD_COLUMNS; i++) {

            // 1. Собираем все ненулевые плитки строки
            ArrayList<Integer> tiles = new ArrayList<>();
            for (int j = 0; j < BOARD_ROWS; j++) {
                if (board[j][i].getValue() != 1) {
                    tiles.add(board[j][i].getValue());
                }
            }

            // 2. Сливаем соседние одинаковые (снизу вверх)
            for (int j = tiles.size() - 1; j > 0; j--) {
                if (tiles.get(j).equals(tiles.get(j - 1))) {
                    tiles.set(j-1, tiles.get(j) * 2);
                    tiles.remove(j);
                }
            }

            // 3. Заполняем строку — сначала плитки, потом пустые
            for (int j = 0; j < BOARD_ROWS; j++) {
                if (j < tiles.size()) {
                    int val = tiles.get(j);
                    board[j][i] = new Tile(val, getTileColor(val), Color.BLACK);
                } else {
                    board[j][i] = new Tile(1, getTileColor(1), Color.BLACK);
                }
            }
        }

        // 4. Добавляем новую плитку
        spawnTile();
    }

    public void down() {
        for (int i = 0; i < BOARD_COLUMNS; i++) {

            // 1. Собираем все ненулевые плитки строки
            ArrayList<Integer> tiles = new ArrayList<>();
            for (int j = 0; j < BOARD_ROWS; j++) {
                if (board[j][i].getValue() != 1) {
                    tiles.add(board[j][i].getValue());
                }
            }

            // 2. Сливаем соседние одинаковые (сверху вниз)
            for (int j = 0; j < tiles.size()-1; j++) {
                if (tiles.get(j).equals(tiles.get(j + 1))) {
                    tiles.set(j, tiles.get(j) * 2);
                    tiles.remove(j+1);
                }
            }

            // 3. Заполняем строку — сначала пустые, потом плитки
            int emptyCount = BOARD_ROWS - tiles.size();
            for (int j = 0; j < BOARD_ROWS; j++) {
                if (j < emptyCount) {
                    board[j][i] = new Tile(1, getTileColor(1), Color.BLACK);
                } else {
                    int val = tiles.get(j - emptyCount);
                    board[j][i] = new Tile(val, getTileColor(val), Color.BLACK);
                }
            }
        }

        // 4. Добавляем новую плитку
        spawnTile();
    }
}
