import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();

        for (int tt = 0; tt < t; tt++) {
            String s = scanner.next();

            int cnt = 0;

            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                System.out.println(c);
                int i = Character.getNumericValue(c);

                if (i < cnt) {
                    // remove cnt - i
                    add(sb, cnt - i, ')');
                    cnt = cnt - (cnt - i);
                } else if (i > cnt) {
                    // add i - cnt
                    add(sb, i - cnt, '(');
                    cnt = cnt + (i - cnt);
                }

                sb.append(c);
            }

            add(sb, cnt, ')');

            System.out.printf("Case #%d: %s\n", tt + 1, sb.toString());
        }

    }

    private static void add(StringBuilder sb, int n, char c) {
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
    }
}
