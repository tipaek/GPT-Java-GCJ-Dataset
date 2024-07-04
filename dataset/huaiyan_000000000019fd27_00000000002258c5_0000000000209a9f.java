import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int index = 1; index <= t; ++index) {
            String str = in.next();
            getRes(index, str);
        }
    }

    private static void getRes(int index, String str) {
        StringBuilder res = new StringBuilder();
        int preP = 0;
        for (int i = 0; i < str.length(); i++) {
            int cur = Integer.valueOf(str.charAt(i) + "");
            if (cur < preP) {
                int count = preP - cur;
                while (count-- > 0) {
                    res.append(")");
                }
                preP = cur;
            } else if (cur > preP) {
                int count = cur - preP;
                while (count-- > 0) {
                    res.append("(");
                }
                preP = cur;
            }
            res.append(cur);
        }
        while (preP-- > 0)
            res.append(")");

        System.out.println("Case #" + index + ": " + res.toString());
    }
}