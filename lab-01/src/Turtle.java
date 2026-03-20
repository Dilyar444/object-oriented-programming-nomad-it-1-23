public class Turtle {
    public int x, y;
    public int direction; // 0:UP, 1:RIGHT, 2:DOWN, 3:LEFT

    public Turtle(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.direction = 0; // Начинаем вверх
    }

    public void turnRight() {
        direction = (direction + 1) % 4;
    }

    public void turnLeft() {
        direction = (direction + 3) % 4; // Эквивалентно -1, но без отрицательных чисел
    }

    public char getSymbol() {
        switch (direction) {
            case 0: return '^';
            case 1: return '>';
            case 2: return 'v';
            case 3: return '<';
            default: return '?';
        }
    }
}