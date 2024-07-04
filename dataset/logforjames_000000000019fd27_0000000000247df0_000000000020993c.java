import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int caso = 1; caso <= t; ++caso) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0;i < n;i ++) for (int j = 0;j < n;j++) {
                matrix[i][j] = in.nextInt();
            }

            int traza = IntStream.range(0, n).map(i -> matrix[i][i]).sum();
            long repeatedRows = IntStream.range(0, n).filter(fila -> IntStream.range(0, n).map(i -> matrix[fila][i]).distinct().count() != n).count();
            long repeatedCols = IntStream.range(0, n).filter(col -> IntStream.range(0, n).map(i -> matrix[i][col]).distinct().count() != n).count();

            System.out.println("Case #" + caso + ": " + traza + " " + repeatedRows + " " + repeatedCols);
        }
    }
}
