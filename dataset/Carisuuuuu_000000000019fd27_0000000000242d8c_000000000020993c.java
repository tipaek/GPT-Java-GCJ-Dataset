import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int g = 1; g <= t; ++g) {
            int n = in.nextInt();
            int[][] m = new int[n][n];
            for (int j = 0; j < n; ++j)
                for (int i = 0; i < n; ++i)
                    m[i][j] = in.nextInt();
            int k = IntStream.range(0, n)
                    .map(p -> m[p][p])
                    .sum();
            int r = IntStream.range(0, n)
                    .map(pj -> (int) IntStream.range(0, n)
                            .map(pi -> m[pi][pj])
                            .distinct()
                            .count())
                    .map(cnt -> cnt < n ? 1 : 0)
                    .sum();
            int c = IntStream.range(0, n)
                    .map(pi -> (int) Arrays.stream(m[pi], 0, n)
                            .distinct()
                            .count())
                    .map(cnt -> cnt < n ? 1 : 0)
                    .sum();
            System.out.println("Case #" + g + ": " + k + " " + r + " " + c);
        }
    }
}
