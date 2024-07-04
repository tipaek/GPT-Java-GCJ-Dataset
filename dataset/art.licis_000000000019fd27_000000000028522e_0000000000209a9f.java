import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            String s = sc.next();

            int open = 0;
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                int cnt = s.charAt(i) - '0';
                if (cnt > open) {
                    add(res, cnt - open, '(');
                    open += (cnt - open);
                } else if (cnt < open) {
                    add(res, open - cnt, ')');
                    open -= (open - cnt);
                }
                res.append(s.charAt(i));
            }
            add(res, open, ')');
            System.out.printf("Case #%d: %s%n", tc, res.toString());
        }
        System.out.flush();
    }

    private static void add(StringBuilder res, int times, char c) {
        for (int i = 0; i < times; i++) {
            res.append(c);
        }
    }
}
