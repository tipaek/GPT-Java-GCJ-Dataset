import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static String solve2(Scanner s) {
        String d = s.next();
        //       System.out.println(d);
        StringBuffer ans = new StringBuffer();
        int init = d.charAt(0) - '0';
        int prev = init;
        while (init-- > 0) {
            ans.append('(');
        }
        ans.append(d.charAt(0));
        for (int i = 1; i < d.length(); i++) {
            int cur = d.charAt(i) - '0';
            if (prev > cur) {
                int less = prev - cur;
                while (less-- > 0) ans.append(')');
                prev -= (prev - cur);
            } else {
                int extra = cur - prev;
                while (extra-- > 0) ans.append('(');
                prev += (cur - prev);
            }
            ans.append(d.charAt(i));
        }
        while (prev-- > 0) {
            ans.append(')');
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 1; t <= T; t++) {
            System.out.println("Case #" + t + ": " + solve2(s));
        }
    }
}
