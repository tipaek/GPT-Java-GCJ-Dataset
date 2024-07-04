import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int trace = 0;
            int n = scanner.nextInt();
            int[][] columns = new int[n][n];
            int repeatedRows = 0;

            for (int i = 0; i < n; i++) {
                int[] rowCheck = new int[n];
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    if (i == j) {
                        trace += value;
                    }
                    rowCheck[value - 1]++;
                    columns[j][value - 1]++;
                }

                for (int count : rowCheck) {
                    if (count > 1) {
                        repeatedRows++;
                        break;
                    }
                }
            }

            int repeatedColumns = 0;

            for (int i = 0; i < n; i++) {
                for (int count : columns[i]) {
                    if (count > 1) {
                        repeatedColumns++;
                        break;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", t, trace, repeatedRows, repeatedColumns);
        }
    }
}