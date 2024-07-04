import java.util.Scanner;

class ParenthesesFormatter {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; t++) {
                char[] inputChars = scanner.next().toCharArray();
                StringBuilder formattedString = new StringBuilder();
                int currentDepth = 0;

                for (char ch : inputChars) {
                    int targetDepth = ch - '0';
                    while (currentDepth < targetDepth) {
                        formattedString.append('(');
                        currentDepth++;
                    }
                    while (currentDepth > targetDepth) {
                        formattedString.append(')');
                        currentDepth--;
                    }
                    formattedString.append(ch);
                }

                while (currentDepth > 0) {
                    formattedString.append(')');
                    currentDepth--;
                }

                System.out.printf("Case #%d: %s\n", t, formattedString);
            }
        }
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        ParenthesesFormatter.main(args);
    }
}