import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int size = scanner.nextInt();
            List<String> patterns = new ArrayList<>();

            for (int j = 0; j < size; j++) {
                patterns.add(scanner.next());
            }

            if (containsNonAsteriskPrefix(patterns)) {
                System.out.println("Case #" + i + ": *");
            } else {
                sortPatternsByLength(patterns);
                if (arePatternsCompatible(patterns)) {
                    System.out.println("Case #" + i + ": " + patterns.get(patterns.size() - 1).substring(1));
                } else {
                    System.out.println("Case #" + i + ": *");
                }
            }
        }
    }

    private static boolean containsNonAsteriskPrefix(List<String> patterns) {
        for (String pattern : patterns) {
            if (pattern.charAt(0) != '*') {
                return true;
            }
        }
        return false;
    }

    private static void sortPatternsByLength(List<String> patterns) {
        patterns.sort((a, b) -> Integer.compare(a.length(), b.length()));
    }

    private static boolean arePatternsCompatible(List<String> patterns) {
        for (int j = patterns.size() - 1; j > 0; j--) {
            String currentPattern = patterns.get(j).substring(1);
            String previousPattern = patterns.get(j - 1).substring(1);

            if (!currentPattern.contains(previousPattern)) {
                return false;
            }
        }
        return true;
    }
}