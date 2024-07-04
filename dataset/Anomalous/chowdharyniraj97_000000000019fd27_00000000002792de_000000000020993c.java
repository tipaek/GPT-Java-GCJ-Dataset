import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            int[] ans = new int[3];
            vestigum(mat, n, ans);

            System.out.println("Trace: " + ans[0] + ", Row Duplicates: " + ans[1] + ", Column Duplicates: " + ans[2]);
        }

        sc.close();
    }

    public static void vestigum(int[][] mat, int n, int[] ans) {
        int[][] row = new int[n][n + 1];
        int[][] col = new int[n][n + 1];
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = mat[i][j];
                if (row[i][val] == 1) {
                    rowDuplicates++;
                }
                if (col[j][val] == 1) {
                    colDuplicates++;
                }
                row[i][val]++;
                col[j][val]++;
                if (i == j) {
                    trace += val;
                }
            }
        }

        ans[0] = trace;
        ans[1] = rowDuplicates;
        ans[2] = colDuplicates;
    }
}