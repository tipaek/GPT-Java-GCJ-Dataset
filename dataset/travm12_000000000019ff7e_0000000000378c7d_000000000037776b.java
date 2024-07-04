
import java.util.*;
import java.io.*;

public class Solution {
    public static PrintWriter out;
    public static boolean DEBUG = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = sc.nextInt(), cc = 0;
        Random rand = new Random();
        while (t-->0) {
            long k = sc.nextLong() * 2;
            int n = sc.nextInt();
            long[] vals = new long[n];
            for (int i = 0; i < n; i++) {
                vals[i] = sc.nextLong() * 2;
            }
            long[] xs = new long[n + 2];
            for (int i = 0; i < n - 1; i++) {
                xs[i] = vals[i + 1] - vals[i];
            }
            xs[n-1] = k + vals[0] - vals[n-1];
            xs[n] = xs[0];
            xs[n+1] = xs[1];

            for (int i = 0; i < n; i++) {
                sc.nextLong();
            }
            if (n == 2) {
                if (xs[0] == xs[1]) {
                    out.printf("Case #%d: %s%n", ++cc, 2);
                }
                else {
                    out.printf("Case #%d: %s%n", ++cc, 3);
                }
                continue;
            }

            if (k > 21) {
                out.close();
                return;
            }
            int ans = 1000;
            TreeSet<Integer> contains = new TreeSet<Integer>();
            for (int i = 0; i < n; i++) {
                contains.add((int)vals[i]);

            }
            for (int i = 0; i < (1<<k); i++) {
                boolean good = true;
                if (ans <= Integer.bitCount(i) || Integer.bitCount(i) < 2) continue;
                ArrayList<Integer> locs = new ArrayList<Integer>();
                for (int j = 0; good && j < k; j++) {
                    if (0!=((1<<j)&i)) {
                        locs.add(j);
                        if (contains.contains(j))
                            good = false;
                    }
                }
                int count = 0;
                int m = locs.size();
                for (int j = 1; good && j < m; j++){
                    int a = locs.get(j) + locs.get(j - 1);
                    if ((a&1)==0) {
                        if (contains.contains(a>>1))
                            count++;
                    }
                }
                if (good) {
                    int a = (int)k + locs.get(0) + locs.get(m - 1);
                    if ((a&1)==0) {
                        if (contains.contains(a>>1))
                            count++;
                    }

                    good = (count == n);
                }

                if (good) ans = Integer.bitCount(i);
            }

            out.printf("Case #%d: %s%n", ++cc, ans);


        }
        out.close();
        sc.close();
    }

}