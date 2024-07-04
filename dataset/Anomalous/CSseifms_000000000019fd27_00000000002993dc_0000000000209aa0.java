import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    static HashMap<Integer, String> output = new HashMap<>();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine().trim());
            for (int t = 0; t < T; t++) {
                String[] NK = br.readLine().split("\\s+");
                int N = Integer.parseInt(NK[0]);
                int K = Integer.parseInt(NK[1]);
                new Thread(new Solver(t, N, K)).start();
            }
            // Wait for all threads to finish
            while (output.size() != T) {
                Thread.yield();
            }
            // Print output
            for (int i = 0; i < T; i++) {
                System.out.println("Case #" + (i + 1) + ": " + output.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Solver implements Runnable {
        int N, K, index;

        public Solver(int index, int n, int k) {
            this.index = index;
            this.N = n;
            this.K = k;
        }

        @Override
        public void run() {
            output.put(index, solve(N, K));
        }
    }

    static String solve(int N, int K) {
        if (K % N == 0) {
            return generatePossibleMatrix(N, K / N);
        } else {
            return findPossibleMatrix(N, K);
        }
    }

    static String generatePossibleMatrix(int N, int factor) {
        StringBuilder result = new StringBuilder("POSSIBLE\n");
        for (int i = 0; i < N; i++) {
            int j = factor - i;
            for (int c = 0; c < N; c++) {
                if (j <= 0) j += N;
                if (j > N) j = 1;
                result.append(j++).append(" ");
            }
            result.setLength(result.length() - 1); // Remove trailing space
            result.append("\n");
        }
        result.setLength(result.length() - 1); // Remove trailing newline
        return result.toString();
    }

    static String findPossibleMatrix(int N, int K) {
        int[][] trialMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            int start = i + 1;
            for (int j = 0; j < N; j++) {
                if (start > N) start = 1;
                trialMatrix[i][j] = start++;
            }
        }
        if (computeDiagonal(trialMatrix) == K) {
            return matrixToString(trialMatrix);
        }
        int[][] orgMatrix = copyMatrix(trialMatrix);
        for (int i = 0; i < N; i++) {
            for (int swapped = i + 1; swapped < N; swapped++) {
                swapRows(trialMatrix, i, swapped);
                if (computeDiagonal(trialMatrix) == K) {
                    return matrixToString(trialMatrix);
                } else {
                    int[][] orgMatrix2 = copyMatrix(trialMatrix);
                    for (int col = 0; col < N; col++) {
                        for (int swappedCol = col + 1; swappedCol < N; swappedCol++) {
                            swapColumns(trialMatrix, col, swappedCol);
                            if (computeDiagonal(trialMatrix) == K) {
                                return matrixToString(trialMatrix);
                            }
                        }
                        trialMatrix = copyMatrix(orgMatrix2);
                    }
                }
            }
            trialMatrix = copyMatrix(orgMatrix);
        }
        return "IMPOSSIBLE";
    }

    static int computeDiagonal(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    static int[][] copyMatrix(int[][] original) {
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return copy;
    }

    static String matrixToString(int[][] matrix) {
        StringBuilder result = new StringBuilder("POSSIBLE\n");
        for (int[] row : matrix) {
            for (int elem : row) {
                result.append(elem).append(" ");
            }
            result.setLength(result.length() - 1); // Remove trailing space
            result.append("\n");
        }
        result.setLength(result.length() - 1); // Remove trailing newline
        return result.toString();
    }

    static void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    static void swapColumns(int[][] matrix, int col1, int col2) {
        for (int row = 0; row < matrix.length; row++) {
            int temp = matrix[row][col1];
            matrix[row][col1] = matrix[row][col2];
            matrix[row][col2] = temp;
        }
    }
}