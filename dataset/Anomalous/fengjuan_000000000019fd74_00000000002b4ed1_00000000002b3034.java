import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            Set<String> prefixes = new HashSet<>();
            Set<String> middles = new HashSet<>();
            Set<String> suffixes = new HashSet<>();
            
            for (int i = 0; i < n; i++) {
                String pattern = scanner.next();
                int firstAsterisk = pattern.indexOf('*');
                int lastAsterisk = pattern.lastIndexOf('*');
                
                prefixes.add(pattern.substring(0, firstAsterisk));
                
                if (lastAsterisk > firstAsterisk) {
                    middles.add(pattern.substring(firstAsterisk + 1, lastAsterisk).replace("*", ""));
                }
                
                suffixes.add(pattern.substring(lastAsterisk + 1));
            }
            
            String longestPrefix = findLongest(prefixes);
            String longestSuffix = findLongest(suffixes);
            
            if (allStartWith(longestPrefix, prefixes) && allEndWith(longestSuffix, suffixes)) {
                StringBuilder middlePart = new StringBuilder();
                for (String middle : middles) {
                    middlePart.append(middle);
                }
                System.out.println("Case #" + caseNumber + ": " + longestPrefix + middlePart + longestSuffix);
            } else {
                System.out.println("Case #" + caseNumber + ": *");
            }
        }
    }

    private static String findLongest(Set<String> strings) {
        String longest = "";
        for (String s : strings) {
            if (s.length() > longest.length()) {
                longest = s;
            }
        }
        return longest;
    }

    private static boolean allStartWith(String prefix, Set<String> strings) {
        for (String s : strings) {
            if (!prefix.startsWith(s)) {
                return false;
            }
        }
        return true;
    }

    private static boolean allEndWith(String suffix, Set<String> strings) {
        for (String s : strings) {
            if (!suffix.endsWith(s)) {
                return false;
            }
        }
        return true;
    }
}