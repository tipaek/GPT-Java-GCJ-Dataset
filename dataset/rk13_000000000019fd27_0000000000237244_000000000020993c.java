import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = Integer.parseInt(in.nextLine());

            int[][] a = new int[n][];
            for (int j = 0; j < n; j++) {
                String s = in.nextLine();
                a[j] = Arrays.stream(s.split(" "))
                        .mapToInt(Integer::valueOf)
                        .toArray();
            }

            int k = 0;
            for (int j = 0; j < n; j++) {
                k += a[j][j];
            }

            int r = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> set = new HashSet<>();
                for (int m = 0; m < n; m++) {
                    if (!set.add(a[j][m])) {
                        r++;
                        break;
                    }
                }
            }

            int c = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> set = new HashSet<>();
                for (int m = 0; m < n; m++) {
                    if (!set.add(a[m][j])) {
                        c++;
                        break;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }
}
