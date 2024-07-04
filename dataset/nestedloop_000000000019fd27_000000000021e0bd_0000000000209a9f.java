import java.util.*;
import java.io.*;

public class Solution {

    public static String process(String s, String mask) {
        if ((s == null) || (s.length() == 0)) {
            return "";
        } else {
            int i = s.indexOf('0');
            if (i < 0) {
                char[] sb = s.toCharArray();
                for (int j = 0; j < s.length(); j++) {
                    sb[j]--;
                }
                String sNew = new String(sb);
                return ("(" + process(sNew, mask) + ")");
            } else {
                String a = s.substring(0, i);
                String b = s.substring(i + 1);
                return (process(a, mask.substring(0, i)) + mask.substring(i, i + 1) + process(b, mask.substring(i + 1)));
            }
        }
    }

    

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int t = 1; t <= test; ++t) {
            String s = in.nextLine();
            String result = process(s, s);
            System.out.println("Case #" + t + ": " + result);
        }
    }
}
