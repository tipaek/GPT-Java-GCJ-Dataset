import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            char[] characters = input.toCharArray();
            List<Character> result = new ArrayList<>();

            int currentDepth = 0;
            for (char ch : characters) {
                int digit = Character.getNumericValue(ch);
                while (currentDepth < digit) {
                    result.add('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.add(')');
                    currentDepth--;
                }
                result.add(ch);
            }
            while (currentDepth > 0) {
                result.add(')');
                currentDepth--;
            }

            System.out.print("Case #" + i + ": ");
            for (char ch : result) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}