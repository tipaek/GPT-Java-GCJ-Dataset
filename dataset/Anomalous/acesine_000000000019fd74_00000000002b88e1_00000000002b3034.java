import java.util.Scanner;

public class Solution {
    private final Scanner scanner = new Scanner(System.in);

    private boolean solve(int testCaseNumber) {
        int numberOfPatterns = scanner.nextInt();
        String[] patterns = new String[numberOfPatterns];
        for (int i = 0; i < numberOfPatterns; i++) {
            patterns[i] = scanner.next();
        }

        StringBuilder result = new StringBuilder();
        int[] positions = new int[numberOfPatterns];
        for (int i = 0; i < numberOfPatterns; i++) {
            positions[i] = patterns[i].length() - 1;
        }

        while (true) {
            Character currentChar = null;
            boolean allPatternsProcessed = true;

            for (int i = 0; i < numberOfPatterns; i++) {
                String pattern = patterns[i];
                if (positions[i] < 0) continue;
                char c = pattern.charAt(positions[i]--);
                if (currentChar == null) {
                    currentChar = c;
                    result.append(c);
                } else if (currentChar != c) {
                    return false;
                }
                allPatternsProcessed = false;
            }

            if (allPatternsProcessed) break;
        }

        System.out.println(String.format("Case #%d: %s", testCaseNumber, result.reverse().toString()));
        return true;
    }

    private void run() {
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            if (!solve(testCase)) {
                System.out.println(String.format("Case #%d: *", testCase));
            }
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}