import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Solution {

    private static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static final int EMPTY = 0; // empty cell

    public static void main(String[] args) throws FileNotFoundException {
        //in = new Scanner(Indicium.class.getResourceAsStream("file.in"));
        int T = Integer.parseInt(in.nextLine());
        for (int t = 1; t <= T; t++) {
            String s1[] = in.nextLine().split(" ");
            int N = Integer.parseInt(s1[0]);
            int K = Integer.parseInt(s1[1]);

            int min = 1 * N;
            int max = N * N;

            if (K < min || K > max || K == max - 1 || K == min + 1) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
                continue;
            }

            int[][] board = new int[N][N];
            
            int nPos = -1;
            int zeroC = 0;

            int r = K;
            int pos = 0;
            int n = N;
            while (r > 0) {
                int div = r / n;
                if (div == N - 1) {
                    div--;
                }
                int rem = r - (n * div);
                while (rem < N - pos - div) {
                    div--;
                    rem = r - (n * div);
                }
                for (int i = 0; i < div; i++) {
                    r -= n;
                    board[pos][pos] = n;
                    if(n > 1){
                    nPos = pos;
                    }else{
                        zeroC++;
                    }
                    pos++;
                }
                if (div == 0) {
                    r -= 1;
                    board[pos][pos] = 1;
                    zeroC ++;
                    pos++;
                }
                n--;
            }
            if(zeroC == N-1){
                board[nPos][nPos]--;
                board[N-1][N-1]++;
            }
            System.out.println("Case #" + t + ": POSSIBLE");
            solve(board);

        }
    }

    // we check if a possible number is already in a row
    private static boolean isInRowOrCol(int[][] board, int row, int col, int number) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == number || board[i][col] == number) {
                return true;
            }
        }

        return false;
    }

    // combined method to check if a number possible to a row,col position is ok
    private static boolean isOk(int[][] board, int row, int col, int number) {
        return !isInRowOrCol(board, row, col, number);
    }

    // Solve method. We will use a recursive BackTracking algorithm.
    // we will see better approaches in next video :)
    public static boolean solve(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                // we search an empty cell
                if (board[row][col] == EMPTY) {
                    // we try possible numbers
                    for (int number = 1; number <= board.length; number++) {
                        if (isOk(board, row, col, number)) {
                            // number ok. it respects sudoku constraints
                            board[row][col] = number;

                            if (solve(board)) { // we start backtracking recursively
                                return true;
                            } else { // if not a solution, we empty the cell and we continue
                                board[row][col] = EMPTY;
                            }
                        }
                    }

                    return false; // we return false
                }
            }
        }
        display(board);
        return true; // sudoku solved
    }

    public static void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
