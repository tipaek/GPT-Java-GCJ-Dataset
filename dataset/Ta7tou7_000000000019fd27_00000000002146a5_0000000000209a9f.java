import java.io.BufferedInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int t = sc.nextInt();
        for (int x = 1; x <= t; x++) {
            String s = sc.next();
            String res = solve(s);
            System.out.println("Case #" + x + ": " + res);
        }
    }

    private static String solve(String s) {
        int depth = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int d = Character.digit(s.charAt(i),10);
            if(d-depth > 0) {
                res += repeat("(", d-depth) + d;
                depth += d-depth;
            }
            else if(d-depth < 0) {
                res += repeat(")", depth-d) + d;
                depth += d-depth;
            }
            else {
                res += d;
            }
        }
        res += repeat(")", depth);
        return res;
    }

    private static String repeat(String motif, int times) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            builder.append(motif);
        }
        return builder.toString();
    }
}
