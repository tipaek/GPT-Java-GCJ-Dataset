import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        
        for (int i = 1; i <= numberOfTestCases; i++) {
            int numberOfPatterns = scanner.nextInt();
            scanner.nextLine();
            List<String> patterns = new ArrayList<>();
            
            for (int j = 0; j < numberOfPatterns; j++) {
                patterns.add(scanner.nextLine());
            }
            
            System.out.println("Case #" + i + ": " + findPattern(patterns));
        }
    }

    public static String findPattern(List<String> patterns) {
        String prefix = "";
        String suffix = "";
        List<String> remainingPatterns = new ArrayList<>();
        
        for (String pattern : patterns) {
            String currentPrefix = "";
            String currentSuffix = "";
            
            if (pattern.contains("*")) {
                currentPrefix = pattern.substring(0, pattern.indexOf('*'));
                currentSuffix = pattern.substring(pattern.lastIndexOf('*') + 1);
            } else {
                return pattern;
            }
            
            if (prefix.isEmpty()) {
                prefix = currentPrefix;
            }
            
            if (suffix.isEmpty()) {
                suffix = currentSuffix;
            }
            
            if (prefix.contains(currentPrefix) || currentPrefix.contains(prefix)) {
                prefix = prefix.length() >= currentPrefix.length() ? prefix : currentPrefix;
            } else {
                return "*";
            }
            
            if (suffix.contains(currentSuffix) || currentSuffix.contains(suffix)) {
                suffix = suffix.length() >= currentSuffix.length() ? suffix : currentSuffix;
            } else {
                return "*";
            }
            
            String middlePart = "";
            if (currentPrefix.isEmpty() || currentSuffix.isEmpty()) {
                if (currentPrefix.isEmpty() && currentSuffix.isEmpty()) {
                    middlePart = pattern.substring(1, pattern.length() - 1);
                } else if (currentPrefix.isEmpty()) {
                    middlePart = pattern.substring(1, pattern.indexOf(currentSuffix));
                } else if (currentSuffix.isEmpty()) {
                    middlePart = pattern.substring(pattern.indexOf(currentPrefix) + 1, pattern.length() - 1);
                }
            } else {
                middlePart = pattern.substring(pattern.indexOf(currentPrefix) + 1, pattern.indexOf(currentSuffix));
            }
            
            if (!middlePart.isEmpty() && !middlePart.equals("*")) {
                remainingPatterns.add(middlePart);
            }
        }
        
        if (remainingPatterns.isEmpty()) {
            return prefix + suffix;
        } else {
            return prefix + findPattern(remainingPatterns) + suffix;
        }
    }
}