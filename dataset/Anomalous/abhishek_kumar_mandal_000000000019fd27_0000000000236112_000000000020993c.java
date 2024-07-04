import java.util.Scanner;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(scanner.next());
            int[][] matrix = new int[n][n];

            int trace = 0;
            int maxRowDuplicates = 0;
            int maxColDuplicates = 0;

            for (int i = 0; i < n; i++) {
                TreeSet<Integer> rowSet = new TreeSet<>();
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    if (i == j) {
                        trace += value;
                    }
                    rowSet.add(value);
                }
                maxRowDuplicates = Math.max(maxRowDuplicates, n - rowSet.size());
            }

            for (int i = 0; i < n; i++) {
                TreeSet<Integer> colSet = new TreeSet<>();
                for (int j = 0; j < n; j++) {
                    colSet.add(matrix[j][i]);
                }
                maxColDuplicates = Math.max(maxColDuplicates, n - colSet.size());
            }

            if (maxRowDuplicates != 0) maxRowDuplicates++;
            if (maxColDuplicates != 0) maxColDuplicates++;

            System.out.println("Case #" + testCase + ": " + trace + " " + maxRowDuplicates + " " + maxColDuplicates);
        }

        scanner.close();
    }
}