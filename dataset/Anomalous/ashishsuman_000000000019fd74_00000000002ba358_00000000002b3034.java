import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();  // Consume the newline after the integer input

        for (int k = 1; k <= testCases; k++) {
            String result = "";
            int patternCount = sc.nextInt();
            sc.nextLine();  // Consume the newline after the integer input

            List<String> patterns = new ArrayList<>();
            for (int i = 0; i < patternCount; i++) {
                patterns.add(sc.nextLine());
            }

            List<String> prefixList = new ArrayList<>();
            List<String> middleList = new ArrayList<>();
            List<String> suffixList = new ArrayList<>();

            for (String pattern : patterns) {
                String[] components = pattern.split("\\*", 3);
                if (components.length > 0) {
                    prefixList.add(components[0]);
                }
                if (components.length > 1) {
                    middleList.add(components[1]);
                }
                if (components.length > 2) {
                    suffixList.add(components[2]);
                }
            }

            String longestPrefix = findLongestString(prefixList);
            String longestMiddle = findLongestString(middleList);
            String longestSuffix = findLongestString(suffixList);

            if (!allStringsContained(prefixList, longestPrefix) || 
                !allStringsContained(middleList, longestMiddle) || 
                !allStringsContained(suffixList, longestSuffix)) {
                result = "*";
            } else {
                result = longestPrefix + longestMiddle + longestSuffix;
            }

            System.out.println("Case #" + k + ": " + result);
        }
    }

    private static String findLongestString(List<String> list) {
        String longest = "";
        for (String str : list) {
            if (str.length() > longest.length()) {
                longest = str;
            }
        }
        return longest;
    }

    private static boolean allStringsContained(List<String> list, String container) {
        for (String str : list) {
            if (!container.contains(str)) {
                return false;
            }
        }
        return true;
    }
}