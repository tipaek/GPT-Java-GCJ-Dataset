import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_CASE_MATCH = "Case #%d: %s";
    private static final String OUTPUT_CASE_NO_MATCH = "Case #%d: *";

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

    private void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        String[] patterns = new String[n];
        for (int i = 0; i < n; i++) {
            patterns[i] = scanner.next();
        }

        Arrays.sort(patterns, (s1, s2) -> {
            int lengthDifference = s1.length() - s2.length();
            return lengthDifference != 0 ? lengthDifference : s1.compareTo(s2);
        });

        for (int i = 1; i < patterns.length; i++) {
            if (!patterns[i].endsWith(patterns[i - 1].substring(1))) {
                System.out.println(String.format(OUTPUT_CASE_NO_MATCH, caseNum));
                return;
            }
        }

        System.out.println(String.format(OUTPUT_CASE_MATCH, caseNum, patterns[n - 1].substring(1)));
    }
}