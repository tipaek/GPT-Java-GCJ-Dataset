import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final int MAX_LENGTH = 100 * 100;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numCases = Integer.parseInt(sc.nextLine());
            for (int caseIndex = 1; caseIndex <= numCases; caseIndex++) {
                int numPatterns = Integer.parseInt(sc.nextLine());
                String[] patterns = new String[numPatterns];
                for (int i = 0; i < numPatterns; i++) {
                    patterns[i] = sc.nextLine();
                }
                System.out.println("Case #" + caseIndex + ": " + condensePatterns(patterns));
            }
        }
    }

    private static String condensePatterns(String[] patterns) {
        String basePattern = patterns[0];
        int starIndex = basePattern.indexOf('*');
        String prefix = basePattern.substring(0, starIndex);
        String suffix = basePattern.substring(starIndex + 1);

        for (int i = 1; i < patterns.length; i++) {
            String currentPattern = patterns[i];
            starIndex = currentPattern.indexOf('*');
            String currentPrefix = currentPattern.substring(0, starIndex);
            String currentSuffix = currentPattern.substring(starIndex + 1);

            if (currentPrefix.startsWith(prefix)) {
                prefix = currentPrefix;
            } else if (!prefix.startsWith(currentPrefix)) {
                return "*";
            }

            if (currentSuffix.endsWith(suffix)) {
                suffix = currentSuffix;
            } else if (!suffix.endsWith(currentSuffix)) {
                return "*";
            }
        }

        if (prefix.endsWith(suffix)) {
            return prefix;
        } else if (suffix.startsWith(prefix)) {
            return suffix;
        } else if (prefix.length() + suffix.length() < MAX_LENGTH) {
            return prefix + suffix;
        }
        return "*";
    }
}