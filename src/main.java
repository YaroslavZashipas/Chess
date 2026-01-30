import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        game game = new game();
        Scanner sc = new Scanner(System.in);

        while (true) {
            game.printBoard();
            System.out.print("Make a move (For example, e2 e4): ");
            String from = sc.next();
            String to = sc.next();
            game.move(from, to);
        }
    }
}

