import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            List<String> prefixes = new ArrayList<>();
            List<String> suffixes = new ArrayList<>();
            List<String> middleParts = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                String input = scanner.next();
                
                if (!input.contains("*")) {
                    prefixes.add(input);
                    suffixes.add(input);
                } else {
                    String[] parts = input.split("\\*");
                    prefixes.add(parts[0]);
                    suffixes.add(parts[parts.length - 1]);
                    for (int j = 1; j < parts.length - 1; j++) {
                        middleParts.add(parts[j]);
                    }
                }
            }
            
            String maxPrefix = findMaxString(prefixes, true);
            String maxSuffix = findMaxString(suffixes, false);
            
            String result = "*";
            if (maxPrefix != null && maxSuffix != null) {
                StringBuilder ansBuilder = new StringBuilder(maxPrefix);
                for (String middle : middleParts) {
                    ansBuilder.append(middle);
                }
                ansBuilder.append(maxSuffix);
                result = ansBuilder.toString();
            }
            
            System.out.printf("Case #%d: %s%n", t, result);
        }
        
        scanner.close();
    }
    
    private static String findMaxString(List<String> list, boolean isPrefix) {
        String maxString = "";
        for (String str : list) {
            if (str.length() > maxString.length()) {
                maxString = str;
            }
        }
        
        for (String str : list) {
            if (isPrefix) {
                if (!maxString.startsWith(str)) {
                    return null;
                }
            } else {
                if (!maxString.endsWith(str)) {
                    return null;
                }
            }
        }
        
        return maxString;
    }
}