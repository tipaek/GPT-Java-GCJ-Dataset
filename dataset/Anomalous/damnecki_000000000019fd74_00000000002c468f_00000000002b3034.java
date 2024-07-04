import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.*;

public class PatternMatching {

    private static final Scanner IN = new Scanner(new BufferedInputStream(System.in));
    private static final PrintStream OUT = System.out;

    public static void main(String[] args) {
        int T = IN.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = IN.nextInt();
            List<List<String>> patterns = new ArrayList<>();
            String result = "";

            for (int i = 0; i < N; i++) {
                String pattern = IN.next();
                String[] parts = pattern.split("\\*");

                for (int j = 0; j < parts.length; j++) {
                    if (patterns.size() == j) {
                        patterns.add(new ArrayList<>());
                    }
                    patterns.get(j).add(parts[j]);
                }

                if (pattern.endsWith("*") && patterns.size() == parts.length) {
                    patterns.add(new ArrayList<>());
                    patterns.get(patterns.size() - 1).add("");
                }
            }

            for (List<String> partList : patterns) {
                partList.sort(new LengthComparator());
            }

            if (patterns.size() == 2) {
                if (patterns.get(0).get(0).isEmpty()) {
                    result = checkSuffixMatch(patterns.get(1));
                } else {
                    result = checkPrefixMatch(patterns.get(0));
                    if (!result.equals("*")) {
                        String suffixResult = checkSuffixMatch(patterns.get(1));
                        if (!suffixResult.equals("*")) {
                            result += suffixResult;
                        } else {
                            result = "*";
                        }
                    }
                }
            } else {
                result = "*";
            }

            OUT.println("Case #" + t + ": " + result);
        }
    }

    private static String checkPrefixMatch(List<String> prefixes) {
        String prefix = prefixes.get(0);
        for (int i = 1; i < prefixes.size(); i++) {
            if (!prefix.startsWith(prefixes.get(i))) {
                return "*";
            }
        }
        return prefix;
    }

    private static String checkSuffixMatch(List<String> suffixes) {
        String suffix = suffixes.get(0);
        for (int i = 1; i < suffixes.size(); i++) {
            if (!suffix.endsWith(suffixes.get(i))) {
                return "*";
            }
        }
        return suffix;
    }

    static class LengthComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o2.length(), o1.length());
        }
    }
}