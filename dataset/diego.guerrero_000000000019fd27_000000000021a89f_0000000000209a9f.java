import java.util.*;
import java.io.*;

public class Solution {
    private static final String CASE_TEMPLATE = "Case #%s: %s";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.next().trim();
            StringBuilder stringBuilder = new StringBuilder();
            for (int idx = 0; idx < s.length(); idx++) {
                int depth = Character.getNumericValue(s.charAt(idx));
                for (int j = 0; j < depth; j++)
                    stringBuilder.append("(");
                stringBuilder.append(depth);
                for (int j = 0; j < depth; j++)
                    stringBuilder.append(")");
            }
            s = stringBuilder.toString();
            while (s.contains(")(")) {
                s = s.replaceAll("[)][(]", "");
            }
            System.out.println(String.format(CASE_TEMPLATE, i, s));
        }
    }
}