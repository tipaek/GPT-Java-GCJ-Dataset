import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int trace = 0;
            int rowDuplicates = 0;
            int columnDuplicates = 0;
            int n = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                String[] values = scanner.nextLine().split("\\s+");
                Set<Integer> rowSet = new HashSet<>();
                boolean hasRowDuplicate = false;

                for (int col = 0; col < n; col++) {
                    int value = Integer.parseInt(values[col]);
                    matrix[row][col] = value;

                    if (!rowSet.add(value)) {
                        hasRowDuplicate = true;
                    }

                    if (row == col) {
                        trace += value;
                    }
                }

                if (hasRowDuplicate) {
                    rowDuplicates++;
                }
            }

            for (int col = 0; col < n; col++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasColDuplicate = false;

                for (int row = 0; row < n; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        hasColDuplicate = true;
                        break;
                    }
                }

                if (hasColDuplicate) {
                    columnDuplicates++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }

        scanner.close();
    }
}