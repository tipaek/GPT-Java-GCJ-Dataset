import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Solution
 *
 * @author dongyoung
 * @since 2020-04-04
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();// Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int[][] arr = new int[n][2];
            for (int j = 0; j < n; j++) {
                arr[j][0] = in.nextInt();
                arr[j][1] = in.nextInt();
            }

            System.out.println("Case #" + i + ": " + solution(arr, n));
        }
    }

    public static String solution(int[][] arr, int n) {
        Comparator<int[]> comp = Comparator.comparing(a -> a[0]);
        Arrays.sort(arr, comp);

        int lastC = 0;
        int lastJ = 0;

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];
            if (start >= lastC) {
                res.append("C");
                lastC = end;
                continue;
            }

            if (start >= lastJ) {
                res.append("J");
                lastJ = end;
                continue;
            }
            return "IMPOSSIBLE";
        }
        return res.toString();
    }
}
