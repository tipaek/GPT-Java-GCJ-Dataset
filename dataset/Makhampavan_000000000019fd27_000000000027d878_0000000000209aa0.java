import java.util.*;
class Solution{
    
    static int n, k, t;
    static int[][] arr = new int[60][60];
    static boolean[][] rows = new boolean[60][60];
    static boolean[][] cols = new boolean[60][60];
    static boolean checked;

    public static void generateMatrix(int row, int col, int m) {
        if (row == n && col == n + 1 && m == k && !checked) {
            checked = true;
            System.out.println("Case #" + t + ": " + "POSSIBLE");
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println("");
            }
            return;
        } else if (row > n) {
            return;
        } else if (col > n) {
            generateMatrix(row + 1, 1, m);
        }
        for (int i = 1; i <= n && !checked; ++i) {
            if (!rows[row][i] && !cols[col][i]) {
                rows[row][i] = cols[col][i] = true;
                if (row == col) {
                    m += i;
                }
                arr[row][col] = i;
                generateMatrix(row, col + 1, m);                
                rows[row][i] = cols[col][i] = false;
                if (row == col) {
                    m -= i;
                }
                arr[row][col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int t=1;t<=cases;t++) {
            n = sc.nextInt();
            k = sc.nextInt();
            generateMatrix(1, 1, 0);
            if (!checked) {
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
            }
            checked = false;
        }
        sc.close();
    }
}