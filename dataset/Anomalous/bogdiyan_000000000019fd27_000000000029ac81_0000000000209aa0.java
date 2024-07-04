import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder output = new StringBuilder();

        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int t = scanner.nextInt();

            int[][] matrix = solve(n, t);
            if (matrix.length > 0) {
                output.append("Case #").append(testCase).append(": POSSIBLE\n");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        output.append(matrix[i][j]);
                        if (j < n - 1) output.append(" ");
                    }
                    if (i < n - 1) output.append("\n");
                }
            } else {
                output.append("Case #").append(testCase).append(": IMPOSSIBLE");
            }
            if (testCase < testCases) output.append("\n");
        }

        System.out.print(output);
    }

    private static int[][] solve(int n, int t) {
        List<List<Integer>> possibleSums = sumUp(n, t);
        for (List<Integer> sum : possibleSums) {
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                matrix[i][i] = sum.get(i);
            }
            if (fillRemaining(matrix)) return matrix;
        }
        return new int[0][0];
    }

    private static boolean fillRemaining(int[][] board) {
        int n = board.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= n; num++) {
                        board[row][col] = num;
                        if (isValid(board, row, col) && fillRemaining(board)) {
                            return true;
                        }
                        board[row][col] = 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int[][] board, int row, int col) {
        return rowConstraint(board, row) && columnConstraint(board, col);
    }

    private static boolean rowConstraint(int[][] board, int row) {
        boolean[] constraint = new boolean[board.length];
        return IntStream.range(0, board.length)
                        .allMatch(col -> checkConstraint(board, row, constraint, col));
    }

    private static boolean columnConstraint(int[][] board, int col) {
        boolean[] constraint = new boolean[board.length];
        return IntStream.range(0, board.length)
                        .allMatch(row -> checkConstraint(board, row, constraint, col));
    }

    private static boolean checkConstraint(int[][] board, int row, boolean[] constraint, int col) {
        if (board[row][col] != 0) {
            if (!constraint[board[row][col] - 1]) {
                constraint[board[row][col] - 1] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    private static List<List<Integer>> sumUp(int n, int target) {
        List<List<Integer>> possibleSums = new ArrayList<>();
        sumUpRecursive(n, target, new ArrayList<>(), possibleSums);
        return possibleSums;
    }

    private static void sumUpRecursive(int n, int target, List<Integer> partial, List<List<Integer>> possibleSums) {
        if (partial.size() == n) {
            int sum = partial.stream().mapToInt(Integer::intValue).sum();
            if (sum == target) {
                possibleSums.add(new ArrayList<>(partial));
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            partial.add(i);
            sumUpRecursive(n, target, partial, possibleSums);
            partial.remove(partial.size() - 1);
        }
    }
}