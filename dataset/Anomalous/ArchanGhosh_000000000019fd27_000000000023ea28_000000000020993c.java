import java.util.Scanner;

public class Trace {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = getValidInput(sc, "Enter Test cases between 1 and 100", 1, 100);

        for (int l = 1; l <= t; l++) {
            int n = getValidInput(sc, "Enter N between 2 and 100", 2, 100);
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("Enter value at %d row and %d column between 1 and %d: ", i, j, n);
                    matrix[i][j] = sc.nextInt();
                }
            }

            int trace = calculateTrace(matrix, n);
            int rSame = countRepeatedRows(matrix, n);
            int cSame = countRepeatedColumns(matrix, n);

            System.out.printf("%d %d %d%n", trace, rSame, cSame);
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

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix, int n) {
        int rSame = 0;
        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i])) {
                rSame++;
            }
        }
        return rSame;
    }

    private static int countRepeatedColumns(int[][] matrix, int n) {
        int cSame = 0;
        for (int i = 0; i < n; i++) {
            int[] column = new int[n];
            for (int j = 0; j < n; j++) {
                column[j] = matrix[j][i];
            }
            if (hasDuplicates(column)) {
                cSame++;
            }
        }
        return cSame;
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