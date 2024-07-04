import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Solution {

    static class BackTracking{
        int [][] board;
        int SIZE = 0;
        int EMPTY = 0;
        public BackTracking(int n, int[]trace){
            board = new int[n][n];
            for (int i = 0; i < n; i++){
                board[i][i] = trace[i];
            }
            SIZE = n;
        }

        // we check if a possible number is already in a row
        private boolean isInRow(int row, int number) {
            for (int i = 0; i < SIZE; i++)
                if (board[row][i] == number)
                    return true;

            return false;
        }

        // we check if a possible number is already in a column
        private boolean isInCol(int col, int number) {
            for (int i = 0; i < SIZE; i++)
                if (board[i][col] == number)
                    return true;

            return false;
        }
        // combined method to check if a number possible to a row,col position is ok
        private boolean isOk(int row, int col, int number) {
            return !isInRow(row, number)  &&  !isInCol(col, number) ;
        }

        public void print(){
            for(int i = 0 ; i < SIZE; i++){
                StringBuilder line = new StringBuilder();
                for(int j = 0; j < SIZE; j++){
                    line.append(board[i][j]);
                    line.append((j == SIZE - 1) ? "" : " ");
                }
                System.out.println(line);
            }
        }

        public boolean solve() {
            for (int row = 0; row < SIZE; row++) {
                for (int col = 0; col < SIZE; col++) {
                    // we search an empty cell
                    if (board[row][col] == EMPTY) {
                        // we try possible numbers
                        for (int number = 1; number <= SIZE; number++) {
                            if (isOk(row, col, number)) {
                                // number ok. it respects sudoku constraints
                                board[row][col] = number;

                                if (solve()) { // we start backtracking recursively
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
            return true;
        }
    }


    static void solve(int t, int n, int k) {
        boolean possible = (k != Math.pow(n, 2) - 1 && k != n + 1);
        if (possible) {
            System.out.println("Case #" + t + ": " + "POSSIBLE");
            boolean easy = Math.floor((double) k / n) == Math.ceil((double) k / n);
            int e = k/n;
            if (easy){
                solveEasy(e, n);
            } else {
                Random rnd = new Random();
                int[] arr = new int[n];
                boolean done = false;
                while (!done) {
                    int tempK = k;
                    int sum = 0;
                    for (int g = 0; g < n; g++) {
                        int min = Math.max(((tempK - sum) - (n - g - 1) * n), 1);
                        int max = Math.min((tempK - sum) - (n - g - 1), n);
                        if (max == min) {
                            arr[g] = max;
                        } else {
                            arr[g] = rnd.nextInt(max - min) + min;
                        }
                        sum += arr[g];
                    }
                    if (sum == k) {
                        int[] check = new int[n];
                        for (int i = 0; i < n; i++) {
                            check[arr[i] - 1]++;
                        }
                        boolean nonRepExists = false;
                        int count = 0;
                        for (int i = 0; i < n; i++) {
                            if (check[i] == 1) nonRepExists = true;
                            if (check[i] != 0) count++;
                        }
                        done = !(nonRepExists && count <= 2);
                    }
                }
//                System.out.println(Arrays.toString(arr));
                BackTracking bt = new BackTracking(n, arr);
                bt.solve();
                bt.print();
            }
        } else {
            System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
        }
    }

    private static void solveEasy(int e, int n) {

        for (int i = 0; i < n; i++){
            StringBuilder line = new StringBuilder();
            int t = e;
            for(int j = 0; j < n ; j ++){
                line.append((t + j) == n ? n : (t + j) % n);
                line.append((j == n - 1) ? "" : " ");
            }
            System.out.println(line);
            e--;
            if (e == 0){
                e = n;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int m = in.nextInt();
            solve(i, n, m);
        }
    }
}
