import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();

        for (int testCase = 1; testCase <= numTestCases; testCase++) {
            int N = scanner.nextInt();
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                int[] rowCheck = new int[N];
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    rowCheck[matrix[i][j] - 1]++;
                }
                if (hasDuplicates(rowCheck)) {
                    duplicateRows++;
                }
            }

            for (int j = 0; j < N; j++) {
                int[] colCheck = new int[N];
                for (int i = 0; i < N; i++) {
                    colCheck[matrix[i][j] - 1]++;
                }
                if (hasDuplicates(colCheck)) {
                    duplicateColumns++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, duplicateRows, duplicateColumns);
        }

        scanner.close();
    }

    private static boolean hasDuplicates(int[] checkArray) {
        for (int count : checkArray) {
            if (count != 1) {
                return true;
            }
        }
        return false;
    }
}