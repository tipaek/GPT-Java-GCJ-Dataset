
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.io.*;

public class Solution {

    public static int lenLastPars(String s) {
        int len = s.length();
        if (len == 0)
            return 0;

        if (s.charAt(len - 1) == ')')
            return 1 + lenLastPars(s.substring(0, len - 1));
        else
            return 0;
    }

    public static String solve(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String word = "";
            char curChar = s.charAt(i);
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (curChar == c) {
                    word += c;
                    i = j;
                } else
                    break;
            }

            int digit = Integer.parseInt("" + curChar);
            int p = lenLastPars(res);
            int lenNeeded = (p >= digit ? 0 : digit - p);

            for (int n = 0; n < lenNeeded; ++n) {
                word = "(" + word + ")";
            }
            // System.out.println("word: " + word + "res before" + res);
            int usedInres =  p>=digit ? digit : p;
            int position = res.length() - usedInres;
            position = Math.max(position, 0);
            res = res.substring(0, position) + word + res.substring(position);

            // System.out.println("res after" + res);
        }
        return res;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String s = in.next();

            // System.out.println("Read: " + s);
            String result = solve(s);
            System.out.println("Case #" + i + ": " + result);
        }

    }
}
