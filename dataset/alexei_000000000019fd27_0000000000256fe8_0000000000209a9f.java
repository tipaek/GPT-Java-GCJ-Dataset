import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int c = 1; c <= t; c++) {
            StringBuilder res = new StringBuilder();
            String s = in.nextLine();
            int curr = 0;
            while (!s.isEmpty()) {
                int d = s.charAt(0) - '0';
                s = s.substring(1);
                int times = Math.abs(d - curr);
                char bracket = '(';
                if (d < curr) {
                    bracket = ')';
                }
                curr += d - curr;
                for (int i = 0; i < times; i++) {
                    res.append(bracket);
                }
                res.append(d);
            }
            for (int i = 0; i < curr; i++) {
                res.append(')');
            }
            System.out.println(String.format("Case #%d: %s", c, res.toString()));
        }
    }
}
