import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            StringBuilder result = new StringBuilder();
            int patternCount = scanner.nextInt();
            List<String> patterns = new ArrayList<>();
            List<Character> prefixList = new ArrayList<>();
            List<Character> suffixList = new ArrayList<>();
            boolean isInvalid = false;

            for (int i = 0; i < patternCount; i++) {
                String pattern = scanner.next();
                if (isInvalid) {
                    continue;
                }

                if (!pattern.startsWith("*")) {
                    int minLength = Math.min(prefixList.size(), pattern.indexOf("*"));
                    for (int j = 0; j < minLength; j++) {
                        if (prefixList.get(j) != pattern.charAt(j)) {
                            isInvalid = true;
                            break;
                        }
                    }
                    for (int j = prefixList.size(); j < pattern.indexOf("*"); j++) {
                        prefixList.add(pattern.charAt(j));
                    }
                }

                if (!pattern.endsWith("*")) {
                    int prefixSize = suffixList.size();
                    int suffixStart = pattern.length() - 1;
                    int suffixEnd = pattern.lastIndexOf("*") + 1;
                    for (int j = 0; j < Math.min(prefixSize, suffixStart - suffixEnd + 1); j++) {
                        if (suffixList.get(j) != pattern.charAt(suffixStart - j)) {
                            isInvalid = true;
                            break;
                        }
                    }
                    for (int j = suffixStart - prefixSize; j > suffixEnd; j--) {
                        suffixList.add(pattern.charAt(j));
                    }
                }

                patterns.add(pattern);
            }

            if (!isInvalid) {
                for (Character ch : prefixList) {
                    result.append(ch);
                }

                for (String pattern : patterns) {
                    int start = pattern.indexOf("*");
                    int end = pattern.lastIndexOf("*");
                    for (int j = start + 1; j < end; j++) {
                        if (pattern.charAt(j) != '*') {
                            result.append(pattern.charAt(j));
                        }
                    }
                }

                for (int j = suffixList.size() - 1; j >= 0; j--) {
                    result.append(suffixList.get(j));
                }
            } else {
                result.append("*");
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }
}