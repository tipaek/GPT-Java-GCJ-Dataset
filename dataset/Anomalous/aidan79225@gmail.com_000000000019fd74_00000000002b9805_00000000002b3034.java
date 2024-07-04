import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_CASE = "Case #%d: %s";
    private static final String OUTPUT_ASTERISK = "Case #%d: *";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; caseNum++) {
                new Solution().processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int countAsterisks(char[] chars) {
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

        for (int i = 0; i < n; i++) {
            String temp = scanner.next();
            char[] chars = temp.toCharArray();
            int asteriskCount = countAsterisks(chars);
            patterns[i] = new String[asteriskCount + 1];

            int last = 0, k = 0;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '*') {
                    patterns[i][k++] = temp.substring(last, j);
                    last = j + 1;
                }
            }
            patterns[i][k] = (last == chars.length) ? "" : temp.substring(last);
        }

        if (!isValidPattern(patterns, caseNum)) {
            return;
        }

        int maxPrefixIndex = findMaxPrefixIndex(patterns);
        int maxSuffixIndex = findMaxSuffixIndex(patterns);

        System.out.println(String.format(OUTPUT_CASE, caseNum, patterns[maxPrefixIndex][0] + patterns[maxSuffixIndex][1]));
    }

    private boolean isValidPattern(String[][] patterns, int caseNum) {
        Arrays.sort(patterns, (s1, s2) -> Integer.compare(s1[0].length(), s2[0].length()));
        for (int i = 1; i < patterns.length; i++) {
            if (!patterns[i][0].startsWith(patterns[i - 1][0])) {
                System.out.println(String.format(OUTPUT_ASTERISK, caseNum));
                return false;
            }
        }

        Arrays.sort(patterns, (s1, s2) -> Integer.compare(s1[s1.length - 1].length(), s2[s2.length - 1].length()));
        for (int i = 1; i < patterns.length; i++) {
            if (!patterns[i][patterns[i].length - 1].endsWith(patterns[i - 1][patterns[i - 1].length - 1])) {
                System.out.println(String.format(OUTPUT_ASTERISK, caseNum));
                return false;
            }
        }

        return true;
    }

    private int findMaxPrefixIndex(String[][] patterns) {
        int maxIndex = 0;
        for (int i = 1; i < patterns.length; i++) {
            if (patterns[i][0].length() > patterns[maxIndex][0].length()) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private int findMaxSuffixIndex(String[][] patterns) {
        int maxIndex = 0;
        for (int i = 1; i < patterns.length; i++) {
            if (patterns[i][patterns[i].length - 1].length() > patterns[maxIndex][patterns[maxIndex].length - 1].length()) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}