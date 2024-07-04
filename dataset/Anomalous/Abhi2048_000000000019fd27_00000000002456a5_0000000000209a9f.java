import java.util.*;

public class ParenthesesBalancer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= testCases; i++) {
            char[] digits = scanner.next().toCharArray();
            LinkedList<Character> balancedString = new LinkedList<>();
            int currentDepth = 0;

            for (char digit : digits) {
                int value = digit - '0';

                while (currentDepth < value) {
                    balancedString.add('(');
                    currentDepth++;
                }
                while (currentDepth > value) {
                    balancedString.add(')');
                    currentDepth--;
                }
                balancedString.add(digit);
            }

            while (currentDepth > 0) {
                balancedString.add(')');
                currentDepth--;
            }

            result.append("Case #").append(i).append(": ");
            for (char ch : balancedString) {
                result.append(ch);
            }
            result.append("\n");
        }

        System.out.println(result.toString());
        scanner.close();
    }
}