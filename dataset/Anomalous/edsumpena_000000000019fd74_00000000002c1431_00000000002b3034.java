import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            List<String> patterns = new ArrayList<>();
            int numPatterns = scanner.nextInt();

            for (int i = 0; i < numPatterns; i++) {
                String pattern = scanner.next();
                while (pattern.contains("**")) {
                    pattern = pattern.replace("**", "*");
                }
                patterns.add(pattern);
            }

            System.out.println("Case #" + caseNumber + ": " + findPossibleName(patterns));
        }
    }

    private static String findPossibleName(List<String> patterns) {
        String shortestPattern = patterns.stream().min(Comparator.comparingInt(String::length)).orElse("");
        int shortestLength = shortestPattern.length();

        System.out.println("Shortest: " + shortestPattern);

        patterns.remove(shortestPattern);
        List<Integer> shortestPatternAsterisks = getAsteriskPositions(shortestPattern);
        String result = "";

        for (String pattern : patterns) {
            List<Integer> patternAsterisks = getAsteriskPositions(pattern);
            StringBuilder tempResult = new StringBuilder();

            for (int j = 0; j < shortestPatternAsterisks.size(); j++) {
                String beforeAsterisk = shortestPattern.substring(0, shortestPatternAsterisks.get(j));
                String afterAsterisk = shortestPattern.substring(shortestPatternAsterisks.get(j) + 1);

                System.out.println(beforeAsterisk + ", " + afterAsterisk);

                if ((pattern.contains(beforeAsterisk) && !beforeAsterisk.isEmpty()) ||
                    (pattern.contains(afterAsterisk) && !afterAsterisk.isEmpty())) {
                    tempResult.append(beforeAsterisk)
                              .append(pattern, pattern.indexOf(beforeAsterisk) + beforeAsterisk.length(), 
                                      pattern.indexOf(afterAsterisk))
                              .append(afterAsterisk);
                } else {
                    return "*";
                }
            }

            if (tempResult.length() > result.length()) {
                result = tempResult.toString();
            }
        }

        return result;
    }

    private static List<Integer> getAsteriskPositions(String value) {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == '*') {
                positions.add(i);
            }
        }
        return positions;
    }
}