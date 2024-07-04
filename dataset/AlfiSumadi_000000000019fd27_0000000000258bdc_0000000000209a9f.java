import java.util.*;
/**
 * Solution
 */

public class Solution {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long t = sc.nextLong();
        for (int x = 1; x <= t; x++) {
            solve(x);
        }
    }


    private static void solve(long x) {
        String s = sc.next();

        String sol = s;
        for(int n = '0'; n <= '9'; n++) {
            int offset = 0;
            boolean inGroup = false;
            for(int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                if (cur =='(' || cur ==')') {
                    continue;
                }
                else if (cur > n) {
                    if (inGroup) continue;
                    else {
                        sol = sol.substring(0, i + offset) + '(' + sol.substring(i + offset);
                        offset++;
                        inGroup = true;
                    }
                } else {
                    if (!inGroup) continue;
                    else {
                        sol = sol.substring(0, i + offset) + ')' + sol.substring(i + offset);
                        offset++;
                        inGroup = false;
                    }
                }
            }
            if (inGroup) sol += ')';
            s = sol;
        }


        System.out.println("Case #" + x + ": " + sol);
    }
}