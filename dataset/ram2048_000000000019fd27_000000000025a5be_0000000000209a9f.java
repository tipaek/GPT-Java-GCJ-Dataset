import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            String line = in.nextLine();
            String nestedLine = nest(line);
            System.out.println("Case #" + i + ": " + nestedLine);
        }
    }

    public static String nest(String s) {
        char[] chars = s.toCharArray();
        int[] digits = new int[chars.length];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = chars[i]-'0';
        }
        StringBuilder sb = new StringBuilder();
        int p = 0;
        for (int digit: digits) {
            while (p > digit) {
                sb.append(')');
                p--;
            }
            while (p < digit) {
                sb.append('(');
                p++;
            }
            sb.append(digit);
        }
        while (p-- > 0) {
            sb.append(')');
        }
        return sb.toString();
    }
}
