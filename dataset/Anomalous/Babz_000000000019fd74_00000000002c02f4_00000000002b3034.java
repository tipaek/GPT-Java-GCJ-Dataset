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
            int maxFirstAsteriskIndex = -1;
            boolean hasMultipleAsterisks = false;

            for (int i = 0; i < patternCount; i++) {
                String patternStr = scanner.next();
                int firstAsteriskIndex = patternStr.indexOf("*");
                int asteriskCount = countAsterisks(patternStr);
                Pattern pattern = new Pattern(patternStr, asteriskCount, firstAsteriskIndex);
                patterns.add(pattern);

                if (hasMultipleAsterisks || asteriskCount > 1) {
                    hasMultipleAsterisks = true;
                }
                if (firstAsteriskIndex > maxFirstAsteriskIndex) {
                    maxFirstAsteriskIndex = firstAsteriskIndex;
                }
            }

            StringBuilder result = new StringBuilder();
            if (hasMultipleAsterisks) {
                // Handle case with multiple asterisks
            } else {
                if (maxFirstAsteriskIndex == 0) {
                    List<Pattern> sortedPatterns = patterns.stream()
                            .sorted(Comparator.comparing(Pattern::getLength).reversed())
                            .collect(Collectors.toList());
                    String basePattern = sortedPatterns.get(0).getName().replace("*", "");

                    for (int i = 1; i < patternCount; i++) {
                        if (!isSubstring(basePattern, sortedPatterns.get(i).getName().replace("*", ""))) {
                            result.append("*");
                            break;
                        }
                    }
                    if (result.length() == 0) {
                        result.append(basePattern);
                    }
                } else {
                    List<Pattern> sortedPatterns = patterns.stream()
                            .sorted(Comparator.comparing(Pattern::getFirstAsteriskIndex).reversed())
                            .collect(Collectors.toList());
                    String[] baseParts = sortedPatterns.get(0).getName().split("\\*");
                    String prefix = baseParts[0];
                    String suffix = baseParts.length > 1 ? baseParts[1] : "";

                    for (int i = 1; i < patternCount; i++) {
                        String[] parts = sortedPatterns.get(i).getName().split("\\*");
                        String currentPrefix = parts[0];
                        String currentSuffix = parts.length > 1 ? parts[1] : "";

                        if (sortedPatterns.get(i).getFirstAsteriskIndex() <= prefix.length() && !isSubstring(prefix, currentPrefix)) {
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
                    if (result.length() == 0) {
                        result.append(prefix.replace("*", "")).append(suffix.replace("*", ""));
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
        scanner.close();
    }

    public static boolean isSubstring(String str1, String str2) {
        return str1.contains(str2);
    }

    public static int countAsterisks(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '*') {
                count++;
            }
        }
        return count;
    }
}

class Pattern {
    private final String name;
    private final int asteriskCount;
    private final int firstAsteriskIndex;

    public Pattern(String name, int asteriskCount, int firstAsteriskIndex) {
        this.name = name;
        this.asteriskCount = asteriskCount;
        this.firstAsteriskIndex = firstAsteriskIndex;
    }

    public String getName() {
        return name;
    }

    public int getAsteriskCount() {
        return asteriskCount;
    }

    public int getFirstAsteriskIndex() {
        return firstAsteriskIndex;
    }

    public int getLength() {
        return name.length();
    }

    @Override
    public String toString() {
        return "Pattern{" +
                "name='" + name + '\'' +
                ", asteriskCount=" + asteriskCount +
                ", firstAsteriskIndex=" + firstAsteriskIndex +
                '}';
    }
}