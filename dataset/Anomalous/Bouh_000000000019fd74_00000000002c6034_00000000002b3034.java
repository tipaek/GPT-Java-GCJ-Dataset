import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String result = solveProblem(scanner);
        System.out.println(result);
    }

    public static String solveProblem(Scanner scanner) {
        StringBuilder result = new StringBuilder();
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            String[] patterns = new String[n];
            for (int j = 0; j < n; j++) {
                patterns[j] = scanner.next();
            }
            result.append("Case #").append(i).append(": ").append(solveCase(patterns)).append("\n");
        }
        return result.toString();
    }

    public static String solveCase(String[] patterns) {
        StringBuilder result = new StringBuilder();
        String maxPrefix = "";
        String maxSuffix = "";
        List<String> middleParts = new ArrayList<>();
        
        for (String pattern : patterns) {
            pattern = pattern.replace("**", "*");
            String[] parts = split(pattern);
            
            if (!pattern.startsWith("*")) {
                String prefix = parts[0];
                if (maxPrefix.length() >= prefix.length()) {
                    if (!maxPrefix.startsWith(prefix)) {
                        return "*";
                    }
                } else {
                    if (!prefix.startsWith(maxPrefix)) {
                        return "*";
                    } else {
                        maxPrefix = prefix;
                    }
                }
            }
            
            if (!pattern.endsWith("*")) {
                String suffix = parts[parts.length - 1];
                if (maxSuffix.length() >= suffix.length()) {
                    if (!maxSuffix.endsWith(suffix)) {
                        return "*";
                    }
                } else {
                    if (!suffix.endsWith(maxSuffix)) {
                        return "*";
                    } else {
                        maxSuffix = suffix;
                    }
                }
            }
            
            for (int i = 1; i < parts.length - 1; i++) {
                middleParts.add(parts[i]);
            }
        }

        result.append(maxPrefix);
        for (String middlePart : middleParts) {
            result.append(middlePart);
        }
        result.append(maxSuffix);

        return result.toString();
    }

    public static String[] split(String str) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        
        for (char ch : str.toCharArray()) {
            if (ch == '*') {
                if (current.length() > 0) {
                    result.add(current.toString());
                    current.setLength(0);
                }
            } else {
                current.append(ch);
            }
        }
        
        if (current.length() > 0) {
            result.add(current.toString());
        }
        
        return result.toArray(new String[0]);
    }
}