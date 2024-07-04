import java.util.*;
import java.io.*;

public class Solution {

    static Stack<String> path;
    static boolean success;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int loop=1; loop<=T; loop++) {
            int n = in.nextInt();

            path = new Stack<>();
            visited = new boolean[501][501];
            success = false;

            solve(n, 0, 0, 0, 0);

            // pop the strings and add to the text builder
            StringBuilder builder = new StringBuilder();
            while (!path.empty()) {
                builder.append(path.pop());
                builder.append('\n');
            }

            String result = builder.toString();

            sb.append("Case #");
            sb.append(loop);
            sb.append(": \n");
            sb.append(result);
        }

        System.out.print(sb.toString());
    }

    private static void solve(int n, int r, int k, int steps, long soFar) {

        if (soFar > n || steps > 500 || r < 0 || k < 0 || k > r || visited[r][k]) return;

        if (soFar == n) {
            // success case

            success = true;
            return;
        }

        // need to do the recursive step

        visited[r][k] = true;

        long toAdd = NCR(r, k);

        solve(n, r-1, k-1, steps+1, soFar+toAdd);

        if (success) {
            path.push((r+1) + " " + (k+1));
            return;
        }

        solve(n, r-1, k, steps+1, soFar+toAdd);

        if (success) {
            path.push((r+1) + " " + (k+1));
            return;
        }

        solve(n, r, k-1, steps+1, soFar+toAdd);

        if (success) {
            path.push((r+1) + " " + (k+1));
            return;
        }

        solve(n, r, k+1, steps+1, soFar+toAdd);

        if (success) {
            path.push((r+1) + " " + (k+1));
            return;
        }

        solve(n, r+1, k, steps+1, soFar+toAdd);

        if (success) {
            path.push((r+1) + " " + (k+1));
            return;
        }

        solve(n, r+1, k+1, steps+1, soFar+toAdd);

        if (success) {
            path.push((r+1) + " " + (k+1));
        }
    }

    static long NCR(int n, int r) {

        // p holds the value of n*(n-1)*(n-2)...,
        // k holds the value of r*(r-1)...
        long p = 1, k = 1;

        // C(n, r) == C(n, n-r),
        // choosing the smaller value
        if (n - r < r) {
            r = n - r;
        }

        if (r != 0) {
            while (r > 0) {
                p *= n;
                k *= r;

                // gcd of p, k
                long m = __gcd(p, k);

                // dividing by gcd, to simplify product
                // division by their gcd saves from the overflow
                p /= m;
                k /= m;

                n--;
                r--;
            }

            // k should be simplified to 1
            // as C(n, r) is a natural number
            // (denominator should be 1 ) .
        } else {
            p = 1;
        }

        // if our approach is correct p = ans and k =1
        return p;
    }

    static long __gcd(long n1, long n2) {
        long gcd = 1;

        for (int i = 1; i <= n1 && i <= n2; ++i) {
            // Checks if i is factor of both integers
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}


