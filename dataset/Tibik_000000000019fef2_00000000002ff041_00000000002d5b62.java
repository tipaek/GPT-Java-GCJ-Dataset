import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static StringTokenizer st;
    static PrintWriter pw;
    static BufferedReader br;

    static String nextToken() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        run();
        pw.close();
    }


    private static void run() {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            long x = nextInt();
            long y = nextInt();
            boolean tr1 = false;
            if (x < 0) {
                tr1 = true;
                x *= -1;
            }
            boolean tr2 = false;
            if (y < 0) {
                tr2 = true;
                y *= -1;
            }
            pw.print("Case #" + (i + 1) + ": ");
            int[] ax = new int[60];
            int[] ay = new int[60];
            refor(ax, x);
            refor(ay, y);
            int[] bx = new int[60];
            int[] by = new int[60];
            if (ax[0] == ay[0]) {
                pw.println("IMPOSSIBLE");
                continue;
            }
            int pow = 0;
            long step2 = 2;
            for (int j = 1; step2 <= x && step2 <= y; j++) {
                if (ax[j] == ay[j]) {
                    if (ax[j] == 0) {
                        bx[j] = 1;
                        x += step2;
                        refor(ax, x);
                        pow++;
                    } else {
                        if (ax[j - 1] == 1) {
                            bx[j - 1] = 1;
                            x += step2 / 2;
                            refor(ax, x);
                            pow++;
                        } else if (ay[j - 1] == 1) {
                            by[j - 1] = 1;
                            y += step2 / 2;
                            refor(ay, y);
                            pow++;
                        } else {
                            bx[j] = 1;
                            x += step2;
                            refor(ax, x);
                            pow++;
                        }
                    }
                }
                step2 *= 2;
            }
            int k = 0;
            while (true) {
                if (ax[k] == 1) {
                    if (!tr1) {
                        pw.print("E");
                    } else {
                        pw.print("W");
                    }
                } else if (ay[k] == 1) {
                    if (!tr2) {
                        pw.print("N");
                    } else {
                        pw.print("S");
                    }
                } else if (bx[k] == 1) {
                    if (tr1) {
                        pw.print("E");
                    } else {
                        pw.print("W");
                    }
                } else if (by[k] == 1) {
                    if (tr2) {
                        pw.print("N");
                    } else {
                        pw.print("S");
                    }
                } else {
                    break;
                }
                k++;
            }
            pw.println();

        }
    }

    private static long pow(int i, int j) {
        long ans = 1;
        for (int k = 0; k < j; k++) {
            ans *= i;
        }
        return ans;
    }

    private static void refor(int[] ax, long x) {
        int i = 0;
        while (x > 0) {
            ax[i] = (int) (x & 1);
            x = x >> 1;
            i++;
        }
    }
}
