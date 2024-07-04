import java.util.Scanner;
import java.util.HashSet;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int rowRepeats = 0;
            // Check for repeated elements in rows
            for (int i = 0; i < size; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            int columnRepeats = 0;
            // Check for repeated elements in columns
            for (int j = 0; j < size; j++) {
                HashSet<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    if (!columnSet.add(matrix[i][j])) {
                        columnRepeats++;
                        break;
                    }
                }
            }

            System.out.format("Case #%d: %d %d %d\n", caseNumber, trace, rowRepeats, columnRepeats);
        }

        scanner.close();
    }
}