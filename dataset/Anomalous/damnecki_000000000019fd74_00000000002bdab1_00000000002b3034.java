import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.*;

public class Solution {

    private static final Scanner SCANNER = new Scanner(new BufferedInputStream(System.in));
    private static final PrintStream OUTPUT = System.out;

    public static void main(String[] args) {
        int testCases = SCANNER.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = SCANNER.nextInt();
            List<List<String>> patterns = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String pattern = SCANNER.next();
                String[] splitPattern = pattern.split("\\*");

                for (int j = 0; j < splitPattern.length; j++) {
                    if (patterns.size() == j) {
                        patterns.add(new ArrayList<>());
                    }
                    patterns.get(j).add(splitPattern[j]);
                }

                if (pattern.endsWith("*")) {
                    if (patterns.size() == splitPattern.length) {
                        patterns.add(new ArrayList<>());
                    }
                    patterns.get(patterns.size() - 1).add("");
                }
            }

            for (List<String> patternList : patterns) {
                patternList.sort(new StringLengthComparator());
            }

            String result;
            if (patterns.size() == 2) {
                if (patterns.get(0).get(0).isEmpty()) {
                    result = patterns.get(1).get(0);
                } else {
                    result = "*";
                }
            } else {
                result = "*";
            }

            OUTPUT.println("Case #" + t + ": " + result);
        }
    }

    static class StringLengthComparator implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            return str2.length() - str1.length();
        }
    }
}