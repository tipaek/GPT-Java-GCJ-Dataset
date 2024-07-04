import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private void solve(Scanner in) {
        int n = in.nextInt();
        if (n < 34) {
            for(int i = 1; i <= n; ++i) {
                System.out.println(i + " 1");
            }
            return;
        }
        int w = n - 32;
        int sum = 0;
        int r = 0, k = 0;
        int c = 1;
        while (w != 0) {
            r += 1;
            if (w % 2 == 1) {
                sum += c;
                if (k > 1) {
                    k = r;
                    while (k --> 0) {
                       System.out.println(r +" " + k);
                    }
                    k = 1;
                }
                else {
                    k = 0;
                    while (k ++< r) {
                        System.out.println(r + " " + k);
                    }
                    k = r;
                }
            }
            else {
                sum += 1;
            }
            c *= 2;
            w /= 2;
        }
        r += 1;
        while (sum < n) {
            System.out.println(r + " " + k);
            r++;
            sum++;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        Solution sol = new Solution();
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": ");
            sol.solve(in);
        }
    }
}
