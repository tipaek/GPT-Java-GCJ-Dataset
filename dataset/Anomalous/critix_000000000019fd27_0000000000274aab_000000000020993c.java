import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            boolean[][] rowTracker = new boolean[n][n];
            boolean[][] columnTracker = new boolean[n][n];
            boolean[] rowCounted = new boolean[n];
            boolean[] columnCounted = new boolean[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();

                    if (i == j) {
                        trace += value;
                    }

                    if (rowTracker[i][value - 1] && !rowCounted[i]) {
                        duplicateRows++;
                        rowCounted[i] = true;
                    }

                    if (columnTracker[j][value - 1] && !columnCounted[j]) {
                        duplicateColumns++;
                        columnCounted[j] = true;
                    }

                    rowTracker[i][value - 1] = true;
                    columnTracker[j][value - 1] = true;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}