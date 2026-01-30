import java.util.Scanner;

public class game {

    public String[][] board = {
            {"r","n","b","q","k","b","n","r"},
            {"p","p","p","p","p","p","p","p"},
            {"","","","","","","",""},
            {"","","","","","","",""},
            {"","","","","","","",""},
            {"","","","","","","",""},
            {"P","P","P","P","P","P","P","P"},
            {"R","N","B","Q","K","B","N","R"}
    };

    public void move(String from, String to) {
        int fx = from.charAt(0) - 'a';
        int fy = 8 - (from.charAt(1) - '0');
        int tx = to.charAt(0) - 'a';
        int ty = 8 - (to.charAt(1) - '0');

        board[ty][tx] = board[fy][fx];
        board[fy][fx] = "";
    }

    public void startConsole() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Ход (e2 e4): ");
            String from = sc.next();
            String to = sc.next();
            move(from, to);
        }
    }
}
