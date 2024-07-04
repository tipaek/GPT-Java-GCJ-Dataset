import java.util.Scanner;

public class Solution {

    private void add(StringBuilder sb, int times, char c) {

        for (int i = 0; i < times; i++) {
            sb.append(c);
        }
    }

    public String solve(String digits) {
        StringBuilder sb = new StringBuilder();
        int countClose = 0;
        int last = 0;

        for (int i = 0; i < digits.length(); i++) {

            char current = digits.charAt(i);
            int d = current - '0';

            int toOpenOrClose = d - last;   // if + open, if - close
            if (toOpenOrClose > 0)
                add(sb, toOpenOrClose, '(');
            else
                add(sb, Math.abs(toOpenOrClose), ')');

            add(sb, 1, current);
            last = d;
        }

        add(sb, last, ')');

        return sb.toString();
    }



    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        Solution sol = new Solution();

        int T = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= T; t++) {

            String digits = scanner.nextLine();
            String res = sol.solve(digits);

            System.out.println("Case #" + t + ": " + res);
        }

    }
}
