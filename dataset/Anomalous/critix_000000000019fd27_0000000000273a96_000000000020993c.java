import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            boolean[][] rowCheck = new boolean[n][n];
            boolean[][] colCheck = new boolean[n][n];
            boolean[] rowCounted = new boolean[n];
            boolean[] colCounted = new boolean[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();

                    if (i == j) {
                        trace += value;
                    }

                    if (rowCheck[i][value - 1] && !rowCounted[i]) {
                        duplicateRows++;
                        rowCounted[i] = true;
                    }

                    if (colCheck[j][value - 1] && !colCounted[j]) {
                        duplicateColumns++;
                        colCounted[j] = true;
                    }

                    rowCheck[i][value - 1] = true;
                    colCheck[j][value - 1] = true;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", t, trace, duplicateRows, duplicateColumns);
        }

        scanner.close();
    }
}