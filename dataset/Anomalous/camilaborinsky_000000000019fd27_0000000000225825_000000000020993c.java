import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TraceProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        List<int[]> results = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
            int dimension = scanner.nextInt();
            int[][] matrix = new int[dimension][dimension];

            for (int row = 0; row < dimension; row++) {
                for (int col = 0; col < dimension; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int[] result = calculateResults(matrix, dimension);
            results.add(result);
            System.out.println("Case #" + (i + 1) + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
    }

    public static int[] calculateResults(int[][] matrix, int dimension) {
        int[] results = new int[3]; // results[0] = trace, results[1] = row repetitions, results[2] = column repetitions

        // Calculate trace and row repetitions
        for (int i = 0; i < dimension; i++) {
            boolean rowHasRepetition = false;
            results[0] += matrix[i][i];

            for (int j = 0; j < dimension && !rowHasRepetition; j++) {
                for (int k = j + 1; k < dimension; k++) {
                    if (matrix[i][j] == matrix[i][k]) {
                        rowHasRepetition = true;
                        results[1]++;
                        break;
                    }
                }
            }
        }

        // Calculate column repetitions
        for (int i = 0; i < dimension; i++) {
            boolean colHasRepetition = false;

            for (int j = 0; j < dimension && !colHasRepetition; j++) {
                for (int k = j + 1; k < dimension; k++) {
                    if (matrix[j][i] == matrix[k][i]) {
                        colHasRepetition = true;
                        results[2]++;
                        break;
                    }
                }
            }
        }

        return results;
    }
}