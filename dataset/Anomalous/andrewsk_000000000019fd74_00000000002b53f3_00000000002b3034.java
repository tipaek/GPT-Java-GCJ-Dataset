import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            List<String> patterns = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                patterns.add(scanner.next());
            }
            String result = processPatterns(patterns);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String processPatterns(List<String> patterns) {
        String suffix = findSuffix(patterns);
        if (suffix.equals("*")) {
            return "*";
        }

        String prefix = findPrefix(patterns);
        if (prefix.equals("*")) {
            return "*";
        }

        String middle = findMiddle(patterns);
        return prefix + middle + suffix;
    }

    private static String findMiddle(List<String> patterns) {
        StringBuilder middleBuilder = new StringBuilder();
        for (String pattern : patterns) {
            int firstAsterisk = pattern.indexOf("*");
            int lastAsterisk = pattern.lastIndexOf("*");
            if (firstAsterisk != lastAsterisk) {
                String middlePart = pattern.substring(firstAsterisk + 1, lastAsterisk).replace("*", "");
                middleBuilder.append(middlePart);
            }
        }
        return middleBuilder.toString();
    }

    private static String findPrefix(List<String> patterns) {
        List<String> reversedPatterns = new ArrayList<>();
        for (String pattern : patterns) {
            reversedPatterns.add(new StringBuilder(pattern).reverse().toString());
        }
        String reversedPrefix = findSuffix(reversedPatterns);
        return new StringBuilder(reversedPrefix).reverse().toString();
    }

    private static String findSuffix(List<String> patterns) {
        List<String> suffixes = new ArrayList<>();
        String longestSuffix = "";
        for (String pattern : patterns) {
            String suffix = pattern.substring(pattern.lastIndexOf("*") + 1);
            suffixes.add(suffix);
            if (suffix.length() > longestSuffix.length()) {
                longestSuffix = suffix;
            }
        }
        for (String suffix : suffixes) {
            if (!longestSuffix.endsWith(suffix)) {
                return "*";
            }
        }
        return longestSuffix;
    }
}