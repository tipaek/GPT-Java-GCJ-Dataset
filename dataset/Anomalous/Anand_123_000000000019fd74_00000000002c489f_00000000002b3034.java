import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            String[] patterns = new String[n];
            
            for (int j = 0; j < n; j++) {
                patterns[j] = sc.next();
            }
            
            String[] leftParts = new String[n];
            String[] rightParts = new String[n];
            
            for (int j = 0; j < n; j++) {
                int starIndex = patterns[j].indexOf('*');
                leftParts[j] = patterns[j].substring(0, starIndex);
                rightParts[j] = (starIndex != patterns[j].length() - 1) ? patterns[j].substring(starIndex + 1) : "";
            }
            
            String leftResult = findLongestCommonPrefix(leftParts);
            String rightResult = findLongestCommonSuffix(rightParts);
            
            if (leftResult.isEmpty() && rightResult.isEmpty()) {
                System.out.println("Case #" + i + ": *");
            } else if (leftResult.equals(rightResult)) {
                System.out.println("Case #" + i + ": " + leftResult);
            } else {
                System.out.println("Case #" + i + ": " + leftResult + "*" + rightResult);
            }
        }
        
        sc.close();
    }

    private static String findLongestCommonPrefix(String[] parts) {
        String longestPrefix = "";
        int maxLength = Integer.MIN_VALUE;
        
        for (String part : parts) {
            if (part.length() > maxLength) {
                maxLength = part.length();
                longestPrefix = part;
            }
        }
        
        for (String part : parts) {
            if (!longestPrefix.startsWith(part)) {
                return "";
            }
        }
        
        return longestPrefix;
    }

    private static String findLongestCommonSuffix(String[] parts) {
        String longestSuffix = "";
        int maxLength = Integer.MIN_VALUE;
        
        for (String part : parts) {
            if (part.length() > maxLength) {
                maxLength = part.length();
                longestSuffix = part;
            }
        }
        
        for (String part : parts) {
            if (!longestSuffix.endsWith(part)) {
                return "";
            }
        }
        
        return longestSuffix;
    }
}