import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_CASE = "Case #%d: %s";
    private static final String OUTPUT_STAR = "Case #%d: *";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                new Solution().processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        String[][] patterns = new String[n][2];

        for (int i = 0; i < n; i++) {
            String temp = scanner.next();
            int starIndex = temp.indexOf('*');
            patterns[i][0] = temp.substring(0, starIndex);
            patterns[i][1] = temp.substring(starIndex + 1);
        }

        if (!isValidPrefix(patterns) || !isValidSuffix(patterns)) {
            System.out.println(String.format(OUTPUT_STAR, caseNum));
            return;
        }

        String longestPrefix = getLongestPattern(patterns, 0);
        String longestSuffix = getLongestPattern(patterns, 1);

        System.out.println(String.format(OUTPUT_CASE, caseNum, longestPrefix + longestSuffix));
    }

    private boolean isValidPrefix(String[][] patterns) {
        Arrays.sort(patterns, (a, b) -> Integer.compare(a[0].length(), b[0].length()));

        for (int i = 1; i < patterns.length; i++) {
            if (!patterns[i][0].startsWith(patterns[i - 1][0])) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidSuffix(String[][] patterns) {
        Arrays.sort(patterns, (a, b) -> Integer.compare(a[1].length(), b[1].length()));

        for (int i = 1; i < patterns.length; i++) {
            if (!patterns[i][1].endsWith(patterns[i - 1][1])) {
                return false;
            }
        }
        return true;
    }

    private String getLongestPattern(String[][] patterns, int index) {
        return Arrays.stream(patterns)
                     .max((a, b) -> Integer.compare(a[index].length(), b[index].length()))
                     .orElse(new String[2])[index];
    }
}