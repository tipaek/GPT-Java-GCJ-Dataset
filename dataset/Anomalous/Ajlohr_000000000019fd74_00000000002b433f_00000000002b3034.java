import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int N = scanner.nextInt();
            Set<String> prefixes = new HashSet<>();
            Set<String> suffixes = new HashSet<>();
            List<String> middles = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                String input = scanner.next();
                String[] components = input.split("\\*", -1);
                prefixes.add(components[0]);
                suffixes.add(components[components.length - 1]);
                for (int j = 1; j < components.length - 1; j++) {
                    middles.add(components[j]);
                }
            }
            
            String longestPrefix = findLongestString(prefixes);
            if (!isValidPrefix(prefixes, longestPrefix)) {
                System.out.println("Case #" + caseNumber + ": *");
                continue;
            }
            
            String longestSuffix = findLongestString(suffixes);
            if (!isValidSuffix(suffixes, longestSuffix)) {
                System.out.println("Case #" + caseNumber + ": *");
                continue;
            }
            
            String result = buildResult(longestPrefix, middles, longestSuffix);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
    
    private static String findLongestString(Set<String> strings) {
        String longestString = "";
        for (String s : strings) {
            if (s.length() > longestString.length()) {
                longestString = s;
            }
        }
        return longestString;
    }
    
    private static boolean isValidPrefix(Set<String> prefixes, String candidatePrefix) {
        for (String prefix : prefixes) {
            if (!candidatePrefix.startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean isValidSuffix(Set<String> suffixes, String candidateSuffix) {
        for (String suffix : suffixes) {
            if (!candidateSuffix.endsWith(suffix)) {
                return false;
            }
        }
        return true;
    }
    
    private static String buildResult(String prefix, List<String> middles, String suffix) {
        StringBuilder result = new StringBuilder(prefix);
        for (String middle : middles) {
            result.append(middle);
        }
        result.append(suffix);
        return result.toString();
    }
}