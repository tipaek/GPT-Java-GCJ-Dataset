import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            StringBuilder transformed = new StringBuilder();

            int currentDepth = 0;
            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                while (currentDepth < digit) {
                    transformed.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    transformed.append(')');
                    currentDepth--;
                }
                transformed.append(ch);
            }
            while (currentDepth > 0) {
                transformed.append(')');
                currentDepth--;
            }

            result.append("Case #").append(i + 1).append(": ").append(transformed).append("\n");
        }
        System.out.print(result.toString());
    }
}