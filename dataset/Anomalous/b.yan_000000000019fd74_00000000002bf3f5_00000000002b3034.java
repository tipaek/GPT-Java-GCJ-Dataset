import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int patternsCount = scanner.nextInt();
            scanner.nextLine();
            String prefix = "";
            String suffix = "";
            boolean isValid = true;
            
            for (int p = 0; p < patternsCount; p++) {
                String pattern = scanner.nextLine();
                String currentPrefix = "";
                String currentSuffix = "";
                
                // Extract prefix
                int k = 0;
                while (k < pattern.length() && pattern.charAt(k) != '*') {
                    currentPrefix += pattern.charAt(k);
                    k++;
                }
                
                // Extract suffix
                k = pattern.length() - 1;
                while (k >= 0 && pattern.charAt(k) != '*') {
                    currentSuffix = pattern.charAt(k) + currentSuffix;
                    k--;
                }
                
                // Check prefix compatibility
                if (prefix.length() < currentPrefix.length() && !currentPrefix.startsWith(prefix)) {
                    isValid = false;
                } else if (prefix.length() >= currentPrefix.length() && !prefix.startsWith(currentPrefix)) {
                    isValid = false;
                }
                
                // Check suffix compatibility
                if (suffix.length() < currentSuffix.length() && !currentSuffix.endsWith(suffix)) {
                    isValid = false;
                } else if (suffix.length() >= currentSuffix.length() && !suffix.endsWith(currentSuffix)) {
                    isValid = false;
                }
                
                // Update prefix and suffix if necessary
                if (currentPrefix.length() > prefix.length()) {
                    prefix = currentPrefix;
                }
                if (currentSuffix.length() > suffix.length()) {
                    suffix = currentSuffix;
                }
            }
            
            if (!isValid) {
                System.out.println("Case #" + t + ": *");
            } else {
                System.out.println("Case #" + t + ": " + prefix + suffix);
            }
        }
    }
}