import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int numCases = in.nextInt();
        for (int i = 0; i < numCases; i++) {
            int maxLen = 10000;
            int numPatterns = in.nextInt();
            ArrayList<String> patterns = new ArrayList<>(numPatterns);
            in.nextLine();
            for (int j = 0; j < numPatterns; j++) {
                patterns.add(in.nextLine());
            }
            processCase(i + 1, patterns, maxLen);
        }
    }

    public static void processCase(int caseNum, ArrayList<String> patterns, int maxLen) {
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
                result.insert(0, pattern.substring(0, pattern.length() - 1));
            } else if (pattern.charAt(pattern.length() - 1) != '*') {
                if (seenEnding) {
                    printCaseResult(caseNum, "*");
                    return;
                }
                seenEnding = true;
                result.append(pattern.substring(1));
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

    public static void refinePatterns(ArrayList<String> patterns) {
        for (int i = 0; i < patterns.size(); i++) {
            for (int j = 0; j < patterns.size(); j++) {
                if (i != j && specContains(patterns.get(i), patterns.get(j))) {
                    patterns.remove(j);
                    j--;
                    if (j < i) {
                        i--;
                    }
                }
            }
        }
    }

    public static boolean specContains(String container, String containee) {
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

    public static void printCaseResult(int caseNum, String result) {
        System.out.printf("Case #%d: %s%n", caseNum, result);
    }
}