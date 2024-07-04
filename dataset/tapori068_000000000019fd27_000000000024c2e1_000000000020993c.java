import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int[][] mat = new int[N][N];
            for (int j = 0; j<N ;j++) {
                for (int k = 0; k < N; k++) {
                    mat[j][k] = in.nextInt();
                }
            }
            int trace = 0;
            int colCount = 0, rowCount = 0;
            for (int j = 0; j<N ;j++) {
                trace += mat[j][j];
                Set<Integer> row = new HashSet<Integer>();
                Set<Integer> col = new HashSet<Integer>();
                boolean rowRepeated = false, colRepeated = false;
                for (int k = 0; k < N; k++) {
                    rowRepeated = rowRepeated || row.contains(mat[j][k]);
                    row.add(mat[j][k]);
                    colRepeated = colRepeated || col.contains(mat[k][j]);
                    col.add(mat[k][j]);
                }
                rowCount += rowRepeated? 1 : 0;
                colCount += colRepeated? 1 : 0;
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}
