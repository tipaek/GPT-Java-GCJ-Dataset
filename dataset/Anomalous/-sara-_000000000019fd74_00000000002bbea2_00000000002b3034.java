import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int patternCount = scanner.nextInt();
            scanner.nextLine();
            
            List<String> patterns = new ArrayList<>();
            List<String> suffixes = new ArrayList<>();
            int maxSuffixLength = 0;
            String result = "";
            
            for (int i = 0; i < patternCount; i++) {
                String pattern = scanner.nextLine();
                patterns.add(pattern);
                String suffix = pattern.substring(1);
                suffixes.add(suffix);
                if (suffix.length() > maxSuffixLength) {
                    maxSuffixLength = suffix.length();
                }
            }
            
            String longestSuffix = suffixes.stream()
                                           .filter(suffix -> suffix.length() == maxSuffixLength)
                                           .findFirst()
                                           .orElse("");
            
            boolean isPossible = suffixes.stream()
                                         .allMatch(longestSuffix::contains);
            
            result = isPossible ? longestSuffix : "*";
            System.out.println("Case #" + caseNumber + ": " + result);
        }
        
        scanner.close();
    }
}