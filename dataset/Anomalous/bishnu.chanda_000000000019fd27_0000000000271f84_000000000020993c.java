import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            boolean[][] rowNumbers = new boolean[n][101];
            boolean[][] colNumbers = new boolean[n][101];
            int[] distinctRowCounts = new int[n];
            int[] distinctColCounts = new int[n];
            int rowDuplicates = 0;
            int colDuplicates = 0;
            int trace = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int num = scanner.nextInt();
                    if (i == j) {
                        trace += num;
                    }
                    if (!rowNumbers[i][num]) {
                        distinctRowCounts[i]++;
                        rowNumbers[i][num] = true;
                    }
                    if (!colNumbers[j][num]) {
                        distinctColCounts[j]++;
                        colNumbers[j][num] = true;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (distinctRowCounts[i] != n) {
                    rowDuplicates++;
                }
                if (distinctColCounts[i] != n) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}