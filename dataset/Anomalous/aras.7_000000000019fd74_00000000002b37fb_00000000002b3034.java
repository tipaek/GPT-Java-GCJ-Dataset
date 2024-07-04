import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numberOfTests = scanner.nextInt();
        for (int testIndex = 1; testIndex <= numberOfTests; testIndex++) {
            int numberOfPatterns = scanner.nextInt();

            List<String> patterns = new ArrayList<>();
            for (int i = 0; i < numberOfPatterns; i++) {
                patterns.add(scanner.next());
            }

            patterns.sort(Comparator.comparingInt(String::length));

            if (isSolvable(patterns)) {
                System.out.printf("Case #%d: %s\n", testIndex, patterns.get(patterns.size() - 1).substring(1));
            } else {
                System.out.printf("Case #%d: *\n", testIndex);
            }
        }
    }

    private static boolean isSolvable(List<String> patterns) {
        String longestPattern = patterns.get(patterns.size() - 1);
        for (int i = 0; i < patterns.size() - 1; i++) {
            String currentPattern = patterns.get(i).substring(1);
            String comparisonSubstring = longestPattern.substring(longestPattern.length() - currentPattern.length());

            if (!currentPattern.equals(comparisonSubstring)) {
                return false;
            }
        }
        return true;
    }
}