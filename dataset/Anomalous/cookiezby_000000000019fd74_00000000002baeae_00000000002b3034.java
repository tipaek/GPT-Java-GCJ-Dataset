import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < caseCount; i++) {
            int patternCount = Integer.parseInt(scanner.nextLine());
            String[] patterns = new String[patternCount];
            for (int j = 0; j < patternCount; j++) {
                patterns[j] = scanner.nextLine();
            }
            System.out.println(processPatterns(patterns, i));
        }
        scanner.close();
    }

    public static String processPatterns(String[] patterns, int caseIndex) {
        List<List<String>> splitPatterns = new ArrayList<>();
        
        for (String pattern : patterns) {
            String[] parts = pattern.split("\\*");
            List<String> partsList = new ArrayList<>(Arrays.asList(parts));
            if (pattern.startsWith("*")) {
                partsList.add(0, "#");
            }
            if (pattern.endsWith("*")) {
                partsList.add("#");
            }
            splitPatterns.add(partsList);
        }

        String longestPrefix = "";
        String longestSuffix = "";
        
        for (List<String> parts : splitPatterns) {
            String prefix = parts.get(0);
            String suffix = parts.get(parts.size() - 1);
            
            if (prefix.length() > longestPrefix.length()) {
                longestPrefix = prefix;
            }
            if (suffix.length() > longestSuffix.length()) {
                longestSuffix = suffix;
            }
        }

        for (List<String> parts : splitPatterns) {
            String prefix = parts.get(0);
            String suffix = parts.get(parts.size() - 1);
            
            if (!suffix.equals("#") && !longestSuffix.endsWith(suffix)) {
                return "*";
            }
            if (!prefix.equals("#") && !longestPrefix.startsWith(prefix)) {
                return "*";
            }
        }

        StringBuilder middlePart = new StringBuilder();
        for (List<String> parts : splitPatterns) {
            for (int j = 1; j < parts.size() - 1; j++) {
                middlePart.append(parts.get(j));
            }
        }

        StringBuilder result = new StringBuilder();
        if (!longestPrefix.equals("#")) {
            result.append(longestPrefix);
        }
        result.append(middlePart);
        if (!longestSuffix.equals("#")) {
            result.append(longestSuffix);
        }
        
        return String.format("Case #%d: %s", caseIndex + 1, result.toString());
    }
}