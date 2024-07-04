import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    boolean isDone = false;
    static int[][] resultMatrix = null;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= testCases; i++) {
            String[] number = reader.readLine().split(" ");
            int N = Integer.parseInt(number[0]);
            int k = Integer.parseInt(number[1]);
            Solution solution = new Solution();
            boolean result = solution.solve(N, k);
            StringBuilder sb = new StringBuilder();
            sb.append("Case #" + i + ": " + (result ? "POSSIBLE" : "IMPOSSIBLE"));
            System.out.println(sb.toString());
            if (result) {
                for (int j = 0; j < N; j++) {
                    for (int l = 0; l < N; l++) {
                        System.out.print(resultMatrix[j][l]);
                        if (l != N-1) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

    private boolean solve(int N, int k) {
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
        }
        diagonalBacktrack(new ArrayList<>(), nums, k, 0, N);
        return isDone;
    }

    private void diagonalBacktrack(List<Integer> tempList, int[] nums, int remain, int start, int remainPlace) {
        if (isDone) return;
        if (remain < 0 || remainPlace < 0) return;
        else if (remain == 0 && remainPlace == 0) {
            solveLatinSquare(tempList);
            if (isDone) return;
        } else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                diagonalBacktrack(tempList, nums, remain - nums[i], i, remainPlace - 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private void solveLatinSquare(List<Integer> diagonal) {
        int N = diagonal.size();
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            matrix[i][i] = diagonal.get(i);
        }
        isDone = latinSquareBacktrack(matrix);
        resultMatrix = matrix;
    }

    private boolean latinSquareBacktrack(int[][] board) {
        int N = board.length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    for (int c = 1; c <= N; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c; //Put c for this cell

                            if (latinSquareBacktrack(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = 0; //Otherwise go back
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int[][] board, int row, int col, int c) {
        int N = board.length;
        for (int i = 0; i < N; i++) {
            if (board[i][col] != 0 && board[i][col] == c) return false; //check row
            if (board[row][i] != 0 && board[row][i] == c) return false; //check column
        }
        return true;
    }
}
