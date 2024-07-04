import java.util.HashSet;
import java.util.Scanner;

public class Answer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases > 0) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int rowCount = 0, colCount = 0, trace = 0;

            // Read matrix and calculate trace and row duplicates
            for (int i = 0; i < size; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowFlag = false;
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (rowSet.contains(matrix[i][j]) && !rowFlag) {
                        rowFlag = true;
                        rowCount++;
                    }
                    rowSet.add(matrix[i][j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Calculate column duplicates
            for (int j = 0; j < size; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean colFlag = false;
                for (int i = 0; i < size; i++) {
                    if (colSet.contains(matrix[i][j]) && !colFlag) {
                        colFlag = true;
                        colCount++;
                    }
                    colSet.add(matrix[i][j]);
                }
            }

            System.out.println(trace + " " + rowCount + " " + colCount);
            testCases--;
        }

        scanner.close();
    }
}