import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int patternCount = scanner.nextInt();
            String[] patterns = new String[patternCount];
            for (int i = 0; i < patternCount; i++) {
                patterns[i] = scanner.next();
            }
            processPatterns(patternCount, patterns, caseNum);
        }
    }

    static void processPatterns(int patternCount, String[] patterns, int caseNum) {
        Arrays.sort(patterns);
        for (int i = 0; i < patternCount; i++) {
            boolean isMatch = true;
            String currentPattern = patterns[i];
            for (int j = i + 1; j < patternCount; j++) {
                if (!currentPattern.contains(patterns[j].substring(1))) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                System.out.println("Case #" + caseNum + ": " + currentPattern);
                return;
            }
        }
        System.out.println("Case #" + caseNum + ": *");
    }
}