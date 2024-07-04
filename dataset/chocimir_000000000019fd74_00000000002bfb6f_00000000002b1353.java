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
        int r = 0;
        boolean left = true;
        int c = 1;
        while (w != 0) {
            r += 1;
            if (w % 2 == 0) {
                sum += 1;
                int k = left ? 1 : r;
                System.out.println(r + " " + k);
            }
            else {
                sum += c;
                if (left) {
                    for(int i = 1; i <= r; ++i) {
                        System.out.println(r + " " + i);
                    }
                }
                else {
                    for(int i = r; i > 0; --i) {
                        System.out.println(r + " " + i);
                    }
                }
                left = !left;
            }
            c *= 2;
            w /= 2;
        }
        while (sum < n) {
            r += 1;
            int k = left ? 1 : r;
            System.out.println(r + " " + k);
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
