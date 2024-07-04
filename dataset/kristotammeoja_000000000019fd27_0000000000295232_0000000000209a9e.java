import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int t = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; ++i) {
            solve(in);
        }
    }

    static int[] a;
    static int b;
    static int pairs_known;
    static int fist_XX;
    static int fist_XY;
    private static void solve(BufferedReader in) throws IOException {
        a = new int[b];
        pairs_known = 0;
        fist_XX = -1;
        fist_XY = -1;

        int b2 = b/2;

        // read 5 pairs
        {
            int pairs = 5;
            for (int i = 0; i < pairs; ++i) {
                read_next_pair(in);
            }
        }

        while (true) {
            if (pairs_known >= b2) {
                answer();
                in.readLine();
                return;
            }

            int q_xx = Math.max(0, fist_XX);
            int q_xy = Math.max(0, fist_XY);
            int a_xx = a[q_xx];
            int a_xy = a[q_xy];

            boolean xx_changed = a_xx != just_read(in, q_xx);
            boolean xy_changed = a_xy != just_read(in, q_xy);

            boolean is_comp = xx_changed;
            boolean is_rev = xx_changed != xy_changed;
            if (fist_XX < 0) {
                is_comp = xy_changed;
                is_rev = false;
            }

            //System.err.println("< " + q_xx + " " + q_xy + ">");
            //System.err.println("< " + a_xx + " " + a_xy + ">");
            //System.err.println("< " + is_comp + " " + is_rev + ">");

            if (is_comp) {
                for (int i = 0; i < b; ++i)
                    a[i] = 1-a[i];
            }

            if (is_rev) {
                for (int i = 0; i < b2; ++i) {
                    int j = b - 1 - i;
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }

            for (int i = 0; i < 4; ++i)
                read_next_pair(in);
        }
    }

    private static void read_next_pair(BufferedReader in) throws IOException {
        int idx_0 = pairs_known;
        int idx_1 = b - 1 - pairs_known;
        read(in, idx_0);
        read(in, idx_1);

        if (fist_XX < 0 && a[idx_0]==a[idx_1]) fist_XX = idx_0;
        if (fist_XY < 0 && a[idx_0]!=a[idx_1]) fist_XY = idx_0;

        ++pairs_known;
    }

    private static void answer() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; ++i) {
            sb.append("" + a[i]);
        }
        System.out.println(sb.toString());
        System.out.flush();
    }

    private static void read(BufferedReader in, int idx) throws IOException {
        a[idx] = just_read(in, idx);
    }

    private static int just_read(BufferedReader in, int idx) throws IOException {
        System.out.println("" + (idx+1));
        System.out.flush();
        int res = Integer.parseInt(in.readLine());
        //System.err.println("  " + idx + " => " + res); // TODO
        return res;
    }
}
