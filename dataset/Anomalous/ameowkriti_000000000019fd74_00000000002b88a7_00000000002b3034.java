import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int wordCount = scanner.nextInt();
            String[] words = new String[wordCount];

            for (int i = 0; i < wordCount; i++) {
                words[i] = scanner.next();
            }

            String result = findPattern(words);

            System.out.print("Case #" + caseNumber + ": ");
            System.out.print(result);
            System.out.println();
            caseNumber++;
        }

        scanner.close();
    }

    private static String findPattern(String[] words) {
        int maxLengthIndex = 0;

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > words[maxLengthIndex].length()) {
                maxLengthIndex = i;
            }
        }

        StringBuilder patternBuilder = new StringBuilder();
        for (char ch : words[maxLengthIndex].toCharArray()) {
            if (ch != '*') {
                patternBuilder.append(ch);
            }
        }

        String pattern = patternBuilder.toString();

        for (String word : words) {
            if (!matchesPattern(pattern, word)) {
                return "*";
            }
        }

        return pattern;
    }

    private static boolean matchesPattern(String src, String pattern) {
        if (src.isEmpty() && pattern.isEmpty()) {
            return true;
        }

        if (!src.isEmpty() && pattern.isEmpty()) {
            return false;
        }

        if (src.isEmpty()) {
            for (char ch : pattern.toCharArray()) {
                if (ch != '*') {
                    return false;
                }
            }
            return true;
        }

        char srcChar = src.charAt(0);
        char patternChar = pattern.charAt(0);

        String remainingSrc = src.substring(1);
        String remainingPattern = pattern.substring(1);

        if (patternChar == '*') {
            return matchesPattern(src, remainingPattern) || matchesPattern(remainingSrc, pattern);
        } else if (patternChar == srcChar) {
            return matchesPattern(remainingSrc, remainingPattern);
        } else {
            return false;
        }
    }
}