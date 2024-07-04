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
            List<PatternInfo> patterns = new ArrayList<>();
            int maxFirstAsteriskPos = -1;
            boolean hasMultipleAsterisks = false;

            for (int i = 0; i < patternCount; i++) {
                String pattern = scanner.next();
                int firstAsteriskPos = pattern.indexOf('*');
                int asteriskCount = countAsterisks(pattern);
                patterns.add(new PatternInfo(pattern, asteriskCount, firstAsteriskPos));

                if (hasMultipleAsterisks || asteriskCount > 1) {
                    hasMultipleAsterisks = true;
                }
                if (firstAsteriskPos > maxFirstAsteriskPos) {
                    maxFirstAsteriskPos = firstAsteriskPos;
                }
            }

            StringBuilder result = new StringBuilder();
            if (hasMultipleAsterisks) {
                // Handle multiple asterisks case
            } else {
                if (maxFirstAsteriskPos == 0) {
                    List<PatternInfo> sortedPatterns = patterns.stream()
                            .sorted(Comparator.comparing(PatternInfo::getLength).reversed())
                            .collect(Collectors.toList());
                    String basePattern = sortedPatterns.get(0).getPattern().replace("*", "");
                    for (int i = 1; i < patternCount; i++) {
                        if (!isSubstring(basePattern, sortedPatterns.get(i).getPattern().replace("*", ""))) {
                            result.append("*");
                            break;
                        }
                    }
                    if (!result.toString().equals("*")) {
                        result.append(basePattern);
                    }
                } else {
                    List<PatternInfo> sortedPatterns = patterns.stream()
                            .sorted(Comparator.comparing(PatternInfo::getFirstAsteriskPos).reversed())
                            .collect(Collectors.toList());
                    String[] splitPattern = sortedPatterns.get(0).getPattern().split("\\*");
                    String prefix = splitPattern[0];
                    String suffix = splitPattern.length > 1 ? splitPattern[1] : "";

                    for (int i = 1; i < patternCount; i++) {
                        String[] tempSplitPattern = sortedPatterns.get(i).getPattern().split("\\*");
                        String tempPrefix = tempSplitPattern[0];
                        String tempSuffix = tempSplitPattern.length > 1 ? tempSplitPattern[1] : "";

                        if (sortedPatterns.get(i).getFirstAsteriskPos() <= prefix.length() && !isSubstring(prefix, tempPrefix)) {
                            result.append("*");
                            break;
                        }
                        if (suffix.length() > tempSuffix.length() && !isSubstring(tempSuffix, suffix)) {
                            result.append("*");
                            break;
                        } else {
                            suffix = tempSuffix;
                        }
                    }
                    if (!result.toString().equals("*")) {
                        result.append(prefix.replace("*", ""));
                        result.append(suffix.replace("*", ""));
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + (result.toString().isEmpty() ? "*" : result.toString()));
        }
        scanner.close();
    }

    public static boolean isSubstring(String str1, String str2) {
        return str1.contains(str2);
    }

    public static int countAsterisks(String pattern) {
        return (int) pattern.chars().filter(ch -> ch == '*').count();
    }
}

class PatternInfo {
    private final String pattern;
    private final int asteriskCount;
    private final int firstAsteriskPos;

    public PatternInfo(String pattern, int asteriskCount, int firstAsteriskPos) {
        this.pattern = pattern;
        this.asteriskCount = asteriskCount;
        this.firstAsteriskPos = firstAsteriskPos;
    }

    public String getPattern() {
        return pattern;
    }

    public int getAsteriskCount() {
        return asteriskCount;
    }

    public int getFirstAsteriskPos() {
        return firstAsteriskPos;
    }

    public int getLength() {
        return pattern.length();
    }

    @Override
    public String toString() {
        return "PatternInfo{" +
                "pattern='" + pattern + '\'' +
                ", asteriskCount=" + asteriskCount +
                ", firstAsteriskPos=" + firstAsteriskPos +
                '}';
    }
}