import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Solution {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int numCases = in.nextInt();
        final int maxLen = 10000;
        for (int i = 0; i < numCases; i++) {
            int numPatterns = in.nextInt();
            ArrayList<String> patterns = new ArrayList<>(numPatterns);
            in.nextLine();
            for (int j = 0; j < numPatterns; j++) {
                patterns.add(in.nextLine());
            }
            processCase(i + 1, patterns, maxLen);
        }
    }

    private static void processCase(int caseNum, ArrayList<String> patterns, int maxLen) {
        refinePatterns(patterns);
        boolean seenStarting = false;
        boolean seenEnding = false;
        StringBuilder result = new StringBuilder();
        for (String pattern : patterns) {
            if (pattern.charAt(0) != '*') {
                if (seenStarting) {
                    printCaseResult(caseNum, "*");
                    return;
                }
                seenStarting = true;
                result.insert(0, pattern.replace("*", ""));
            } else if (pattern.charAt(pattern.length() - 1) != '*') {
                if (seenEnding) {
                    printCaseResult(caseNum, "*");
                    return;
                }
                seenEnding = true;
                result.append(pattern.replace("*", ""));
            } else {
                result.append(pattern.replace("*", ""));
            }
            if (result.length() > maxLen) {
                printCaseResult(caseNum, "*");
                return;
            }
        }
        printCaseResult(caseNum, result.toString());
    }

    private static void refinePatterns(ArrayList<String> patterns) {
        for (int i = 0; i < patterns.size(); i++) {
            for (int j = 0; j < patterns.size(); j++) {
                if (i != j && containsPattern(patterns.get(i), patterns.get(j))) {
                    patterns.remove(j);
                    j--;
                    if (j < i) {
                        i--;
                    }
                }
            }
        }
    }

    private static boolean containsPattern(String container, String containee) {
        String[] parts = containee.split("\\*");
        int lastIndex = -1;
        for (String part : parts) {
            int index = container.indexOf(part);
            if (index > lastIndex) {
                lastIndex = index;
            } else {
                return false;
            }
        }
        return true;
    }

    private static void printCaseResult(int caseNum, String result) {
        System.out.printf("Case #%d: %s%n", caseNum, result);
    }

    // Uncomment to run tests
    /*
    private static void test() {
        Random rand = new Random(100);
        int numTests = 10;
        int maxLen = 10000;
        for (int i = 0; i < numTests; i++) {
            int numPatterns = rand.nextInt(5) + 2;
            ArrayList<String> patterns = new ArrayList<>(numPatterns);
            for (int j = 0; j < numPatterns; j++) {
                patterns.add(generateRandomPattern(rand));
            }
            System.out.println(patterns);
            processCase(i + 1, patterns, maxLen);
        }
    }

    private static String generateRandomPattern(Random rand) {
        String alphabet = "*****AB";
        StringBuilder pattern = new StringBuilder();
        int len = rand.nextInt(5) + 2;
        for (int i = 0; i < len; i++) {
            pattern.append(alphabet.charAt(rand.nextInt(alphabet.length())));
        }
        return pattern.toString();
    }
    */
}