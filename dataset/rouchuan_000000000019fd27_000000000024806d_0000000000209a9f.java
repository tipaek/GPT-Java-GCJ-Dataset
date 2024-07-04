import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + helper(in.next()));
        }
    }

    private static String helper(String s) {
        char[] chars = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        int open = 0;
        for (char c : chars) {
            int cnt = c - '0';
            if (cnt > open) {
                for (int i = 0; i < cnt - open; i++) {
                    ans.append("(");
                }
            } else if (cnt < open) {
                for (int i = 0; i < open - cnt; i++) {
                    ans.append(")");
                }
            }
            open = cnt;
            ans.append(c);
        }

        for (int i = 0; i < open; i++) {
            ans.append(")");
        }
        return ans.toString();
    }
}