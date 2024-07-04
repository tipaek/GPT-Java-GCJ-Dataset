import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < testCases; t++) {
            int n = Integer.parseInt(scanner.nextLine());
            String[][] matrix = new String[n][n];

            for (int i = 0; i < n; i++) {
                matrix[i] = scanner.nextLine().split(" ");
            }

            int trace = calculateTrace(matrix);
            int repeatedRows = countRepeatedRows(matrix);
            int repeatedCols = countRepeatedCols(matrix);

            System.out.printf("Case #%d: %d %d %d%n", t + 1, trace, repeatedRows, repeatedCols);
        }

        scanner.close();
    }

    private static int calculateTrace(String[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += Integer.parseInt(matrix[i][i]);
        }
        return trace;
    }

    private static int countRepeatedRows(String[][] matrix) {
        int count = 0;
        for (String[] row : matrix) {
            if (hasDuplicates(row)) {
                count++;
            }
        }
        return count;
    }

    private static int countRepeatedCols(String[][] matrix) {
        int count = 0;
        int n = matrix.length;
        for (int col = 0; col < n; col++) {
            String[] column = new String[n];
            for (int row = 0; row < n; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                count++;
            }
        }
        return count;
    }

    private static boolean hasDuplicates(String[] array) {
        Set<String> set = new HashSet<>();
        for (String value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}