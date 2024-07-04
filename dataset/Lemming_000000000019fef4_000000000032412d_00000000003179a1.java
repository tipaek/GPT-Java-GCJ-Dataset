import java.util.*;
import java.util.regex.Pattern;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int u = in.nextInt();
            StringBuilder[] responses = {new StringBuilder(), new StringBuilder(), new StringBuilder(), new StringBuilder(), new StringBuilder(), new StringBuilder(), new StringBuilder(), new StringBuilder(), new StringBuilder(), new StringBuilder()};
            for (int j = 0; j < 10000; j++) {
                int q = in.nextInt();
                String r = in.next();
                if (q > 0 && q < 11) {
                    responses[q - 1].append(r);
                }
            }
            String d = String.valueOf(responses[0].charAt(0));// char for 1
            for (int j = 1; j < 9; j++) {
                Pattern regex = Pattern.compile("[^" + d + "]");
                d = d + regex.split(responses[j].toString(), 1)[0]; // incorrect if not all digits found
            }
            Pattern regex = Pattern.compile("[^" + d + "]");
            d = regex.split(responses[9].toString(), 1)[0] + d; // char for digit 0 - incorrect if not all digits found
            System.out.println("Case #" + i + ": " + d);
        }
        in.close();
    }

}