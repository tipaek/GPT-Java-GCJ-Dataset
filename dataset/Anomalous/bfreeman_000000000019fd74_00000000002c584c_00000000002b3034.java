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
        for (int i = 0; i < numCases; i++) {
            int numPatterns = in.nextInt();
            ArrayList<String> patterns = new ArrayList<>(numPatterns);
            in.nextLine();
            for (int j = 0; j < numPatterns; j++) {
                patterns.add(in.nextLine());
            }
            runCase(i + 1, patterns);
        }
    }

    public static void test() {
        Random rand = new Random();
        int numTests = 10;
        for (int i = 0; i < numTests; i++) {
            int numPatterns = rand.nextInt(5) + 2;
            ArrayList<String> patterns = new ArrayList<>(numPatterns);
            for (int j = 0; j < numPatterns; j++) {
                StringBuilder sb = new StringBuilder(randomPattern(rand));
                sb.insert(rand.nextInt(sb.length()), "*");
                patterns.add(sb.toString());
            }
            System.out.println("Unrefined:" + patterns);
            runCase(i + 1, patterns);
        }
    }

    public static void test(String str) {
        String[] strs = str.split(", ");
        ArrayList<String> patterns = new ArrayList<>();
        for (String s : strs) {
            patterns.add(s);
        }
        System.out.println("Unrefined:" + patterns);
        runCase(1, patterns);
    }

    private static String randomPattern(Random rand) {
        String alphabet = "AB";
        StringBuilder ret = new StringBuilder();
        int len = rand.nextInt(4) + 1;
        for (int i = 0; i < len; i++) {
            ret.append(alphabet.charAt(rand.nextInt(alphabet.length())));
        }
        return ret.toString();
    }

    private static void runCase(int caseNum, ArrayList<String> patterns) {
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
            
            if (result.length() > MAX_LEN) {
                printCaseResult(caseNum, "*");
                return;
            }
        }
        printCaseResult(caseNum, result.toString());
    }

    private static void refinePatterns(ArrayList<String> patterns) {
        for (int i = 0; i < patterns.size(); i++) {
            for (int j = 0; j < patterns.size(); j++) {
                if (i != j && specContains(patterns.get(i), patterns.get(j))) {
                    patterns.remove(j);
                    j--;
                    if (j < i) i--;
                }
            }
        }
    }

    private static boolean specContains(String container, String containee) {
        Pattern p = Pattern.compile(containee.replace("*", ".*"));
        Matcher m = p.matcher(container);
        return m.find() && m.group(0).equals(container);
    }

    private static void printCaseResult(int caseNum, String result) {
        System.out.printf("Case #%d: %s%n", caseNum, result);
    }
}