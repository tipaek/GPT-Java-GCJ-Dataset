import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 0; caseNum < cases; caseNum++) {
            int patternsCount = Integer.parseInt(scanner.nextLine());
            StringBuilder startPattern = null;
            StringBuilder endPattern = null;
            StringBuilder result = new StringBuilder("*");

            for (int patternNum = 0; patternNum < patternsCount; patternNum++) {
                String input = scanner.nextLine();

                if (result.toString().equals("*")) {
                    continue;
                }

                if (input.startsWith("*")) {
                    String subString = input.substring(1);
                    endPattern = updatePattern(endPattern, subString, true);
                } else if (input.endsWith("*")) {
                    String subString = input.substring(0, input.length() - 1);
                    startPattern = updatePattern(startPattern, subString, false);
                } else {
                    int index = input.indexOf("*");
                    String startSubString = input.substring(0, index);
                    String endSubString = input.substring(index + 1);
                    startPattern = updatePattern(startPattern, startSubString, false);
                    endPattern = updatePattern(endPattern, endSubString, true);
                }

                if (startPattern != null && endPattern != null) {
                    result = new StringBuilder(startPattern).append(endPattern);
                } else if (startPattern != null) {
                    result = startPattern;
                } else if (endPattern != null) {
                    result = endPattern;
                } else {
                    result = new StringBuilder("*");
                }
            }

            System.out.println("Case #" + (caseNum + 1) + ": " + result);
        }
    }

    private static StringBuilder updatePattern(StringBuilder pattern, String subString, boolean isEndPattern) {
        if (pattern == null) {
            return new StringBuilder(subString);
        }

        if (isEndPattern) {
            if (subString.length() > pattern.length()) {
                int diff = subString.length() - pattern.length();
                if (subString.substring(diff).equals(pattern.toString())) {
                    return new StringBuilder(subString);
                }
            } else if (pattern.toString().endsWith(subString)) {
                return pattern;
            }
        } else {
            if (subString.length() > pattern.length()) {
                int diff = subString.length() - pattern.length();
                if (subString.substring(0, subString.length() - diff).equals(pattern.toString())) {
                    return new StringBuilder(subString);
                }
            } else if (pattern.toString().startsWith(subString)) {
                return pattern;
            }
        }

        return new StringBuilder("*");
    }
}