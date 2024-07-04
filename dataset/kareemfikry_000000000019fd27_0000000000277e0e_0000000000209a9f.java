import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int kase = 1; kase <= t; ++kase) {
            final String s = in.next();
            int openCount = 0;
            int previous = 0;

            StringBuilder output = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                int n = s.charAt(i) - '0';
                if (n == 0) {
                    while (openCount > 0) {
                        output.append(")");
                        openCount--;
                    }
                } else {
                    int diff = n - previous;
                    char toPrint;
                    if (diff < 0) {
                        // this means we need to close some brackets
                        diff *= -1;
                        toPrint = ')';
                        openCount -= diff;
                    } else {
                        // this means we need to open some brackets
                        toPrint = '(';
                        openCount += diff;
                    }
                    for (int j = 0; j < diff; j++) {
                        output.append(toPrint);
                    }
                }
                output.append(n);
                previous = n;
            }
            while (openCount > 0) {
                output.append(")");
                openCount--;
            }

            System.out.println("Case #" + kase + ": " + output.toString());
        }
    }
}