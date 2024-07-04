import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            String s = scanner.next();
            List<Character> result = addParentheses(s);
            System.out.print("Case #" + i + ": ");
            for (char c : result) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static List<Character> addParentheses(String s) {
        List<Character> result = new ArrayList<>();
        int openParentheses = 0;

        for (char digit : s.toCharArray()) {
            int currentDigit = Character.getNumericValue(digit);

            while (openParentheses < currentDigit) {
                result.add('(');
                openParentheses++;
            }

            while (openParentheses > currentDigit) {
                result.add(')');
                openParentheses--;
            }

            result.add(digit);
        }

        while (openParentheses > 0) {
            result.add(')');
            openParentheses--;
        }

        return result;
    }
}