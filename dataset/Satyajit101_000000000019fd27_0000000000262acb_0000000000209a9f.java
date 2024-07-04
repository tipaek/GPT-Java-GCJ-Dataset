import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();
            System.out.println("Case #" + i + ": " + solve(s));
        }
    }

    public static String solve(String s) {

        StringBuffer out = new StringBuffer();
        int opening = 0;

        for (int i = 0; i < s.length(); i++) {
            char num = s.charAt(i);
            int n = Character.digit(num, 10);
            if (opening > n) {
                int diff = opening - n;
                add(")", out, diff);
                add(num + "", out, 1);
                opening -= diff;
            } else if (opening < n) {
                add("(", out, n - opening);
                add(num + "", out, 1);
                opening += n - opening;
            } else {
                add(s.charAt(i) + "", out, 1);
            }
        }

        add(")", out, opening);

        return out.toString();
    }

    public static void add(String s, StringBuffer sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(s);
        }
    }
}
