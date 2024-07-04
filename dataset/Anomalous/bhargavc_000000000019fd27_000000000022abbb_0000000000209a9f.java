import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine().trim();
            NestingDepth nestingDepth = new NestingDepth(i, input);
            System.out.println(nestingDepth.getPatternWithBraces());
        }
        scanner.close();
    }
}

class NestingDepth {
    private final String pattern;
    private final int testId;

    public NestingDepth(int testId, String pattern) {
        this.pattern = pattern;
        this.testId = testId;
    }

    public String getPatternWithBraces() {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char ch : pattern.toCharArray()) {
            int digit = ch - '0';
            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }
            result.append(digit);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        return formatOutput(result.toString());
    }

    private String formatOutput(String patternWithBraces) {
        return "Case #" + (testId + 1) + ": " + patternWithBraces;
    }
}