

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author satish.thulva. Generated on 11/04/20
 **/
public class Solution {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numTests = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numTests; i += 1) {
                parseAndSolveTestCase(i + 1, reader);
            }
        }
    }

    private static void parseAndSolveTestCase(int testNumber, BufferedReader reader) throws IOException {
        int numPatterns = Integer.parseInt(reader.readLine());
        String[] patterns = new String[numPatterns];
        for (int i = 0; i < numPatterns; i += 1) {
            patterns[i] = reader.readLine();
            if (patterns[i].equals("*")) {
                numPatterns -= 1;
                i -= 1;
            }
        }

        if (numPatterns == 0) {
            System.out.println("Case #" + testNumber + ": *");
        } else {
            String[][] splitPatterns = new String[patterns.length][];
            for (int i = 0; i < patterns.length; i += 1) {
                splitPatterns[i] = patterns[i].split("\\*", -1);
            }
            String[] startPatterns = new String[numPatterns];
            for (int i = 0; i < numPatterns; i += 1) {
                startPatterns[i] = splitPatterns[i][0];
            }
            String starting = getMatchingForPrefixMatch(startPatterns);
            if (starting.equals("*")) {
                System.out.println("Case #" + testNumber + ": *");
            } else {
                String[] endingPatterns = new String[numPatterns];
                for (int i = 0; i < numPatterns; i += 1) {
                    endingPatterns[i] = splitPatterns[i][splitPatterns[i].length - 1];
                }
                String ending = getMatchingForSuffixMatch(endingPatterns);
                if (ending.equals("*")) {
                    System.out.println("Case #" + testNumber + ": *");
                } else {
                    System.out.println("Case #" + testNumber + ": " + starting + ending);
                }
            }
        }
    }

    private static String getMatchingForPrefixMatch(String[] patterns) {
        Arrays.sort(patterns, Comparator.comparingInt(String::length));
        String longest = patterns[patterns.length - 1];
        boolean allPatternsMatch = true;
        for (int i = 0; i < patterns.length - 1; i += 1) {
            if (!patterns[i].isEmpty() && !longest.startsWith(patterns[i])) {
                allPatternsMatch = false;
                break;
            }
        }
        if (allPatternsMatch) {
            return longest;
        } else {
            return "*";
        }
    }

    private static String getMatchingForSuffixMatch(String[] patterns) {
        Arrays.sort(patterns, Comparator.comparingInt(String::length));
        String longest = patterns[patterns.length - 1];
        boolean allPatternsMatch = true;
        for (int i = 0; i < patterns.length - 1; i += 1) {
            if (!patterns[i].isEmpty() && !longest.endsWith(patterns[i])) {
                allPatternsMatch = false;
                break;
            }
        }
        if (allPatternsMatch) {
            return longest;
        } else {
            return "*";
        }
    }

}
