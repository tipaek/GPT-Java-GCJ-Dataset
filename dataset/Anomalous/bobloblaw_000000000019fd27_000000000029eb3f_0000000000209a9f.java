import java.util.Scanner;

public class Solution {

    private static String nest(String s, int outer) {
        if (s.isEmpty()) return "";
        if (s.length() == 1) {
            int digit = Character.getNumericValue(s.charAt(0));
            return createBrackets(digit - outer) + s + createBrackets(digit - outer, ')');
        }

        int min = s.chars().map(Character::getNumericValue).min().orElse(-1);
        int firstDigit = Character.getNumericValue(s.charAt(0));
        int qty = countConsecutiveDigits(s, firstDigit);

        if (firstDigit < min) {
            return createBrackets(min - outer) + s.charAt(0) + nest(s.substring(1), min) + createBrackets(min - outer, ')');
        }

        return createBrackets(min - outer) + createBrackets(firstDigit - min) + s.substring(0, qty) + createBrackets(firstDigit - min, ')') + nest(s.substring(qty), min) + createBrackets(min - outer, ')');
    }

    private static String createBrackets(int count) {
        return createBrackets(count, '(');
    }

    private static String createBrackets(int count, char bracket) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(bracket);
        }
        return sb.toString();
    }

    private static int countConsecutiveDigits(String s, int digit) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (Character.getNumericValue(ch) == digit) {
                count++;
            } else {
                break;
            }
        }
        return count;
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