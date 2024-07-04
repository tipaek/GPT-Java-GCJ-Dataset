import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String line = in.nextLine();
            int previous = 0;
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < line.length(); j++) {
                int num = line.charAt(j) - '0';

                if (num > previous) {
                    result.append(repeat("(", num-previous));
                } else if (num < previous) {
                    result.append(repeat(")", previous-num));
                }

                result.append(num);
                previous = num;
            }

            result.append(repeat(")", previous));
            System.out.printf("Case #%d: %s\n", i, result.toString());
        }
    }

    private static String repeat(String s, int n) {
        return new String(new char[n]).replace("\0", s);
    }
}
