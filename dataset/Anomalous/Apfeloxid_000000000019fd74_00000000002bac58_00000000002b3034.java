import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testAmount = scanner.nextInt();

        for (int testId = 1; testId <= testAmount; testId++) {
            int n = scanner.nextInt();
            scanner.nextLine();

            List<String> prefixes = new ArrayList<>();
            List<String> suffixes = new ArrayList<>();
            List<String> middles = new ArrayList<>();
            List<String> patterns = new ArrayList<>();

            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                String pattern = scanner.nextLine();
                patterns.add(pattern);
                String[] splitPattern = pattern.split("\\*");

                if (result.length() == 0 && !pattern.contains("*")) {
                    result.append(pattern);
                }

                if (pattern.charAt(0) != '*') {
                    prefixes.add(splitPattern[0]);
                }
                if (pattern.charAt(pattern.length() - 1) != '*') {
                    suffixes.add(splitPattern[splitPattern.length - 1]);
                }
                for (String str : splitPattern) {
                    if (!str.isEmpty()) {
                        middles.add(str);
                    }
                }
            }

            String prefix = getPrefix(prefixes);
            String suffix = getSuffix(suffixes);

            if (prefix.equals("ERROR") || suffix.equals("ERROR")) {
                System.out.println("Case #" + testId + ": *");
                continue;
            }

            if (result.length() > 0) {
                boolean isPossible = true;
                for (String pattern : patterns) {
                    int resultPointer = 0;
                    for (int i = 0; i < pattern.length(); i++) {
                        if (pattern.charAt(i) == '*') {
                            continue;
                        }

                        if (resultPointer >= result.length()) {
                            isPossible = false;
                            break;
                        }

                        if (pattern.charAt(i) == result.charAt(resultPointer)) {
                            resultPointer++;
                        } else {
                            resultPointer++;
                            i--;
                        }
                    }
                }

                if (!isPossible) {
                    System.out.println("Case #" + testId + ": *");
                } else {
                    System.out.println("Case #" + testId + ": " + result);
                }
                continue;
            }

            result.append(prefix);

            for (String mid : middles) {
                result.append(mid);
            }
            result.append(suffix);

            System.out.println("Case #" + testId + ": " + result);
        }
    }

    private static String getPrefix(List<String> prefixes) {
        String result = "";

        for (String str : prefixes) {
            for (int i = 0; i < Math.min(result.length(), str.length()); i++) {
                if (result.charAt(i) != str.charAt(i)) {
                    return "ERROR";
                }
            }
            if (str.length() > result.length()) {
                result = str;
            }
        }

        return result;
    }

    private static String getSuffix(List<String> suffixes) {
        String result = "";

        for (String str : suffixes) {
            for (int i = 0; i < Math.min(result.length(), str.length()); i++) {
                if (result.charAt(result.length() - i - 1) != str.charAt(str.length() - i - 1)) {
                    return "ERROR";
                }
            }
            if (str.length() > result.length()) {
                result = str;
            }
        }

        return result;
    }
}