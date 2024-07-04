import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int q=1;q<=t;q++) {
            String str = s.next();
            System.out.println("Case #" + q + ": " + nestedString(str));
        }
    }
    private static String nestedString (String str) {
        String ans = "";
        int open = 0;
        for (int i=0;i<str.length();i++) {
            int x = str.charAt(i) - '0';
            if (x > open) {
                while (open != x) {
                    ans = ans + "(";
                    open++;
                }
                ans = ans + x;
            } else if (x < open) {
                while (open != x) {
                    ans = ans + ")";
                    open--;
                }
                ans = ans + x;
            } else ans = ans + x;
        }
        while (open != 0) {
            ans = ans + ")";
            open--;
        }
        return ans;
    }
}
