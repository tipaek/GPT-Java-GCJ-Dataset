import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            
            for (int i = 1; i <= testCases; i++) {
                System.out.printf("Case #%d: ", i);
                processCase(scanner);
            }
        }
    }

    private static void processCase(Scanner scanner) {
        char[] inputChars = scanner.next().toCharArray();
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char c : inputChars) {
            int nextDepth = c - '0';

            while (currentDepth < nextDepth) {
                result.append('(');
                currentDepth++;
            }
            while (currentDepth > nextDepth) {
                result.append(')');
                currentDepth--;
            }

            result.append(c);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        System.out.println(result.toString());
    }
}