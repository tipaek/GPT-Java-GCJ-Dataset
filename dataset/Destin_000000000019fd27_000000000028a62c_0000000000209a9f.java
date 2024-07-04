import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = Integer.valueOf(s.nextLine());
        for (int t = 1; t <= T; t++) {
            StringBuilder res = new StringBuilder("");
            String line = s.nextLine();
            char[] ca = line.toCharArray();
            int n = ca.length;
            int left = 0;
            int right = 0;
            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    left = ca[i - 1] - '0';
                } 
                right = ca[i] - '0';
                if (left < right) {
                    for (int p = right - left; p > 0; p--) {
                        res.append("(");
                    }
                } else if (left > right) {
                    for (int p = left - right; p > 0; p--) {
                        res.append(")");
                    }
                }
                res.append(Character.toString(ca[i]));
            }
            for (int p = right; p > 0; p--) {
                res.append(")");
            }
            String result = "Case #" + t + ": " 
                            + res.toString();
            System.out.println(result);
        }
    }
}