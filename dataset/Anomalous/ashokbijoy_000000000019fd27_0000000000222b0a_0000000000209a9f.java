import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                String input = scanner.next();
                System.out.println("Case #" + caseNumber + ": " + processString(input));
            }
        }
    }

    public static String processString(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        int zeroCount = 0, oneCount = 0;
        char previousChar = input.charAt(0);

        if (previousChar == '0') {
            zeroCount++;
        } else if (previousChar == '1') {
            oneCount++;
        }

        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == previousChar) {
                if (currentChar == '0') {
                    zeroCount++;
                } else if (currentChar == '1') {
                    oneCount++;
                }
            } else {
                appendCharacters(result, previousChar, zeroCount, oneCount);
                if (currentChar == '0') {
                    zeroCount = 1;
                } else if (currentChar == '1') {
                    oneCount = 1;
                }
            }
            previousChar = currentChar;
        }

        appendCharacters(result, previousChar, zeroCount, oneCount);

        return result.toString();
    }

    private static void appendCharacters(StringBuilder result, char previousChar, int zeroCount, int oneCount) {
        if (previousChar == '0') {
            while (zeroCount-- > 0) {
                result.append('0');
            }
        } else if (previousChar == '1') {
            result.append('(');
            while (oneCount-- > 0) {
                result.append('1');
            }
            result.append(')');
        }
    }
}