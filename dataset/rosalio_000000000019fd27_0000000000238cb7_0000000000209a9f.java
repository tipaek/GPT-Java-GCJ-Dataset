import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String s = in.next();

            String ss = getOutput(s);

            System.out.println(String.format("Case #%d: %s", i, ss));
        }
    }

    private static String getOutput(String s) {
        StringBuilder sb = new StringBuilder();
        char[] ss = s.toCharArray();

        char left = ss[0];
        for (int i = 0; i < left - '0'; i++) {
            sb.append('(');
        }
        sb.append(left);

        for (int i = 1; i < ss.length; i++) {
            char right = ss[i];

            char symbol = left - right >= 0 ? ')' : '(';
            int diff = Math.abs(left - right);
            while (diff > 0) {
                sb.append(symbol);
                diff--;
            }
            sb.append(right);

            left = right;
        }

        for (int i = 0; i < left - '0'; i++) {
            sb.append(')');
        }

        return sb.toString();
    }
}
