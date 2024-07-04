import java.util.Scanner;

public class TraceCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = getValidInput(scanner, "Enter Test cases between 1 and 100", 1, 100);

        for (int t = 0; t < testCases; t++) {
            int n = getValidInput(scanner, "Enter N between 2 and 100", 2, 100);
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = getValidInput(scanner, "Enter value at " + i + " row and " + j + " Column between 1 and " + n, 1, n);
                }
            }

            int trace = calculateTrace(matrix, n);
            int rowDuplicates = countRowDuplicates(matrix, n);
            int columnDuplicates = countColumnDuplicates(matrix, n);

            System.out.println(trace + " " + rowDuplicates + " " + columnDuplicates);
        }

        scanner.close();
    }

    private static int getValidInput(Scanner scanner, String message, int min, int max) {
        int input;
        while (true) {
            System.out.println(message);
            input = scanner.nextInt();
            if (input >= min && input <= max) {
                break;
            }
        }
        return input;
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix, int n) {
        int rowDuplicates = 0;
        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i])) {
                rowDuplicates++;
            }
        }
        return rowDuplicates;
    }

    private static int countColumnDuplicates(int[][] matrix, int n) {
        int columnDuplicates = 0;
        for (int j = 0; j < n; j++) {
            int[] column = new int[n];
            for (int i = 0; i < n; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                columnDuplicates++;
            }
        }
        return columnDuplicates;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}