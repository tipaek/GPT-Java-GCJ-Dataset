import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            StringBuilder sb = new StringBuilder();
            String[] s = in.next().split("");
            int ucp = Integer.parseInt(s[0]);
            int curVal = ucp;
            for (int j = 0; j < ucp; j++) {
                sb.append("(");
            }
            sb.append(s[0]);
            for (int j = 1; j < s.length; j++) {
                int nextVal = Integer.parseInt(s[j]);
                if (nextVal == curVal) {
                    sb.append(nextVal);
                } else if (curVal < nextVal) {
                    for (int k = 0; k < nextVal - curVal; k++) {
                        sb.append("(");
                        ucp++;
                    }
                    sb.append(nextVal);
                } else {
                    for (int k = 0; k < curVal - nextVal; k++) {
                        sb.append(")");
                        ucp--;
                    }
                    sb.append(nextVal);
                }
                curVal = nextVal;
            }
            for (int j = 0; j < ucp; j++) {
                sb.append(")");
            }
            System.out.println("Case #" + i + ": "+sb);
        }
    }
}