import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.*;

public class Solution {

    private static final Scanner SCANNER = new Scanner(new BufferedInputStream(System.in));
    private static final PrintStream OUTPUT = System.out;

    public static void main(String[] args) {
        int testCases = SCANNER.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int patternsCount = SCANNER.nextInt();
            List<List<String>> patterns = new ArrayList<>();

            for (int i = 0; i < patternsCount; i++) {
                String pattern = SCANNER.next();
                String[] splitPattern = pattern.split("\\*");

                for (int j = 0; j < splitPattern.length; j++) {
                    if (patterns.size() == j) {
                        patterns.add(new ArrayList<>());
                    }
                    patterns.get(j).add(splitPattern[j]);
                }

                if (pattern.endsWith("*") && patterns.size() == splitPattern.length) {
                    patterns.add(new ArrayList<>());
                    patterns.get(patterns.size() - 1).add("");
                }
            }

            for (List<String> part : patterns) {
                part.sort(new LengthComparator());
            }

            String result = buildResult(patterns);
            OUTPUT.println("Case #" + t + ": " + result);
        }
    }

    private static String buildResult(List<List<String>> patterns) {
        StringBuilder nameBuilder = new StringBuilder();

        String prefix = patterns.get(0).get(0);
        if (!prefix.isEmpty() && !allContains(patterns.get(0), prefix)) {
            return "*";
        }
        nameBuilder.append(prefix);

        for (int i = 1; i < patterns.size() - 1; i++) {
            String part = patterns.get(i).get(0);
            if (!allContains(patterns.get(i), part)) {
                return "*";
            }
            nameBuilder.append(part);
        }

        String suffix = patterns.get(patterns.size() - 1).get(0);
        if (!suffix.isEmpty() && !allContains(patterns.get(patterns.size() - 1), suffix)) {
            return "*";
        }
        nameBuilder.append(suffix);

        return nameBuilder.toString();
    }

    private static boolean allContains(List<String> list, String str) {
        for (String s : list) {
            if (!str.contains(s)) {
                return false;
            }
        }
        return true;
    }

    static class LengthComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o2.length(), o1.length());
        }
    }
}