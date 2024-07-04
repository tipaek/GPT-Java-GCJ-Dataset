
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt(); //activities
            in.nextLine();
            int acts[][] = new int[n][2];
            for (int j = 0; j < n; j++) {
                String mom[] = new String[2];
                mom = in.nextLine().split(" ");
                for (int k = 0; k < 2; k++) {
                    acts[j][k] = Integer.parseInt(mom[k]);
                }

            }
            int tm = 0;
            String seq = "";
            int c = -1, j = -1, cs = 0, js = 0;

            for (int k = 0; k < acts.length && (c != -2) && (j != -2); k++) {

                if (c == -1 || !((acts[k][0] >= cs && acts[k][0] < c) || (acts[k][1] >= cs && acts[k][1] <= c))) {
                    cs = acts[k][0];
                    c = acts[k][1];
                    seq += "C";
                } else if (j == -1 || !((acts[k][0] >= js && acts[k][0] < j) || (acts[k][1] >= js && acts[k][1] <= j))) {
                    js = acts[k][0];
                    j = acts[k][1];
                    seq += "J";
                } else {
                    c = -2;
                    j = -2;
                    seq = "IMPOSSIBLE";
                }

            }

            System.out.println("Case #" + i + ": " + seq);
        }
    }
}
