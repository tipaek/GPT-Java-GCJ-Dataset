import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of test cases: ");
        int testCaseCount = scan.nextInt();

        for (int t = 1; t <= testCaseCount; t++) {
            System.out.println("Enter the size of the matrix: ");
            int size = scan.nextInt();
            int[][] matrix = new int[size][size];

            System.out.println("Enter the matrix values: ");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scan.nextInt();
                }
            }

            int trace = calculateTrace(matrix);
            int rowDuplicates = countRowDuplicates(matrix);
            int columnDuplicates = countColumnDuplicates(matrix);

            System.out.println("Case #" + t + ": Trace = " + trace + ", Row Duplicates = " + rowDuplicates + ", Column Duplicates = " + columnDuplicates);
        }

        scan.close();
    }

    public static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int countRowDuplicates(int[][] matrix) {
        int duplicateCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            boolean[] seen = new boolean[matrix.length + 1];
            for (int j = 0; j < matrix[i].length; j++) {
                if (seen[matrix[i][j]]) {
                    duplicateCount++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        return duplicateCount;
    }

    public static int countColumnDuplicates(int[][] matrix) {
        int duplicateCount = 0;
        for (int j = 0; j < matrix.length; j++) {
            boolean[] seen = new boolean[matrix.length + 1];
            for (int i = 0; i < matrix.length; i++) {
                if (seen[matrix[i][j]]) {
                    duplicateCount++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        return duplicateCount;
    }
}