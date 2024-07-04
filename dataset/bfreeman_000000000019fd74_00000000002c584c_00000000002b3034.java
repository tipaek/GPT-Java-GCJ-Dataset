import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public final static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int numCases = in.nextInt();
        int maxLen = 10000;
        for (int i = 0; i < numCases; i++) {
            int numPatterns = in.nextInt();
            ArrayList<String> patterns = new ArrayList<>(numPatterns);
            in.nextLine();
            for (int j = 0; j < numPatterns; j++) {
                patterns.add(in.nextLine());
            }
            runCase(i + 1, patterns, maxLen);
        }
        //test("*AA, *A, A*AB, A*B");
    }

    public static void test() {
        Random rand = new Random();
        int numTests = 10;
        int maxLen = 10000;
        for (int i = 0; i < numTests; i++) {
            int numPatterns = rand.nextInt(5) + 2;
            ArrayList<String> patterns = new ArrayList<>(numPatterns);
            for (int j = 0; j < numPatterns; j++) {
                StringBuilder sb = new StringBuilder(randomPattern(rand));
                sb.insert(rand.nextInt(sb.length()), "*");
                patterns.add(sb.toString());
            }
            System.out.println("Unrefined:" + patterns.toString());
            runCase(i + 1, patterns, maxLen);
        }
    }

    public static void test(String str) {
        String[] strs = str.split(", ");
        int maxLen = 10000;
        ArrayList<String> patterns = new ArrayList<>();
        for (String s : strs) {
            patterns.add(s);
        }
        System.out.println("Unrefined:" + patterns.toString());
        runCase(1, patterns, maxLen);
    }

    public static String randomPattern(Random rand) {
        String alphabet = "AB";
        String ret = "";
        int len = rand.nextInt(4) + 1;
        for (int i = 0; i < len; i++) {
            ret += alphabet.charAt(rand.nextInt(alphabet.length()));
        }
        return ret;
    }

    public static void runCase(int caseNum, ArrayList<String> patterns, int maxLen) {
        refinePatterns(patterns);
        //System.out.println("Refined: " + patterns.toString());
        boolean seenStarting = false;
        boolean seenEnding = false;
        StringBuilder ret = new StringBuilder();
        for (String pattern : patterns) {
            if (pattern.charAt(0) != '*') {
                if (seenStarting) {
                    printCaseResult(caseNum, "*");
                    return;
                }
            }
            if (pattern.charAt(pattern.length() - 1) != '*') {
                if (seenEnding) {
                    printCaseResult(caseNum, "*");
                    return;
                }
            }
            if (pattern.charAt(0) != '*') {
                seenStarting = true;
                ret.insert(0, pattern.replace("*", ""));
            } else if (pattern.charAt(pattern.length() - 1) != '*') {
                seenEnding = true;
                ret.append(pattern.replace("*", ""));
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
        //System.out.println(container + " contains " + containee + "?");
       /* int firstNonAsterContainee = -1;
        while (++firstNonAsterContainee < containee.length() && containee.charAt(firstNonAsterContainee) == '*') {}
        int firstNonAsterContainer = -1;
        while (++firstNonAsterContainer < container.length() && container.charAt(firstNonAsterContainer) == '*') {}
        int idx = container.indexOf(containee.charAt(firstNonAsterContainee));
        if (idx != firstNonAsterContainer) return false;
        int matched = firstNonAsterContainee;
        while (matched < containee.length() && idx < container.length()) {
            if (containee.charAt(matched) == '*') {
                matched++;
            } else {
                if (container.charAt(idx) == containee.charAt(matched)) {
                    matched++;
                } else if (containee.charAt(matched - 1) != '*') {
                    return false;
                }
                idx++;
            }
        }
        return matched == containee.length() && idx == container.length();*/
      /*  String[] parts = containee.split("\\*");
        int last = -1;
        for (String part : parts) {
            int idx = container.indexOf(part);
            if (idx > last) {
                last = idx;
            } else {
                return false;
            }
        }
        return containee.charAt(containee.length() - 1) == '*' || last + parts[parts.length - 1].length() == container.length();*/


      // if container matches containee, return true

        Pattern p = Pattern.compile(containee.replace("*", ".*"));
        Matcher m = p.matcher(container);
        return m.find() && m.group(0).equals(container);
    }

    public static void printCaseResult(int caseNum, String result) {
        System.out.printf("Case #%d: %s%n", caseNum, result);
    }
}
