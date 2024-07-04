import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        int T = Integer.parseInt(s);
        for (int i = 0; i < T; i++) {
            s = r.readLine();
            StringBuilder sb = new StringBuilder();
            int lastDigit = 0;
            for (int j = 0; j < s.length(); j++) {
                int digit = s.charAt(j) - '0';
                int diff = digit - lastDigit;
                if (diff > 0) {
                    for (int k = 0; k < diff; k++) {
                        sb.append("(");
                    }
                } else if (diff < 0) {
                    for (int k = 0; k < -diff; k++) {
                        sb.append(")");
                    }
                }
                lastDigit = digit;
                sb.append(digit);
            }
            for (int j = 0; j < lastDigit; j++) {
                sb.append(")");
            }
            System.out.println("Case #" + (i+1) + ": " + sb.toString());
        }
    }
}