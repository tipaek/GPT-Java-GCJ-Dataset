import java.io.InputStream;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.execute(System.in);
        System.out.print(result);
    }

    String execute(InputStream is) {
        StringBuilder output = new StringBuilder();
        try (Scanner scanner = new Scanner(is)) {
            final int testCases = scanner.nextInt();
            scanner.nextLine();

            for (int t = 1; t <= testCases; t++) {
                int numPatterns = scanner.nextInt();
                scanner.nextLine();
                String[] patterns = new String[numPatterns];

                for (int i = 0; i < numPatterns; i++) {
                    patterns[i] = scanner.nextLine();
                }

                String result = processPatterns(patterns);
                output.append("Case #").append(t).append(": ").append(result).append(System.lineSeparator());
            }
        }
        return output.toString();
    }

    String processPatterns(String[] patterns) {
        int numPatterns = patterns.length;

        // Replace multiple asterisks with a single asterisk
        for (int i = 0; i < numPatterns; i++) {
            patterns[i] = patterns[i].replaceAll("\\*\\*+", "*");
        }

        // Parse parts
        int maxParts = 0;
        String[][] splitPatterns = new String[numPatterns][];
        for (int i = 0; i < numPatterns; i++) {
            splitPatterns[i] = patterns[i].split("\\*", -1);
            maxParts = Math.max(maxParts, splitPatterns[i].length);
        }

        String prefix = null;
        String suffix = null;
        for (String[] splitPattern : splitPatterns) {
            if (prefix == null) {
                prefix = splitPattern[0];
            } else {
                if (prefix.startsWith(splitPattern[0])) {
                    // Prefix is already correct
                } else if (splitPattern[0].startsWith(prefix)) {
                    prefix = splitPattern[0];
                } else {
                    return "*";
                }
            }

            if (suffix == null) {
                suffix = splitPattern[1];
            } else {
                if (suffix.endsWith(splitPattern[1])) {
                    // Suffix is already correct
                } else if (splitPattern[1].endsWith(suffix)) {
                    suffix = splitPattern[1];
                } else {
                    return "*";
                }
            }
        }

        return prefix + suffix;
    }
}