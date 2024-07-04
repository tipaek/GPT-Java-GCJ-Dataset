import java.util.Scanner;

public class Trace {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = getValidInput(sc, "Enter Test cases between 1 and 100", 1, 100);

        for (int l = 1; l <= t; l++) {
            int n = getValidInput(sc, "Enter N between 2 and 100", 2, 100);
            int[][] matrix = new int[n][n];
            populateMatrix(sc, matrix, n);
            int trace = calculateTrace(matrix, n);
            int r_same = countRepeatedRows(matrix, n);
            int c_same = countRepeatedColumns(matrix, n);
            System.out.println(trace + " " + r_same + " " + c_same);
        }
    }

    private static int getValidInput(Scanner sc, String prompt, int min, int max) {
        int value;
        while (true) {
            System.out.println(prompt);
            value = sc.nextInt();
            if (value >= min && value <= max) {
                break;
            }
        }
        return value;
    }

    private static void populateMatrix(Scanner sc, int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Enter value at " + i + " row and " + j + " Column between 1 and " + n);
                matrix[i][j] = sc.nextInt();
            }
        }
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix, int n) {
        int r_same = 0;
        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i])) {
                r_same++;
            }
        }
        return r_same;
    }

    private static int countRepeatedColumns(int[][] matrix, int n) {
        int c_same = 0;
        for (int i = 0; i < n; i++) {
            int[] column = new int[n];
            for (int j = 0; j < n; j++) {
                column[j] = matrix[j][i];
            }
            if (hasDuplicates(column)) {
                c_same++;
            }
        }
        return c_same;
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