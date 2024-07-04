import java.util.*;

public class Solution {

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String[] line = in.nextLine().trim().split(" ");
            int N = Integer.parseInt(line[0]);
            int K = Integer.parseInt(line[1]);
            createLatinSqaure(N, K, i);
        }
    }

    private static void createLatinSqaure(int n, int k, int caseNumber) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }

        if (isLatinSquarePossible(matrix, n, k)) {
            System.out.println("Case #" + caseNumber + ": " + "POSSIBLE");
            print(matrix, n);
        } else {
            System.out.println("Case #" + caseNumber + ": " + "IMPOSSIBLE");
        }
    }


    public static boolean isSafe(int[][] board,
                                 int row, int col,
                                 int num, int k) {

        int diagonalSum = 0;
        for (int d = 0; d < board.length; d++) {
            if (board[row][d] == num) {
                return false;
            }
        }

        for (int r = 0; r < board.length; r++) {
            if (board[r][col] == num) {
                return false;
            }
        }

        for (int d = 0; d < board.length; d++) {
            diagonalSum = diagonalSum + board[d][d];
        }

        if (diagonalSum > k) return false;

        if(row+1 == board.length && col+1 == board.length && (diagonalSum+num)!=k) return false;

        return true;
    }

    public static boolean isLatinSquarePossible(int[][] board, int n, int k) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        if (isEmpty) {
            return true;
        }

        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num, k)) {
                board[row][col] = num;
//                print(board,n);
//                System.out.println("--------------------------------------");
                if (isLatinSquarePossible(board, n, k)) {
//                    print(board,n);
//                    System.out.println("--------------------------------------");
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void print(int[][] board, int N) {
        for (int r = 0; r < N; r++) {
            for (int d = 0; d < N; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int) Math.sqrt(N) == 0) {
                System.out.print("");
            }
        }
    }
}
