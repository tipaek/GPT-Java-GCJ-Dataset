import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MatrixAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0;
            int rowRepetitions = 0;
            int colRepetitions = 0;

            // Reading matrix and calculating trace
            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepetitions++;
                        break;
                    }
                }
            }

            // Calculating column repetitions
            for (int j = 0; j < size; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colRepetitions++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowRepetitions + " " + colRepetitions);
        }
    }
}