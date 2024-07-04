import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int tt = 0; tt < t; tt++) {
            int n = in.nextInt();

            String result = "";
            int pj[][] = new int[n][2];
            int pc[][] = new int[n][2];

            for (int nn = 0; nn < n; nn ++) {
                for (int j = 0; j < 2; j++) {
                    pj[nn][0] = 0;
                    pj[nn][1] = 0;
                    pc[nn][0] = 0;
                    pc[nn][1] = 0;
                }
            }

            for (int nn = 0; nn < n; nn ++) {
                int start = in.nextInt();
                int end = in.nextInt();

                boolean checkj = true;
                boolean checkc = true;
                for (int i = 0; i < nn; i ++) {
                    if ((start >= pj[i][0] && start < pj[i][1]) || (end > pj[i][0] && end <= pj[i][1])) {
                        checkj = false;
                    }
                    if ((start >= pc[i][0] && start < pc[i][1]) || (end > pc[i][0] && end <= pc[i][1])) {
                        checkc = false;
                    }

                    if (checkj == false && checkc == false) {
                        break;
                    }
                }

                if (checkj) {
                    pj[nn][0] = start;
                    pj[nn][1] = end;
                    result += "J";
                } else if (checkc) {
                    pc[nn][0] = start;
                    pc[nn][1] = end;
                    result += "C";
                }
            }

            if ("".equals(result) || n > result.length()) {
                result = "IMPOSSIBLE";
            }

            System.out.println("Case #" + (tt + 1) + ": " + result);
        }
    }
}
