import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int patternCount = scanner.nextInt();
            List<Pattern> patterns = new ArrayList<>();
            int maxFirstAsteriskPosition = -1;
            boolean hasMultipleAsterisks = false;

            for (int i = 0; i < patternCount; i++) {
                String pattern = scanner.next();
                int firstAsteriskPosition = pattern.indexOf('*');
                int asteriskCount = countAsterisks(pattern);
                patterns.add(new Pattern(pattern, asteriskCount, firstAsteriskPosition));

                if (hasMultipleAsterisks || asteriskCount > 1) {
                    hasMultipleAsterisks = true;
                }
                if (firstAsteriskPosition > maxFirstAsteriskPosition) {
                    maxFirstAsteriskPosition = firstAsteriskPosition;
                }
            }

            StringBuilder result = new StringBuilder();
            if (hasMultipleAsterisks) {
                // Additional logic for multiple asterisks can be implemented here
            } else {
                if (maxFirstAsteriskPosition == 0) {
                    List<Pattern> sortedPatterns = patterns.stream()
                            .sorted(Comparator.comparingInt(Pattern::getLength).reversed())
                            .collect(Collectors.toList());
                    String basePattern = sortedPatterns.get(0).getName().replace("*", "");
                    for (int i = 1; i < patternCount; i++) {
                        if (!isSubstring(basePattern, sortedPatterns.get(i).getName().replace("*", ""))) {
                            result.append("*");
                            break;
                        }
                    }
                    if (!result.toString().equals("*")) {
                        result.append(basePattern);
                    }

                } else {
                    List<Pattern> sortedPatterns = patterns.stream()
                            .sorted(Comparator.comparingInt(Pattern::getFirstAsteriskPosition).reversed())
                            .collect(Collectors.toList());
                    String[] baseParts = sortedPatterns.get(0).getName().split("\\*");
                    String prefix = baseParts[0];
                    String suffix = baseParts.length > 1 ? baseParts[1] : "";

                    for (int i = 1; i < patternCount; i++) {
                        String[] currentParts = sortedPatterns.get(i).getName().split("\\*");
                        String currentPrefix = currentParts[0];
                        String currentSuffix = currentParts.length > 1 ? currentParts[1] : "";

                        if (sortedPatterns.get(i).getFirstAsteriskPosition() <= prefix.length() && !isSubstring(prefix, currentPrefix)) {
                            result.append("*");
                            break;
                        }
                        if (suffix.length() > currentSuffix.length() && !isSubstring(currentSuffix, suffix)) {
                            result.append("*");
                            break;
                        } else {
                            suffix = currentSuffix;
                        }
                    }
                    if (!result.toString().equals("*")) {
                        result.append(prefix.replace("*", ""));
                        result.append(suffix.replace("*", ""));
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + (result.toString().trim().isEmpty() ? "*" : result.toString()));
        }
        scanner.close();
    }

    private static boolean isSubstring(String str1, String str2) {
        return str1.contains(str2);
    }

    private static int countAsterisks(String pattern) {
        int count = 0;
        for (char c : pattern.toCharArray()) {
            if (c == '*') {
                count++;
            }
        }
        return count;
    }

    private static class Pattern {
        private final String name;
        private final int asteriskCount;
        private final int firstAsteriskPosition;

        public Pattern(String name, int asteriskCount, int firstAsteriskPosition) {
            this.name = name;
            this.asteriskCount = asteriskCount;
            this.firstAsteriskPosition = firstAsteriskPosition;
        }

        public String getName() {
            return name;
        }

        public int getAsteriskCount() {
            return asteriskCount;
        }

        public int getFirstAsteriskPosition() {
            return firstAsteriskPosition;
        }

        public int getLength() {
            return name.length();
        }

        @Override
        public String toString() {
            return "Pattern{" +
                    "name='" + name + '\'' +
                    ", asteriskCount=" + asteriskCount +
                    ", firstAsteriskPosition=" + firstAsteriskPosition +
                    '}';
        }
    }
}