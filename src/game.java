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


    public void printBoard() {
        System.out.println("  a b c d e f g h");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < 8; j++) {
                String piece = board[i][j];
                System.out.print((piece.isEmpty() ? "." : piece) + " ");
            }
            System.out.println((8 - i));
        }
        System.out.println("  a b c d e f g h");
    }
}
