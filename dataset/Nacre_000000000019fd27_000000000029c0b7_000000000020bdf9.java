import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int task = in.nextInt();
            StringBuilder sb = new StringBuilder();
            boolean[] one = new boolean[24 * 60 + 1];
            boolean[] two = new boolean[24 * 60 + 1];
            int assign = 0;
            for (int j = 0; j < task; j++) {
                int sTemp = in.nextInt();
                int eTemp = in.nextInt();

                if (!one[sTemp] && !one[eTemp]) {
                    assign = 1;
                } else if (!two[sTemp] && !two[eTemp]) {
                    assign = 2;
                } else {
                    sb = new StringBuilder("IMPOSSIBLE");
                    break;
                }
                if (assign == 1) {
                    Arrays.fill(one, sTemp, eTemp, true);
                    sb.append('J');
                } else {
                    Arrays.fill(two, sTemp, eTemp, true);
                    sb.append('C');
                }
            }
            System.out.println("Case #" + i + ": " + sb.toString());


        }
    }


}