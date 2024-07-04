import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            String[] patterns = new String[n];
            
            for (int i = 0; i < n; i++) {
                patterns[i] = scanner.next();
            }
            
            System.out.println(String.format("Case #%d: %s", caseNumber, findPattern(n, patterns)));
        }
    }

    private static String findPattern(int n, String[] patterns) {
        String prefix = "";
        String suffix = "";
        
        for (String pattern : patterns) {
            String currentPrefix = extractPrefix(pattern);
            String currentSuffix = extractSuffix(pattern);
            
            if (currentPrefix.length() > prefix.length()) {
                if (currentPrefix.startsWith(prefix)) {
                    prefix = currentPrefix;
                } else {
                    return "*";
                }
            } else if (!prefix.startsWith(currentPrefix)) {
                return "*";
            }
            
            if (currentSuffix.length() > suffix.length()) {
                if (currentSuffix.endsWith(suffix)) {
                    suffix = currentSuffix;
                } else {
                    return "*";
                }
            } else if (!suffix.endsWith(currentSuffix)) {
                return "*";
            }
        }
        
        return prefix + suffix;
    }

    private static String extractPrefix(String str) {
        return str.substring(0, str.indexOf('*'));
    }

    private static String extractSuffix(String str) {
        return str.substring(str.indexOf('*') + 1);
    }
}