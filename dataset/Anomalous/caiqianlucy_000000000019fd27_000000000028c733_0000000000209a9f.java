import java.util.Scanner;

public class NestingDepth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int previousDepth = 0;

            for (char digitChar : input.toCharArray()) {
                int currentDepth = Character.getNumericValue(digitChar);
                appendWithDepth(result, previousDepth, currentDepth, digitChar);
                previousDepth = currentDepth;
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static void appendWithDepth(StringBuilder result, int previousDepth, int currentDepth, char digitChar) {
        if (previousDepth >= currentDepth) {
            result.insert(result.length() - currentDepth, digitChar);
        } else {
            for (int i = 0; i < currentDepth - previousDepth; i++) {
                result.append('(');
            }
            result.append(digitChar);
            for (int i = 0; i < currentDepth - previousDepth; i++) {
                result.append(')');
            }
        }
    }
}