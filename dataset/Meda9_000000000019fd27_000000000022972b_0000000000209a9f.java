import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        String[] res = new String[t];
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();
            res[i-1] = helper(s);
        }
        for (int i = 1; i <= res.length; i++) {
            System.out.println("Case #" + i + ": " + res[i - 1]);
        }
    }

    private static String helper(String input) {
        StringBuilder sb = new StringBuilder();
        int depth = 0;

        for (int i = 0; i<input.length(); i++) {
            int c = input.charAt(i)-'0';
            if (c == depth) {
                sb.append(input.charAt(i));
            } else if (c < depth) {
                int dif = depth - c;
                while (dif>0) {
                    sb.append(')');
                    dif--;
                }
                sb.append(c);
                depth = c;
            } else {
                int dif = c - depth;
                while (dif>0) {
                    sb.append('(');
                    dif--;
                }
                sb.append(c);
                depth = c;
            }
        }

        int c = input.charAt(input.length()-1) -'0';
        while (c > 0) {
            sb.append(')');
            c--;
        }

        return sb.toString();
    }
}
