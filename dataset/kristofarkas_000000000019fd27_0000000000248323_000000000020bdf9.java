import java.util.*;
import java.io.*;

public class Solution {
        public static void main(String[] args) {
                Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
                int t = in.nextInt();
                for (int i = 1; i <= t; ++i) {
                        schedule(i, in);
                }
        }

        private static void schedule(int i, Scanner in) {
                int n = in.nextInt();

                boolean[] c = new boolean[1441];
                boolean[] j = new boolean[1441];

                StringBuilder sb = new StringBuilder();

                for (int k = 0; k < n; k++) {
                        int from  = in.nextInt();
                        int to = in.nextInt();
                        if (schedule(c, from, to)) {
                                sb.append('C');
                        } else if (schedule(j, from, to)) {
                                sb.append('J');
                        } else {
                                System.out.println("Case #" + i + ": IMPOSSIBLE");
                                return;
                        }
                }

                System.out.println("Case #" + i + ": " + sb.toString());
        }

        private static boolean schedule(boolean[] p, int from, int to) {
                for (int m = from; m < to; m++) {
                        if (p[m]) {
                                return false;
                        }
                }

                for (int m = from; m < to; m++) {
                        p[m] = true;
                }

                return true;
        }
}
