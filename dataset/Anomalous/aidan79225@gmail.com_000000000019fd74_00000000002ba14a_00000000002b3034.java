import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_CASE = "Case #%d: %s";
    private static final String OUTPUT_INVALID = "Case #%d: *";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution().processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int countStars(char[] chars) {
        int count = 0;
        for (char c : chars) {
            if (c == '*') {
                count++;
            }
        }
        return count;
    }

    private void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        String[][] patterns = new String[n][];

        for (int i = 0; i < n; ++i) {
            String temp = scanner.next();
            char[] chars = temp.toCharArray();
            int starCount = countStars(chars);
            patterns[i] = new String[starCount + 1];

            int lastIndex = 0, segmentIndex = 0;
            for (int j = 0; j < chars.length; ++j) {
                if (chars[j] == '*') {
                    patterns[i][segmentIndex++] = temp.substring(lastIndex, j);
                    lastIndex = j + 1;
                }
            }
            patterns[i][segmentIndex] = temp.substring(lastIndex);
        }

        if (!isValidPrefix(patterns) || !isValidSuffix(patterns)) {
            System.out.println(String.format(OUTPUT_INVALID, caseNum));
            return;
        }

        StringBuilder result = new StringBuilder();
        result.append(getLongestPrefix(patterns));

        for (String[] pattern : patterns) {
            for (int j = 1; j < pattern.length - 1; ++j) {
                result.append(pattern[j]);
            }
        }

        result.append(getLongestSuffix(patterns));
        System.out.println(String.format(OUTPUT_CASE, caseNum, result));
    }

    private boolean isValidPrefix(String[][] patterns) {
        Arrays.sort(patterns, (a, b) -> Integer.compare(a[0].length(), b[0].length()));
        for (int i = 1; i < patterns.length; ++i) {
            if (!patterns[i][0].startsWith(patterns[i - 1][0])) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidSuffix(String[][] patterns) {
        Arrays.sort(patterns, (a, b) -> Integer.compare(a[a.length - 1].length(), b[b.length - 1].length()));
        for (int i = 1; i < patterns.length; ++i) {
            if (!patterns[i][patterns[i].length - 1].endsWith(patterns[i - 1][patterns[i - 1].length - 1])) {
                return false;
            }
        }
        return true;
    }

    private String getLongestPrefix(String[][] patterns) {
        int maxIndex = 0;
        for (int i = 1; i < patterns.length; ++i) {
            if (patterns[i][0].length() > patterns[maxIndex][0].length()) {
                maxIndex = i;
            }
        }
        return patterns[maxIndex][0];
    }

    private String getLongestSuffix(String[][] patterns) {
        int maxIndex = 0;
        for (int i = 1; i < patterns.length; ++i) {
            if (patterns[i][patterns[i].length - 1].length() > patterns[maxIndex][patterns[maxIndex].length - 1].length()) {
                maxIndex = i;
            }
        }
        return patterns[maxIndex][patterns[maxIndex].length - 1];
    }
}