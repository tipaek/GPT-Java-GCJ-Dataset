import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String out = "";
        int testCases = sc.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            String validMatrix = "";

            int n = sc.nextInt();
            int t = sc.nextInt();

            int[][] mat = solve(n, t);
            boolean possible = mat.length > 0;
            for (int i = 0; i < n && possible; i++) {
                for (int j = 0; j < n; j++) {
                    validMatrix += mat[i][j] + (j + 1 < n ? " " : "");
                }
                validMatrix += (i + 1 < n ? "\n" : "");
            }

            out += "Case #" + (testCase+1) + ": " + (possible ? "POSSIBLE\n" + validMatrix : "IMPOSSIBLE") + (testCase + 1 < testCases ? "\n" : "");
        }

        System.out.print(out);
    }

    private static int[][] solve(int n, int t) {
        int[][] mat = new int[0][0];
        boolean possible = false;
        List<List<Integer>> possibleSums = sum_up(n, t);
        for (int i = 0; i < possibleSums.size() && !possible; i++) {
            List<Integer> possibleSum = possibleSums.get(i);
            mat =  new int[n][n];
            for (int k = 0; k < n; k++) {
                mat[k][k] = possibleSum.get(k);
            }
            possible = fillRemaining(mat);
        }

        return possible ? mat : new int[0][0];
    }

    private static boolean subsectionConstraint(int[][] board) {
        boolean[] constraint = new boolean[board.length];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                if (!checkConstraint(board, r, constraint, c)) return false;
            }
        }
        return true;
    }

    private static boolean checkConstraint(
            int[][] board,
            int row,
            boolean[] constraint,
            int column) {
        if (board[row][column] != 0) {
            if (!constraint[board[row][column] - 1]) {
                constraint[board[row][column] - 1] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(int[][] board, int row, int column) {
        return (rowConstraint(board, row)
                && columnConstraint(board, column));
    }

    private static boolean rowConstraint(int[][] board, int row) {
        boolean[] constraint = new boolean[board.length];
        return IntStream.range(0, board.length)
                .allMatch(column -> checkConstraint(board, row, constraint, column));
    }

    private static boolean columnConstraint(int[][] board, int column) {
        boolean[] constraint = new boolean[board.length];
        return IntStream.range(0, board.length)
                .allMatch(row -> checkConstraint(board, row, constraint, column));
    }

    // A recursive function to fill remaining
    // matrix
    private static boolean fillRemaining(int[][] board) {
        int n = board.length;
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                if (board[row][column] == 0) {
                    for (int k = 1; k <= n; k++) {
                        board[row][column] = k;
                        if (isValid(board, row, column) && fillRemaining(board)) {
                            return true;
                        }
                        board[row][column] = 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static void sum_up_recursive(int n, int stop, int target, List<Integer> partial, List<List<Integer>> possibleSums) {
        if (partial.size() == n) {
            int s = 0;
            for (int x : partial) s += x;
            if (s == target) {
                possibleSums.add(partial);
            }
            return;
        }

        for(int i=1;i<=n;i++) {
            ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
            partial_rec.add(i);
            sum_up_recursive(n, stop-i,target,partial_rec, possibleSums);
        }
    }

    private static List<List<Integer>> sum_up(int n, int target) {
        List<List<Integer>> possibleSums = new ArrayList<>();
        sum_up_recursive(n,n,target,new ArrayList<Integer>(), possibleSums);
        return possibleSums;
    }
}