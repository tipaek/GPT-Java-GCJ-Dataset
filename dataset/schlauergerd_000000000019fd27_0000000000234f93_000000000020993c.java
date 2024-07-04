import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        scanner.nextLine();

        for (int test = 1; test <= tests; test++) {
            String result = runSingleTest(scanner);
            System.out.printf("Case #%d: %s%n", test, result);
        }
    }

    public static String runSingleTest(Scanner scanner) {
        int n = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int k = k(matrix, n);
        int r = r(matrix, n);
        int c = c(matrix, n);

        return k + " " + r + " " + c;
    }

    private static int k(int[][] matrix, int n) {
        int k = 0;
        for (int i = 0; i < n; i++) {
            k += matrix[i][i];
        }
        return k;
    }

    private static int r(int[][] matrix, int n) {
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (Arrays.stream(matrix[i]).distinct().count() < n) {
                r++;
            }
        }
        return r;
    }

    private static int c(int[][] matrix, int n) {
        int c = 0;
        for (int i = 0; i < n; i++) {
            int x = i;
            if (Arrays.stream(matrix).map(row -> row[x]).distinct().count() < n) {
                c++;
            }
        }
        return c;
    }
}