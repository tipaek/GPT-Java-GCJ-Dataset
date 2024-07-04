import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scanner.nextInt();
            String[] patterns = new String[n];
            
            for (int i = 0; i < n; i++) {
                patterns[i] = scanner.next();
            }
            
            int maxPrefixLength = 0;
            int maxPrefixIndex = -1;
            int maxSuffixLength = 0;
            int maxSuffixIndex = -1;
            
            for (int i = 0; i < n; i++) {
                int asteriskIndex = patterns[i].indexOf('*');
                if (asteriskIndex > maxPrefixLength) {
                    maxPrefixLength = asteriskIndex;
                    maxPrefixIndex = i;
                }
                int suffixLength = patterns[i].length() - asteriskIndex - 1;
                if (suffixLength > maxSuffixLength) {
                    maxSuffixLength = suffixLength;
                    maxSuffixIndex = i;
                }
            }
            
            if (maxPrefixIndex == -1) {
                String result = patterns[maxSuffixIndex].substring(1);
                boolean isValid = true;
                
                for (int i = 0; i < n; i++) {
                    if (i == maxSuffixIndex) continue;
                    String rest = patterns[i].substring(1);
                    if (!result.endsWith(rest)) {
                        isValid = false;
                        break;
                    }
                }
                
                System.out.println("Case #" + caseNum + ": " + (isValid ? result : "*"));
            } else if (maxSuffixIndex == -1) {
                String result = patterns[maxPrefixIndex].substring(0, maxPrefixLength);
                boolean isValid = true;
                
                for (int i = 0; i < n; i++) {
                    if (i == maxPrefixIndex) continue;
                    String rest = patterns[i].substring(0, patterns[i].length() - 1);
                    if (!result.startsWith(rest)) {
                        isValid = false;
                        break;
                    }
                }
                
                System.out.println("Case #" + caseNum + ": " + (isValid ? result : "*"));
            } else {
                String result = patterns[maxPrefixIndex].substring(0, maxPrefixLength) + 
                                patterns[maxSuffixIndex].substring(patterns[maxSuffixIndex].length() - maxSuffixLength);
                boolean isValid = true;
                
                for (int i = 0; i < n; i++) {
                    int asteriskIndex = patterns[i].indexOf('*');
                    String prefix = patterns[i].substring(0, asteriskIndex);
                    String suffix = patterns[i].substring(asteriskIndex + 1);
                    
                    if (!result.startsWith(prefix) || !result.endsWith(suffix)) {
                        isValid = false;
                        break;
                    }
                }
                
                System.out.println("Case #" + caseNum + ": " + (isValid ? result : "*"));
            }
        }
        
        scanner.close();
    }
}