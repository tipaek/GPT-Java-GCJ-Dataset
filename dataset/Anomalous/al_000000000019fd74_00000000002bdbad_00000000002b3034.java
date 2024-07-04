import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = scanner.nextInt();

        for (int i = 0; i < testCount; i++) {
            int count = scanner.nextInt();
            List<String> patterns = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                patterns.add(scanner.next());
            }
            String result = findPattern(patterns);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String findPattern(List<String> patterns) {
        List<String> adjustedPatterns = adjustPatternsToFixedLength(patterns);
        int index = adjustedPatterns.get(0).length() - 1;

        while (adjustedPatterns.size() > 1) {
            char currentChar = '-';
            for (int i = adjustedPatterns.size() - 1; i >= 0; i--) {
                String pattern = adjustedPatterns.get(i);
                char charAtIdx = pattern.charAt(index);

                if (charAtIdx == '*' || charAtIdx == ' ') {
                    adjustedPatterns.remove(i);
                    continue;
                }

                if (currentChar == '-') {
                    currentChar = charAtIdx;
                } else if (currentChar != charAtIdx) {
                    return "*";
                }
            }
            index--;
        }

        String longestPattern = adjustedPatterns.get(0);
        return longestPattern.substring(1);
    }

    private static List<String> adjustPatternsToFixedLength(List<String> patterns) {
        List<String> result = new ArrayList<>();
        int maxLength = patterns.stream().mapToInt(String::length).max().orElse(0);

        for (String pattern : patterns) {
            if (pattern.length() < maxLength) {
                StringBuilder newPattern = new StringBuilder();
                for (int i = 0; i < maxLength - pattern.length(); i++) {
                    newPattern.append(' ');
                }
                newPattern.append(pattern);
                result.add(newPattern.toString());
            } else {
                result.add(pattern);
            }
        }
        return result;
    }
}