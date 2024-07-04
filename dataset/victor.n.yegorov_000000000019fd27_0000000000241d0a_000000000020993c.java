import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    private static String solve(Scanner sc) {
        final int n = sc.nextInt();
        final int[][] a = new int[n][n];
        IntStream.range(0, n).forEach(i -> IntStream.range(0, n).forEach(j -> a[i][j] = sc.nextInt()));
        final int trace = IntStream.range(0, n).map(i -> a[i][i]).sum();
        final int rows = IntStream.range(0, n).map(i -> (IntStream.range(0, n).map(j -> a[i][j]).distinct().count() == n) ? 0 : 1).sum();
        final int cols = IntStream.range(0, n).map(j -> (IntStream.range(0, n).map(i -> a[i][j]).distinct().count() == n) ? 0 : 1).sum();
        return String.format("%d %d %d", trace, rows, cols);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= t; ++i) {
            String output = solve(sc);
            sb.append("Case #").append(i).append(": ").append(output).append("\n");
        }

        System.out.print(sb);
    }
}