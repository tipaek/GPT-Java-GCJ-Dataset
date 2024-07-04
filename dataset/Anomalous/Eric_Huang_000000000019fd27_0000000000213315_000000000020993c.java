import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            boolean[][] rowCheck = new boolean[n + 1][n + 1];
            boolean[][] colCheck = new boolean[n + 1][n + 1];
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            boolean[] colFlags = new boolean[n + 1];

            for (int i = 0; i < n; i++) {
                boolean rowFlag = true;

                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();

                    if (rowCheck[i][value] && rowFlag) {
                        rowFlag = false;
                        rowRepeats++;
                    }

                    if (colCheck[j][value] && !colFlags[j]) {
                        colFlags[j] = true;
                        colRepeats++;
                    }

                    rowCheck[i][value] = true;
                    colCheck[j][value] = true;

                    if (i == j) {
                        trace += value;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, rowRepeats, colRepeats);
        }

        scanner.close();
    }
}