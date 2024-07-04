import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 1; i <= t; ++i) {
            String input = s.next();
            System.out.println(
                String.format(
                    "Case #%d: %s", 
                    i, new Solution().solve(input)
                )
            );
        }
    }
    
    public String solve(String s) {
        return solve(s, 0);
    }
    
    private String solve(String s, int d) {
        String[] subs = s.split("" + (char) ('0' + d), -1);
        String res = "";
        for (int i = 0; i < subs.length; ++i) {
            if (subs[i].length() > 0) {
                res += '(' + solve(subs[i], d+1) + ')';
            }
            if (i < subs.length - 1) {
               res += (char) ('0' + d);
            }
        }
        return res;
    }
}