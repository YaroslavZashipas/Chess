import javax.swing.*;
import java.awt.*;

public class map extends JPanel {

    game game;

    public map(game game) {
        this.game = game;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int size = Math.min(getWidth(), getHeight());
        int tile = size / 8;
        int offsetX = (getWidth() - tile * 8) / 2;
        int offsetY = (getHeight() - tile * 8) / 2;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                g.setColor((i + j) % 2 == 0
                        ? new Color(253,253,253)
                        : new Color(179,163,163));

                g.fillRect(offsetX + j * tile, offsetY + i * tile, tile, tile);

                if (!game.board[i][j].isEmpty()) {
                    g.setFont(new Font("Arial", Font.BOLD, tile / 2));
                    g.setColor(Color.BLACK);
                    g.drawString(game.board[i][j],
                            offsetX + j * tile + tile / 3,
                            offsetY + i * tile + tile * 2 / 3);
                }
            }
        }
    }
}
