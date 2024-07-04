import java.util.*;
import java.io.*;

public class Solution {
        public static void main(String[] args) {
                Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
                int t = in.nextInt();
                for (int i = 1; i <= t; ++i) {
                        int n = in.nextInt();

                        boolean[] c = new boolean[1441];
                        boolean[] j = new boolean[1441];
                        boolean failed = false;

                        StringBuilder sb = new StringBuilder();

                        for (int k = 0; k < n; k++) {
                                int from  = in.nextInt();
                                int to = in.nextInt();
                                if (!failed){
                                        if (schedule(c, from, to)) {
                                                sb.append('C');
                                        } else if (schedule(j, from, to)) {
                                                sb.append('J');
                                        } else {
                                                System.out.println("Case #" + i + ": IMPOSSIBLE");
                                                failed = true;
                                        }
                                }
                        }

                        if (!failed) {
                                System.out.println("Case #" + i + ": " + sb.toString());
                        }
                }
        }

        private static boolean schedule(boolean[] p, int from, int to) {
                for (int m = from; m <= to; m++) {
                        if (p[m] && (m != from || m == to)) {
                                return false;
                        }
                }

                for (int m = from; m <= to; m++) {
                        p[m] = true;
                }

                return true;
        }
}
