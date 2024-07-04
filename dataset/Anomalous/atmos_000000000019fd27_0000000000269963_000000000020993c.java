import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            System.out.print("Enter the size of the matrix: ");
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            System.out.println("Enter the matrix values: ");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix);
            int rowDuplicates = countRowDuplicates(matrix);
            int columnDuplicates = countColumnDuplicates(matrix);

            System.out.println("Case #" + t + ": Trace = " + trace + ", Row Duplicates = " + rowDuplicates + ", Column Duplicates = " + columnDuplicates);
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix) {
        int duplicates = 0;
        for (int i = 0; i < matrix.length; i++) {
            boolean[] seen = new boolean[matrix.length + 1];
            for (int j = 0; j < matrix[i].length; j++) {
                if (seen[matrix[i][j]]) {
                    duplicates++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        return duplicates;
    }

    private static int countColumnDuplicates(int[][] matrix) {
        int duplicates = 0;
        for (int j = 0; j < matrix.length; j++) {
            boolean[] seen = new boolean[matrix.length + 1];
            for (int i = 0; i < matrix.length; i++) {
                if (seen[matrix[i][j]]) {
                    duplicates++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        return duplicates;
    }
}