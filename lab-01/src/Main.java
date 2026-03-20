import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameBoard board = new GameBoard(10);
        Turtle turtle = new Turtle(2, 2);

        board.update(turtle);
        board.print();

        while (true) {
            String cmd = sc.nextLine().trim().toLowerCase();

            if (cmd.equals("quit")) {
                break;
            }

            switch (cmd) {
                case "move":
                    if (turtle.direction == 0 && turtle.y > 0) {
                        turtle.y--;
                    } else if (turtle.direction == 1 && turtle.x < board.getSize() - 1) {
                        turtle.x++;
                    } else if (turtle.direction == 2 && turtle.y < board.getSize() - 1) {
                        turtle.y++;
                    } else if (turtle.direction == 3 && turtle.x > 0) {
                        turtle.x--;
                    } else {
                        System.out.println("Бум! СТЕНА!");
                    }
                    break;
                case "turn left":
                    turtle.turnLeft();
                    break;
                case "turn right":
                    turtle.turnRight();
                    break;
            }
            board.update(turtle);
            board.print();
        }
    }
}