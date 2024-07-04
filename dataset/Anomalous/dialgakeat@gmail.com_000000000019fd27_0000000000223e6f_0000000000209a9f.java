import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            char[] characters = input.toCharArray();
            List<Character> result = new ArrayList<>();

            int openParentheses = 0;

            for (char character : characters) {
                int digit = Character.getNumericValue(character);

                while (openParentheses < digit) {
                    result.add('(');
                    openParentheses++;
                }

                while (openParentheses > digit) {
                    result.add(')');
                    openParentheses--;
                }

                result.add(character);
            }

            while (openParentheses > 0) {
                result.add(')');
                openParentheses--;
            }

            System.out.print("Case #" + i + ": ");
            for (char c : result) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}