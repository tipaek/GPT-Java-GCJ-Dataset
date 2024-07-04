import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int trace = 0;
            int n = scanner.nextInt();
            int[][] columns = new int[n][n];
            int rowDuplicates = 0;

            for (int i = 0; i < n; i++) {
                int[] row = new int[n];
                for (int j = 0; j < n; j++) {
                    int num = scanner.nextInt();
                    if (i == j) {
                        trace += num;
                    }
                    row[num - 1]++;
                    columns[j][num - 1]++;
                }

                for (int j = 0; j < n; j++) {
                    if (row[j] > 1) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            int columnDuplicates = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (columns[i][j] > 1) {
                        columnDuplicates++;
                        break;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowDuplicates, columnDuplicates);
        }
    }
}