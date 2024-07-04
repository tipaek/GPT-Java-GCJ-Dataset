
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.io.*;

public class Solution {

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
            for (int n = 0; n < digit; ++n) {
                word = "(" + word + ")";
            }
            res += word;

            // System.out.println("Word: " + word + " digit" + digit);
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
