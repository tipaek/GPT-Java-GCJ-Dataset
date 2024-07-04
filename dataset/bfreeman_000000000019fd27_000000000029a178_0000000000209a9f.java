import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public final static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int numCases = in.nextInt();
        in.nextLine();
        for (int i = 0; i < numCases; i++) {
            runCase(i + 1);
        }
    }

    public static void runCase(int caseNum) {
        String s = in.nextLine();
        ArrayList<Character> chars = new ArrayList<>(s.length() * 10);
        for (char c : s.toCharArray()) {
            chars.add(c);
        }
        addAllParens(chars);
        while (removeParens(chars)) {}
        printCaseResult(caseNum, formatResult(chars));
    }

    public static void addAllParens(ArrayList<Character> chars) {
        int currVal = -1;
        for (int i = 0; i < chars.size(); i += 1 + 2 * currVal) {
            currVal = Integer.parseInt(chars.get(i).toString());
            addParens(chars, i);
        }
    }

    public static void addParens(ArrayList<Character> chars, int idx) {
        int val = Integer.parseInt(chars.get(idx).toString());
        for (int i = idx; i < idx + val; i++) {
            chars.add(i + 1, ')');
        }
        for (int i = 0; i < val; i++) {
            chars.add(idx, '(');
        }
    }

    public static boolean removeParens(ArrayList<Character> chars) {
        boolean ret = false;
        for (int i = chars.size() - 3; i >= 3; i--) {
            if (chars.get(i) == '(' && chars.get(i - 1) == ')') {
                ret = true;
                chars.remove(i);
                chars.remove(i - 1);
            }
        }
        return ret;
    }

    public static String formatResult(ArrayList<Character> chars) {
        StringBuilder str = new StringBuilder();
        for (Character c : chars) {
            str.append(c);
        }
        return str.toString();
    }

    public static String[] splitByZero(String s) {
        ArrayList<String> split = new ArrayList<>();
        int lastZero = -1;
        int idx = 0;
        while (idx < s.length()) {
            if (s.charAt(idx) == '0') {
                if (lastZero != idx - 1) {
                    split.add(s.substring(lastZero + 1, idx));
                }
                split.add("0");
                lastZero = idx;
            }
            idx++;
        }
        if (lastZero != s.length() - 1) {
            split.add(s.substring(lastZero + 1, idx));
        }
        String[] ret = new String[split.size()];
        return split.toArray(ret);
    }

    public static void printCaseResult(int caseNum, String result) {
        System.out.printf("Case #%d: %s%n", caseNum, result);
    }
}
