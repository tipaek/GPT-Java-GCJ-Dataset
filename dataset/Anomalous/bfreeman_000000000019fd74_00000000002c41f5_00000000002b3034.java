import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private static final Scanner in = new Scanner(System.in);
    private static final int MAX_LEN = 10000;

    public static void main(String[] args) {
        int numCases = in.nextInt();
        in.nextLine(); // Consume newline
        for (int i = 0; i < numCases; i++) {
            int numPatterns = in.nextInt();
            in.nextLine(); // Consume newline
            ArrayList<String> patterns = new ArrayList<>(numPatterns);
            for (int j = 0; j < numPatterns; j++) {
                patterns.add(in.nextLine());
            }
            handleCase(i + 1, patterns);
        }
    }

    private static void handleCase(int caseNum, ArrayList<String> patterns) {
        refinePatterns(patterns);
        boolean seenStarting = false;
        boolean seenEnding = false;
        StringBuilder result = new StringBuilder();

        for (String pattern : patterns) {
            if (pattern.charAt(0) != '*') {
                if (seenStarting) {
                    printResult(caseNum, "*");
                    return;
                }
                seenStarting = true;
                result.insert(0, pattern.replace("*", ""));
            } else if (pattern.charAt(pattern.length() - 1) != '*') {
                if (seenEnding) {
                    printResult(caseNum, "*");
                    return;
                }
                seenEnding = true;
                result.append(pattern.replace("*", ""));
            } else {
                result.append(pattern.replace("*", ""));
            }

            if (result.length() > MAX_LEN) {
                printResult(caseNum, "*");
                return;
            }
        }
        printResult(caseNum, result.toString());
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
        Pattern pattern = Pattern.compile(containee.replace("*", ".*"));
        Matcher matcher = pattern.matcher(container);
        return matcher.find() && matcher.group(0).equals(container);
    }

    private static void printResult(int caseNum, String result) {
        System.out.printf("Case #%d: %s%n", caseNum, result);
    }

    // Additional methods for testing
    public static void test() {
        Random rand = new Random();
        int numTests = 10;
        for (int i = 0; i < numTests; i++) {
            int numPatterns = rand.nextInt(5) + 2;
            ArrayList<String> patterns = new ArrayList<>(numPatterns);
            for (int j = 0; j < numPatterns; j++) {
                patterns.add("*" + generateRandomPattern(rand));
            }
            handleCase(i + 1, patterns);
        }
    }

    public static void test(String str) {
        String[] strs = str.split(", ");
        ArrayList<String> patterns = new ArrayList<>();
        for (String s : strs) {
            patterns.add(s);
        }
        handleCase(1, patterns);
    }

    private static String generateRandomPattern(Random rand) {
        String alphabet = "AB";
        StringBuilder pattern = new StringBuilder();
        int len = rand.nextInt(4) + 1;
        for (int i = 0; i < len; i++) {
            pattern.append(alphabet.charAt(rand.nextInt(alphabet.length())));
        }
        return pattern.toString();
    }
}