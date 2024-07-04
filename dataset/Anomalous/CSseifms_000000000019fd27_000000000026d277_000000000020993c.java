import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {

    static Map<Integer, String> output = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            Integer[][] mat = new Integer[N][N];
            Integer[][] matTranspose = new Integer[N][N];

            int trace = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    mat[i][j] = scanner.nextInt();
                    matTranspose[j][i] = mat[i][j];
                    if (i == j) trace += mat[i][j];
                }
            }
            Solver solver = new Solver(mat, matTranspose, trace, t);
            new Thread(solver).start();
        }
        scanner.close();

        while (output.size() != T) {
            // Busy wait
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + output.get(i));
        }
    }

    static class Solver implements Runnable {
        int index;
        Integer[][] matrix;
        Integer[][] transposedMatrix;
        int trace;

        public Solver(Integer[][] matrix, Integer[][] transposedMatrix, int trace, int index) {
            this.index = index;
            this.matrix = matrix;
            this.transposedMatrix = transposedMatrix;
            this.trace = trace;
        }

        @Override
        public void run() {
            output.put(index, solve(matrix, transposedMatrix, trace));
        }

        String solve(Integer[][] mat, Integer[][] matTransposed, int trace) {
            int repeatRowsCounter = 0;
            int repeatColsCounter = 0;

            for (int i = 0; i < mat.length; i++) {
                if (repeatRowsCounter < mat.length) {
                    repeatRowsCounter += findDuplicates(mat[i]);
                }
                if (repeatColsCounter < matTransposed.length) {
                    repeatColsCounter += findDuplicates(matTransposed[i]);
                }

                if (repeatRowsCounter == mat.length && repeatColsCounter == matTransposed.length) {
                    return trace + " " + repeatRowsCounter + " " + repeatColsCounter;
                }
            }
            return trace + " " + repeatRowsCounter + " " + repeatColsCounter;
        }

        int findDuplicates(Integer[] arr) {
            Set<Integer> seen = new HashSet<>();
            Set<Integer> duplicates = new HashSet<>();
            for (Integer num : arr) {
                if (!seen.add(num)) {
                    duplicates.add(num);
                }
            }
            return duplicates.size() > 0 ? 1 : 0;
        }
    }
}