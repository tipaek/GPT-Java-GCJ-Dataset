import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static int[][] board;
    static Map<Integer, Integer> tracing = new HashMap<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = Integer.parseInt(in.nextLine());

        for (int t=1; t<=T; t++) {
            String[] S = in.nextLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int K = Integer.parseInt(S[1]);
            compute(t, N, K);
        }
    }

    private static void compute(int t, int N, int K) {
        for (int num = 1; num <= N; num++) {
            board = new int[N][N];
            tracing = new HashMap<>();
            board[0][0] = num;
            tracing.put(0, num);
            if (solve()) {
                int trace = 0;
                for (Integer i : tracing.values()) {
                    trace += i;
                }
                if (trace == K) {
                    printPossible(t);
                    return;
                }
            }

        }

        printImpossible(t);

    }

    private static boolean solve() {

        for (int row =0; row<board.length; row++) {
            for (int col  =0; col < board.length; col++) {
                if (board[row][col] == 0) {

                    for (int num=1; num<=board.length; num++) {
                        if (isValidInput(row, col, num)) {
                            board[row][col] = num;
                            if (row == col) {
                                tracing.put(row+col, num);
                            }

                            if (solve()) {
                                return true;
                            } else {
                                board[row][col] = 0;
                                tracing.put(row+col, 0);
                            }
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }


    private static boolean isValidInput(int row, int col, int value) {
        return !isInRow(row, value) && !isInCol(col, value);
    }

    private static boolean isInRow(int row, int value) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == value) {
                return true;
            }
        }

        return false;
    }

    private static boolean isInCol(int col, int value) {
        for (int i=0; i<board.length; i++) {
            if (board[i][col] == value) {
                return true;
            }
        }
        return false;
    }

    private static void printImpossible(int t) {
        System.out.println("Case #" + t +": POSSIBLE");
    }

    private static void printPossible(int t) {
        System.out.println("Case #" + t +": POSSIBLE");
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                if (c < board.length-1) {
                    System.out.print(board[r][c] + " ");
                } else {
                    System.out.print(board[r][c]);
                }
            }
            System.out.println();
        }
    }
}
