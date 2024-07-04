import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= T; ++i) {
            String s = in.nextLine();
            solveBrackets(s, i);
        }
    }

    private static void solveBrackets(String s, int T) {
        int open = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int cur = Integer.parseInt(String.valueOf(s.charAt(i)));
            if (cur > open) {
                for (int j = 0; j < cur - open; ++j)
                    ans.append("(");
                open += (cur - open);
            } else if (cur < open) {
                for (int j = 0; j < open - cur; ++j)
                    ans.append(")");
                open -= (open - cur);
            }
            ans.append(cur);
        }
        for (int i = 0; i < open; i++) {
            ans.append(")");
        }
        System.out.println("Case #" + T + ": " + ans);
    }
}