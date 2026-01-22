import javax.swing.*;

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
    }
}
