import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        for (int test = 1; test <= tests; ++test) {
            int n = in.nextInt();
            in.nextLine();
            int t = 0;
            int[][] row = new int[n][n];
            int[][] col = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    int cur = in.nextInt();
                    if (i == j)
                        t += cur;
                    row[i][cur - 1] = 1;
                    col[j][cur - 1] = 1;
                }
            }
            long rowRes = Arrays.stream(row).filter(ints -> Arrays.stream(ints).filter(value -> value == 0).count() != 0).count();
            long colRes = Arrays.stream(col).filter(ints -> Arrays.stream(ints).filter(value -> value == 0).count() != 0).count();

            System.out.print("Case #" + test + ": " + t + " " + rowRes + " " + colRes);
            System.out.println();

        }
    }
}