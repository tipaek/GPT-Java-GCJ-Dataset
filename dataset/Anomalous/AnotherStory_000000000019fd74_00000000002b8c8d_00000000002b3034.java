import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            boolean isValid = true;

            String[] patterns = new String[n];
            for (int i = 0; i < n; i++) {
                patterns[i] = scanner.next();
            }

            List<String> suffixes = new ArrayList<>();
            List<String> prefixes = new ArrayList<>();

            for (String pattern : patterns) {
                int asteriskIndex = pattern.indexOf('*');

                if (asteriskIndex != pattern.length() - 1) {
                    suffixes.add(pattern.substring(asteriskIndex + 1));
                }

                if (asteriskIndex != 0) {
                    prefixes.add(pattern.substring(0, asteriskIndex));
                }
            }

            String maxSuffix = getMaxString(suffixes);
            String maxPrefix = getMaxString(prefixes);

            isValid = checkContainment(suffixes, maxSuffix) && checkContainment(prefixes, maxPrefix);

            String result = determineResult(isValid, maxPrefix, maxSuffix);

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }

    private static String getMaxString(List<String> strings) {
        String maxString = "";
        for (String str : strings) {
            if (str.length() > maxString.length()) {
                maxString = str;
            }
        }
        return maxString;
    }

    private static boolean checkContainment(List<String> strings, String maxString) {
        for (String str : strings) {
            if (!maxString.contains(str)) {
                return false;
            }
        }
        return true;
    }

    private static String determineResult(boolean isValid, String maxPrefix, String maxSuffix) {
        if (!isValid) {
            return "*";
        }
        return maxPrefix + maxSuffix;
    }
}