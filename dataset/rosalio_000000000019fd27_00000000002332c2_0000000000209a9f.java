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
        for (int i = 0; i < ss.length; i++) {
            char ch = ss[i];

            if (ch == '1') {
                if (i == 0 || ss[i - 1] == '0') {
                    sb.append("(");
                }
                sb.append('1');
                if (i == ss.length - 1) {
                    sb.append(")");
                }
            } else {
                if (i != 0 && ss[i - 1] == '1') {
                    sb.append(")");
                }
                sb.append('0');
            }
        }

        return sb.toString();
    }
}
