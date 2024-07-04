import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int patternsCount = scanner.nextInt();
            scanner.nextLine();

            String longestRightPattern = "";
            String longestLeftPattern = "";
            boolean isImpossible = false;
            
            for (int j = 0; j < patternsCount; j++) {
                String pattern = scanner.nextLine();
                String leftPattern = pattern.substring(0, pattern.indexOf("*"));
                String rightPattern = pattern.substring(pattern.indexOf("*") + 1);

                if (!updateLongestPattern(leftPattern, longestLeftPattern)) {
                    isImpossible = true;
                } else {
                    longestLeftPattern = updatePattern(longestLeftPattern, leftPattern);
                }

                if (!updateLongestPattern(rightPattern, longestRightPattern)) {
                    isImpossible = true;
                } else {
                    longestRightPattern = updatePattern(longestRightPattern, rightPattern);
                }
            }

            String result = isImpossible ? "*" : longestLeftPattern + longestRightPattern;
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static boolean updateLongestPattern(String newPattern, String longestPattern) {
        if (newPattern.length() > longestPattern.length()) {
            return newPattern.contains(longestPattern);
        } else {
            return longestPattern.contains(newPattern) &&
                   longestPattern.startsWith(newPattern) || longestPattern.endsWith(newPattern);
        }
    }

    private static String updatePattern(String longestPattern, String newPattern) {
        return newPattern.length() > longestPattern.length() ? newPattern : longestPattern;
    }
}