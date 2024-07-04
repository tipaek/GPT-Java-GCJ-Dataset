import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    static HashMap<Integer, String> output = new HashMap<>();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine().trim());

            for (int t = 0; t < T; t++) {
                int N = Integer.parseInt(br.readLine().trim());
                int[][] mat = new int[N][N];
                int[][] matTranspose = new int[N][N];

                int trace = 0;
                for (int i = 0; i < N; i++) {
                    String[] colVals = br.readLine().split("\\s+");
                    for (int j = 0; j < N; j++) {
                        mat[i][j] = Integer.parseInt(colVals[j]);
                        matTranspose[j][i] = mat[i][j];
                        if (i == j) {
                            trace += mat[i][j];
                        }
                    }
                }

                Solver solver = new Solver(mat, matTranspose, trace, t);
                new Thread(solver).start();
            }

            // Wait for all threads to complete
            while (output.size() != T) {
                Thread.yield();
            }

            // Output results
            for (int i = 0; i < T; i++) {
                System.out.println("Case #" + (i + 1) + ": " + output.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Solver implements Runnable {
        int index;
        int[][] matrix;
        int[][] transposedMatrix;
        int trace;

        public Solver(int[][] matrix, int[][] transposedMatrix, int trace, int index) {
            this.index = index;
            this.matrix = matrix;
            this.transposedMatrix = transposedMatrix;
            this.trace = trace;
        }

        @Override
        public void run() {
            output.put(index, solve(matrix, transposedMatrix, trace));
        }

        private String solve(int[][] mat, int[][] matTransposed, int trace) {
            int repeatRowsCounter = 0;
            int repeatColsCounter = 0;

            for (int i = 0; i < mat.length; i++) {
                if (hasDuplicates(mat[i])) repeatRowsCounter++;
                if (hasDuplicates(matTransposed[i])) repeatColsCounter++;
            }

            return trace + " " + repeatRowsCounter + " " + repeatColsCounter;
        }

        private boolean hasDuplicates(int[] arr) {
            HashSet<Integer> set = new HashSet<>();
            for (int num : arr) {
                if (!set.add(num)) return true;
            }
            return false;
        }
    }
}