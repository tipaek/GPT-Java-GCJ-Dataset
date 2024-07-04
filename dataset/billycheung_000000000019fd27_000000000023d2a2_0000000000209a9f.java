import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            System.out.println("Case #" + i + ": " + getData(s));
        }
    }
    // 212 -> ((2)1(2))
    // 121 -> (1(2)1)
    // 1321 -> (1((3)2)1)
    // 1411 -> (1(((4)))11)

    private static String getData(String s) {
        if (s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char prev = '0';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = c - prev;
            for (int j = 0; j < -count; j++) {
                sb.append(")");
            }
            for (int j = 0; j < count; j++) {
                sb.append("(");
            }
            sb.append(c);
            prev = c;
        }
        int close = s.charAt(s.length() - 1) - '0';
        for (int i = 0; i < close; i++) {
            sb.append(")");
        }
        return sb.toString();
    }

}
