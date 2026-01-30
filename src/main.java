import javax.swing.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Chess");
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton start = new JButton("new game");
        JButton exit = new JButton("exit");

        JPanel panel = new JPanel();
        panel.add(start);
        panel.add(exit);

        frame.add(panel);
        frame.setVisible(true);

        exit.addActionListener(e -> System.exit(0));

        start.addActionListener(e -> {
            frame.getContentPane().removeAll();

            game game = new game();
            map board = new map(game);

            frame.add(board);
            frame.revalidate();
            frame.repaint();

            new Thread(() -> {
                Scanner sc = new Scanner(System.in);
                while (true) {
                    System.out.print("Enter the move (a2 a4): ");
                    game.move(sc.next(), sc.next());
                    board.repaint();
                }
            }).start();
        });
    }
}
