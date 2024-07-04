import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int patternCount = scanner.nextInt();
            List<String> patterns = new ArrayList<>();

            for (int i = 0; i < patternCount; i++) {
                String pattern = scanner.next().replaceAll("\\*\\*", "*");
                patterns.add(pattern);
            }

            System.out.println("Case #" + testCase + ": " + findPossibleName(patterns));
        }
    }

    private static String findPossibleName(List<String> patterns) {
        String shortestPattern = patterns.stream()
                                         .min(Comparator.comparingInt(String::length))
                                         .orElse("");

        patterns.remove(shortestPattern);
        List<Integer> asteriskPositions = getAsteriskPositions(shortestPattern);
        String result = "";

        for (String pattern : patterns) {
            List<Integer> patternAsteriskPositions = getAsteriskPositions(pattern);
            String tempResult = "";

            for (int pos : asteriskPositions) {
                String beforeAsterisk = shortestPattern.substring(0, pos);
                String afterAsterisk = shortestPattern.substring(pos + 1);

                if (pattern.contains(beforeAsterisk) || pattern.contains(afterAsterisk)) {
                    int beforeIndex = pattern.contains(beforeAsterisk) ? pattern.indexOf(beforeAsterisk) + beforeAsterisk.length() : 0;
                    int afterIndex = pattern.contains(afterAsterisk) ? pattern.indexOf(afterAsterisk) : pattern.length();
                    tempResult = beforeAsterisk + pattern.substring(beforeIndex, afterIndex) + afterAsterisk;
                } else {
                    return "*";
                }
            }

            if (tempResult.length() > result.length()) {
                result = tempResult;
            }
        }

        return result;
    }

    private static List<Integer> getAsteriskPositions(String pattern) {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == '*') {
                positions.add(i);
            }
        }
        return positions;
    }
}