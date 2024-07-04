import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            System.out.print("Case #" + caseIndex + ": ");
            
            int n = scanner.nextInt();
            String[] patterns = new String[n];
            boolean[] startsWithChar = new boolean[n];
            boolean[] endsWithChar = new boolean[n];
            String[][] splitPatterns = new String[n][];
            String fullPattern = "";
            
            for (int i = 0; i < n; i++) {
                patterns[i] = scanner.next();
                splitPatterns[i] = patterns[i].split("\\*");
                startsWithChar[i] = patterns[i].charAt(0) != '*';
                endsWithChar[i] = patterns[i].charAt(patterns[i].length() - 1) != '*';
                
                if (splitPatterns[i].length == 1 && startsWithChar[i] && endsWithChar[i]) {
                    fullPattern = splitPatterns[i][0];
                }
            }

            String maxStart = "";
            String maxEnd = "";
            
            for (int i = 0; i < n; i++) {
                if (startsWithChar[i] && splitPatterns[i][0].length() > maxStart.length()) {
                    maxStart = splitPatterns[i][0];
                }
                if (endsWithChar[i] && splitPatterns[i][splitPatterns[i].length - 1].length() > maxEnd.length()) {
                    maxEnd = splitPatterns[i][splitPatterns[i].length - 1];
                }
            }

            if (!isValidPrefix(maxStart, splitPatterns, startsWithChar) || !isValidSuffix(maxEnd, splitPatterns, endsWithChar)) {
                System.out.println("*");
                continue;
            }

            StringBuilder result = new StringBuilder();
            result.append(maxStart);
            
            for (int i = 0; i < n; i++) {
                int start = startsWithChar[i] ? 1 : 0;
                int end = endsWithChar[i] ? splitPatterns[i].length - 1 : splitPatterns[i].length;
                
                for (int j = start; j < end; j++) {
                    result.append(splitPatterns[i][j]);
                }
            }
            
            result.append(maxEnd);
            System.out.println(result);
        }
    }

    private static boolean isValidPrefix(String maxStart, String[][] splitPatterns, boolean[] startsWithChar) {
        for (int i = 0; i < maxStart.length(); i++) {
            char currentChar = maxStart.charAt(i);
            for (int j = 0; j < splitPatterns.length; j++) {
                if (startsWithChar[j] && i < splitPatterns[j][0].length() && splitPatterns[j][0].charAt(i) != currentChar) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidSuffix(String maxEnd, String[][] splitPatterns, boolean[] endsWithChar) {
        for (int i = 0; i < maxEnd.length(); i++) {
            char currentChar = maxEnd.charAt(maxEnd.length() - 1 - i);
            for (int j = 0; j < splitPatterns.length; j++) {
                if (endsWithChar[j] && i < splitPatterns[j][splitPatterns[j].length - 1].length() && splitPatterns[j][splitPatterns[j].length - 1].charAt(splitPatterns[j][splitPatterns[j].length - 1].length() - 1 - i) != currentChar) {
                    return false;
                }
            }
        }
        return true;
    }
}