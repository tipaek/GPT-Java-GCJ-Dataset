import java.util.Scanner;

class Solution {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int trace = 0;
            int row = 0;
            int column = 0;
            int[] columns = new int[n];
            int[][] columns2D = new int[n][n];
            for (int j = 0; j < n; j++) {
                int[] rows = new int[n];
                int previousRow = row;
                for (int k = 0; k < n; k++) {
                    int e = sc.nextInt();
                    if (k == j) {
                        trace += e;
                    }
                    if (rows[e - 1] == 0) {
                        rows[e - 1]++;
                    } else if (previousRow == row) {
                        row++;
                    }
                    if (columns2D[k][e - 1] == 0) {
                        columns2D[k][e - 1]++;
                    } else if (columns[k] == 0) {
                        column++;
                        columns[k]++;
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + row + " " + column);
        }
    }
}