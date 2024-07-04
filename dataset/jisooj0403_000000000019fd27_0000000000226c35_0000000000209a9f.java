import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            String num = in.next();
            System.out.println("Case #" + (i + 1) + ": " + solve(num));
        }
    }

    static String solve(String num) {
        char[] str = num.toCharArray();
        int openCount = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            int digit = str[i] - '0';
            while (openCount < digit) {
                sb.append('(');
                openCount++;
            }
            while (openCount > digit) {
                sb.append(')');
                openCount--;
            }
            sb.append(digit);
        }

        if (openCount > 0) {
            sb.append(')');
        }

        return sb.toString();
    }
}