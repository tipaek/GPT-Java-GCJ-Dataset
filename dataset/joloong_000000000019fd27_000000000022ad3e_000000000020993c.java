import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = sc.nextInt();

        for (int i = 0; i < numOfCases; i++) {
            int N = sc.nextInt();
            int trace = 0;
            int row = 0;
            int col = 0;

            int[][] grid = new int[N][N];

            for (int j = 0; j < N; j++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowLatin = false;
                for (int k = 0; k < N; k++) {
                    int d = sc.nextInt();
                    grid[j][k] = d;

                    if (j == k) {
                        trace += d;
                    }

                    if (rowLatin) {
                        continue;
                    }

                    if (rowSet.contains(d)) {
                        rowLatin = true;
                        row++;
                    } else {
                        rowSet.add(d);
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean colLatin = false;
                for (int k = 0; k < N; k++) {
                    if (colLatin) {
                        continue;
                    }

                    if (colSet.contains(grid[k][j])) {
                        colLatin = true;
                        col++;
                    } else {
                        colSet.add(grid[k][j]);
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + row + " " + col);
        }

        sc.close();
    }
}