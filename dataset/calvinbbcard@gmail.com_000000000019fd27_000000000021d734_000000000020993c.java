import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int q = reader.nextInt();
        int c = 1;
        while (c <= q) {
            int n = reader.nextInt();
            int[][] mat = new int[n][n];
            for (int i=0;i<n;i++)
                for (int j=0;j<n;j++)
                    mat[i][j] = reader.nextInt();
            int trace = 0;
            int row = 0;
            int col = 0;
            for (int i=0;i<n;i++) trace += mat[i][i];
            for (int i=0;i<n;i++) {
                Set<Integer> set1 = new HashSet<>();
                Set<Integer> set2 = new HashSet<>();
                for (int j=0;j<n;j++) {
                    set1.add(mat[i][j]);
                    set2.add(mat[j][i]);
                }
                if (set1.size() != n) row++;
                if (set2.size() != n) col++;
            }
            System.out.printf("Case #%d: %d %d %d\n", c++, trace, row, col);
        }
    }
}