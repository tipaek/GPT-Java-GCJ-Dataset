import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= numOfCases; caseIndex++) {
            List<String> patterns = new ArrayList<>();
            int patternCount = scanner.nextInt();
            for (int j = 0; j < patternCount; j++) {
                patterns.add(scanner.next());
            }

            System.out.println("Case #" + caseIndex + ": " + findMatchingPattern(patterns));
        }
    }

    private static String findMatchingPattern(List<String> patterns) {
        patterns.sort(Comparator.comparingInt(String::length).reversed());

        String longestPattern = patterns.get(0);
        for (String pattern : patterns) {
            if (!longestPattern.matches(pattern.replace("*", "[A-Z*]*"))) {
                return "*";
            }
        }

        return longestPattern.replace("*", "");
    }
}