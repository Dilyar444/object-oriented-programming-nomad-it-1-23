public class GameBoard {
    private final int size;
    private char[][] grid;

    public GameBoard(int size) {
        this.size = size;
        this.grid = new char[size][size];
        clear();
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '.';
            }
        }
    }

    public void update(Turtle turtle) {
        clear();
        if (turtle.x >= 0 && turtle.x < size && turtle.y >= 0 && turtle.y < size) {
            grid[turtle.y][turtle.x] = turtle.getSymbol();
        }
    }

    public void print() {
        for (char[] r : grid) {
            for (char c : r) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public int getSize() { return size; }
}