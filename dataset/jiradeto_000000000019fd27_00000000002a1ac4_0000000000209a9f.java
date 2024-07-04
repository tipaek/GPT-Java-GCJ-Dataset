
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
         Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        for (int i = 1; i <= n; i++) {
            String str = reader.next();
            solve(str, i);
        }

    }

    private static void solve(String str, int idx) {
        char[] c = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        for (int i = 0; i < c.length; i++) {
            int digit = c[i] - '0';
            if (cur > digit) {
                while (cur != digit) {
                    sb.append(")");
                    cur--;
                }
            } else {
                while (cur != digit) {
                    sb.append("(");
                    cur++;
                }
            }
            sb.append(digit);
        }
        while (cur-- > 0) {
            sb.append(")");
        }

        System.out.println("Case #" + idx + ": " + sb.toString());
    }

}

