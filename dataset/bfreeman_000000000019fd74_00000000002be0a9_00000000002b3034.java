import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public final static Scanner in = new Scanner(System.in);

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
            runCase(i + 1, patterns, maxLen);
        }
    }

    public static void runCase(int caseNum, ArrayList<String> patterns, int maxLen) {
        refinePatterns(patterns);
        //System.out.println(patterns.toString());
        boolean seenStarting = false;
        boolean seenEnding = false;
        StringBuilder ret = new StringBuilder();
        for (String pattern : patterns) {
            if (pattern.charAt(0) != '*') {
                if (seenStarting) {
                    printCaseResult(caseNum, "*");
                    return;
                }
                seenStarting = true;
                ret.insert(0, pattern.substring(0, pattern.length() - 1));
            } else if (pattern.charAt(pattern.length() - 1) != '*') {
                if (seenEnding) {
                    printCaseResult(caseNum, "*");
                    return;
                }
                seenEnding = true;
                ret.append(pattern.substring(1));
            } else {
                ret.append(pattern.replace("*", ""));
            }
            if (ret.length() > maxLen) {
                printCaseResult(caseNum, "*");
                return;
            }
        }
        printCaseResult(caseNum, ret.toString());
    }

    public static void refinePatterns(ArrayList<String> patterns) {
        //boolean refined = true;

        for (int i = 0; i < patterns.size(); i++) {
            for (int j = 0; j < patterns.size(); j++) {
                if (i != j) {
                    if (specContains(patterns.get(i), patterns.get(j))) { // j redundant of i
                        //refined = false;
                        //System.out.println("Removed " + patterns.get(j));
                        patterns.remove(j);
                        j--;
                        if (j < i) {
                            i--;
                        }
                    }
                }
            }
        }

        //if (!refined) refinePatterns(patterns);
    }

    /*public static int removeRedundant(ArrayList<String> patterns, int idx) {
        boolean redundant = false;
        String base = patterns.get(idx);

        for (int i = idx + 1; i < patterns.size(); i++) {
            int currRedundant = checkIfRedundant(base, patterns.get(i));
            if (currRedundant == 0) {
                patterns.remove(idx);
                return 0;
            }
            if (currRedundant == 1) {
                patterns.remove(i);
                i--;
                redundant = true;
            }
        }

        return redundant ? 1 : -1;
    }

    // 0 == first redundant, 1 == second redundant
    public static int checkIfRedundant(String base, String check) {
        if (base.charAt(0) == '*' && check.charAt(0) == '*') {
            if (base.contains(check.substring(1))) {
                return 1;
            }
            if (check.contains(base.substring(1))) {
                return 0;
            }
        }
        if (base.charAt(base.length() - 1) == '*' && check.charAt(check.length() - 1) == '*') {
            if (base.contains(check.substring(0, check.length() - 1))) {
                return 1;
            }
            if (check.contains(base.substring(0, check.length() - 1))) {
                return 0;
            }
        }

    }*/

    public static boolean specContains(String container, String containee) {
        /*System.out.println(container + " contains " + containee + "?");
        int firstNonAster = -1;
        while (++firstNonAster < containee.length() && containee.charAt(firstNonAster) == '*') {}
        int idx = container.indexOf(containee.charAt(firstNonAster));
        if (idx == -1) return false;
        int matched = 1;
        while (matched < containee.length() && idx < container.length()) {
            if (containee.charAt(matched) == '*') {
                matched++;
            }
            if (container.charAt(idx) == containee.charAt(matched)) {
                matched++;
            } else if (containee.charAt(matched - 1) != '*') {
                break;
            }
            idx++;
        }
        return matched == containee.length();*/
        String[] parts = containee.split("\\*");
        int last = -1;
        for (String part : parts) {
            int idx = container.indexOf(part);
            if (idx > last) {
                last = idx;
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
