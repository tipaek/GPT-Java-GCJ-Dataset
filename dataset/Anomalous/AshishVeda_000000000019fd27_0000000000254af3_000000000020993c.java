import java.util.*;

class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases > 0) {
            int size = scanner.nextInt();
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;
            int[][] matrix = new int[size][size];

            // Reading the matrix and calculating the trace
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Checking for duplicate values in each row
            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != size) {
                    duplicateRows++;
                }
            }

            // Checking for duplicate values in each column
            for (int j = 0; j < size; j++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    columnSet.add(matrix[i][j]);
                }
                if (columnSet.size() != size) {
                    duplicateColumns++;
                }
            }

            // Printing the result for the current test case
            System.out.println(trace + " " + duplicateRows + " " + duplicateColumns);
            testCases--;
        }
    }
}