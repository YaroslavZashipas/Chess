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

    public boolean whiteTurn = true;

    public void move(String from, String to) {
        int fx = from.charAt(0) - 'a';
        int fy = 8 - (from.charAt(1) - '0');
        int tx = to.charAt(0) - 'a';
        int ty = 8 - (to.charAt(1) - '0');

        if (fx < 0 || fx > 7 || fy < 0 || fy > 7
                || tx < 0 || tx > 7 || ty < 0 || ty > 7)
            return;

        String piece = board[fy][fx];
        if (piece.isEmpty()) return;

        if (whiteTurn && !Character.isUpperCase(piece.charAt(0))) return;
        if (!whiteTurn && !Character.isLowerCase(piece.charAt(0))) return;

        if (!isValidMove(fx, fy, tx, ty, piece)) return;

        board[ty][tx] = piece;
        board[fy][fx] = "";
        whiteTurn = !whiteTurn;
    }

    private boolean isValidMove(int fx, int fy, int tx, int ty, String piece) {
        char p = piece.charAt(0);

        if (!board[ty][tx].isEmpty() &&
                Character.isUpperCase(p) == Character.isUpperCase(board[ty][tx].charAt(0)))
            return false;

        if (p == 'P') {
            if (fx == tx && fy - 1 == ty && board[ty][tx].isEmpty()) return true;
            if (fy == 6 && fx == tx && fy - 2 == ty
                    && board[5][fx].isEmpty() && board[4][fx].isEmpty()) return true;
            if (Math.abs(fx - tx) == 1 && fy - 1 == ty
                    && !board[ty][tx].isEmpty()
                    && Character.isLowerCase(board[ty][tx].charAt(0))) return true;
        }

        if (p == 'p') {
            if (fx == tx && fy + 1 == ty && board[ty][tx].isEmpty()) return true;
            if (fy == 1 && fx == tx && fy + 2 == ty
                    && board[2][fx].isEmpty() && board[3][fx].isEmpty()) return true;
            if (Math.abs(fx - tx) == 1 && fy + 1 == ty
                    && !board[ty][tx].isEmpty()
                    && Character.isUpperCase(board[ty][tx].charAt(0))) return true;
        }

        if (p == 'N' || p == 'n') {
            int dx = Math.abs(fx - tx);
            int dy = Math.abs(fy - ty);
            if ((dx == 2 && dy == 1) || (dx == 1 && dy == 2)) return true;
        }

        if (p == 'R' || p == 'r') {
            if (fx == tx) {
                int step = ty > fy ? 1 : -1;
                for (int y = fy + step; y != ty; y += step)
                    if (!board[y][fx].isEmpty()) return false;
                return true;
            }
            if (fy == ty) {
                int step = tx > fx ? 1 : -1;
                for (int x = fx + step; x != tx; x += step)
                    if (!board[fy][x].isEmpty()) return false;
                return true;
            }
        }

        return false;
    }

    public void printBoard() {
        System.out.println("  a b c d e f g h");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print((board[i][j].isEmpty() ? "." : board[i][j]) + " ");
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }
}
