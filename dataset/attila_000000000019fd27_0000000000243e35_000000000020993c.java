import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = Integer.parseInt(sc.nextLine());
        for (int tt = 1; tt <= t; tt++) {
            int n = Integer.parseInt(sc.nextLine());
            int[][] matrix = new int[n][n];
            boolean[][] rows = new boolean[n][n + 1];
            boolean[][] cols = new boolean[n][n + 1];
            Set<Integer> duplicateCols = new HashSet<Integer>();
            Set<Integer> duplicateRows = new HashSet<Integer>();
            for (int i = 0; i < n; i++) {
                String[] nr = sc.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    int nrr = Integer.parseInt(nr[j]);
                    matrix[i][j] = nrr;
                    if (!rows[i][nrr]) {
                        rows[i][nrr] = true;
                    } else {
                        duplicateRows.add(i);
                    }
                    if (!cols[j][nrr]) {
                        cols[j][nrr] = true;
                    } else {
                        duplicateCols.add(j);
                    }
                }
            }
            int v = 0;
            for (int i = 0; i < n; i++) {
                v += matrix[i][i];
            }
            System.out.println("Case #" + tt + ": " + v + " " + duplicateRows.size() + " " + duplicateCols.size());
        }
    }
}
