import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Calculate trace
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            // Check for duplicate values in rows
            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() < size) {
                    rowRepeats++;
                }
            }

            // Check for duplicate values in columns
            for (int i = 0; i < size; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    colSet.add(matrix[j][i]);
                }
                if (colSet.size() < size) {
                    colRepeats++;
                }
            }

            System.out.println(trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}