import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String...args) {
        final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final StringBuilder out = new StringBuilder();
        final int testCases = scanner.nextInt();
        for (int i=1; i<=testCases; i++) {
            final int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rows = 0;
            for (int j=0; j<matrix.length; j++) {
                Set<Integer> onRow = new HashSet<>();
                for (int k=0; k<matrix.length; k++) {
                    matrix[j][k] = scanner.nextInt();
                    if (j == k)
                        trace += matrix[j][k];
                    onRow.add(matrix[j][k]);
                }
                if (onRow.size() != matrix.length)
                    rows++;
            }
            int cols = 0;
            for (int j=0; j<matrix.length; j++) {
                Set<Integer> onCols = new HashSet<>();
                for (int k=0; k<matrix.length; k++) {
                    onCols.add(matrix[k][j]);
                }
                if (onCols.size() != matrix.length)
                    cols++;
            }
            out.append("Case #").append(i).append(": ")
                .append(trace).append(' ')
                .append(rows).append(' ')
                .append(cols).append(' ')
                .append('\n');
        }
        System.out.print(out.toString());
    }


}