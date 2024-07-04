//package  com.jsomers;

// Google Code Jam 2019
// Split big int into 2 positive addends, neither can have the digit 4

import java.util.*;
import java.io.*;
// import java.math.BigInteger;

public class Solution {

    void run() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();
            StringBuilder sb = new StringBuilder();
            Character c = s.charAt(0);
            int digit = c - '0';
            for (int j = 0; j < digit; ++j) {
                sb.append("(");
            }
            sb.append(c);

            for (int pos = 1; pos < s.length(); ++pos) {
                c = s.charAt(pos);
                int nextDigit = c - '0';
                if (digit > nextDigit) {
                    int diff = digit - nextDigit;
                    for (int j = 0; j < diff; ++j) {
                        sb.append(")");
                    }
                } else if (digit < nextDigit) {
                    int diff = nextDigit - digit;
                    for (int j = 0; j < diff; ++j) {
                        sb.append("(");
                    }
                }
                sb.append(c);
                digit = nextDigit;
            }
            for (int j = 0; j < digit; ++j) {
                sb.append(")");
            }


            System.out.println("Case #" + i + ": " + sb);
        }

    }

    public static void main(String[] args)  {

        Solution foregone = new Solution();
        foregone.run();

    }
}
