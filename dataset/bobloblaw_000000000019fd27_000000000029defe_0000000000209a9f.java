import java.util.Scanner;

public class Solution {
    static String nest(String s, int outer) {
        if (s.length() == 1) {
            return repeat('(', Integer.parseInt(s) - outer)
                    + s
                    + repeat(')', Integer.parseInt(s) - outer);
        }
        int min = s.chars().map(Character::getNumericValue).min().orElse(-1);

        int firstDigit = Integer.parseInt("" + s.charAt(0));
        if (firstDigit <= min) {
            return repeat('(', min - outer)
                    + s.charAt(0) + nest(s.substring(1), min)
                    + repeat(')', min - outer);
        }
        return repeat('(', min - outer)
                + repeat('(', firstDigit - min) + s.charAt(0) + repeat(')', firstDigit - min)
                + nest(s.substring(1), min)
                + repeat(')', min - outer);
    }

    static String repeat(char c, int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt();
        for (int test = 1; test <= tests; test++) {
            String s = sc.next();
            System.out.printf("Case #%d: %s\n", test, nest(s, 0));
        }
    }
}
