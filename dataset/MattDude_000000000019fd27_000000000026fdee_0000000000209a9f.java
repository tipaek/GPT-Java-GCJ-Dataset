import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            System.out.println(String.format("Case #%d: %s", i, getParenthesisString(s)));
        }
    }

    private static String getParenthesisString(String s) {
        int previous = 0;
        StringBuilder builder = new StringBuilder();
        for (Character c : s.toCharArray()){
            int n = c - '0';
            if (n == previous) {
                builder.append(n);
                previous = n;
                continue;
            }
            if (n > previous) {
                for (int p = n - previous; p > 0; p--) {
                    builder.append("(");
                }
            }
            if (n < previous) {
                for (int i = previous - n; i > 0; i--) {
                    builder.append(")");
                }
            }
            builder.append(n);
            previous = n;
        }
        for (int i = previous; i > 0; i--){
            builder.append(")");
        }
        return builder.toString();
    }


}
       