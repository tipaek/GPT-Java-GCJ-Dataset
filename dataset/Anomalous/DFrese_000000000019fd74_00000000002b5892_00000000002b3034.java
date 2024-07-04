import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCaseCount; i++) {
            processTestCase(i, scanner);
        }
    }

    private static void processTestCase(int caseNumber, Scanner scanner) {
        int patternCount = Integer.parseInt(scanner.nextLine());
        List<String> patterns = new ArrayList<>();

        for (int i = 0; i < patternCount; i++) {
            patterns.add(scanner.nextLine());
        }

        patterns.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s2.length(), s1.length());
            }
        });

        String longestPattern = patterns.get(0).replaceAll("\\*+", "");
        boolean allPatternsMatch = true;

        for (String pattern : patterns) {
            String regexPattern = pattern.replaceAll("\\*", ".*");
            if (!longestPattern.matches(regexPattern)) {
                allPatternsMatch = false;
                break;
            }
        }

        System.out.printf("Case #%d: %s%n", caseNumber, allPatternsMatch ? longestPattern : "*");
    }
}