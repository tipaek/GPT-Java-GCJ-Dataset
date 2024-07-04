import java.util.*;

public class Solution {

    public static void ref(int[][] ar, int n, int q) {
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;
        String rowString = "", colString = "";
        int[] rowCount = new int[10];
        int[] colCount = new int[10];

        for (int i = 0; i < n * n; i++) {
            int row = i / n;
            int col = i % n;

            rowString += ar[row][col];
            colString += ar[col][row];

            if (col == n - 1) {
                System.out.println("row " + rowString);
                System.out.println("col " + colString);

                for (char c : rowString.toCharArray()) {
                    if (rowCount[c - '0']++ > 0) rowDuplicates++;
                }
                for (char c : colString.toCharArray()) {
                    if (colCount[c - '0']++ > 0) colDuplicates++;
                }

                Arrays.fill(rowCount, 0);
                Arrays.fill(colCount, 0);

                rowString = "";
                colString = "";
            }

            if (row == col) {
                trace += ar[row][col];
            }
        }

        System.out.format("Case #%d: %d %d %d\n", q, trace, rowDuplicates, colDuplicates);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int j = 0; j < n * n; j++) {
                int row = j / n;
                int col = j % n;
                arr[row][col] = sc.nextInt();
            }

            ref(arr, n, i);
        }
    }
}