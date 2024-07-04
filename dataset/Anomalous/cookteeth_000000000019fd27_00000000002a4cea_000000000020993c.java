public class Competition {
    private int countc = 0;
    private int countr = 0;
    private int T = 0;
    private int nums;
    private int n;
    private char[][] board;

    public Competition(int nums, int n, char[][] board) {
        this.nums = nums;
        this.n = n;
        this.board = board;
    }

    public boolean isRep(int nums, int n, char[][] board) {
        if (board == null || board.length == 0) return false;

        for (int i = 0; i < nums; i++) {
            // Check rows for repetition
            for (int row = 0; row < 9; row++) {
                boolean[] taken = new boolean[9];
                for (int idx = 0; idx < 9; idx++) {
                    char c = board[row][idx];
                    int num = c - '0';
                    if (taken[num]) countc++;
                    else taken[num] = true;
                }
            }

            // Check columns for repetition
            for (int col = 0; col < 9; col++) {
                boolean[] taken = new boolean[9];
                for (int idx = 0; idx < 9; idx++) {
                    char c = board[idx][col];
                    int num = c - '0';
                    if (taken[num]) countr++;
                    else taken[num] = true;
                }
            }

            // Calculate diagonal sum
            for (int row = 0; row < 9; row++) {
                for (int idx = 0; idx < 9; idx++) {
                    char c = board[row][idx];
                    int num = c - '0';
                    if (idx == row) T += num;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
            {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
            {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
            {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
            {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
            {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
            {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
            {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
            {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
        };
        int n = 9;
        int nums = 3;
        
        Competition competition = new Competition(nums, n, board);
        System.out.println(competition.isRep(nums, n, board));
    }
}