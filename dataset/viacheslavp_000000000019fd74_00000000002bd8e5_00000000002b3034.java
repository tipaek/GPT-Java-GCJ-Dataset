import java.util.Scanner;

public class Solution {

    private static class StringSegments {
        String prefix;
        String suffix;
        String between;

        public StringSegments(String s) {
            int astIndex = s.indexOf('*');
            prefix = astIndex >= 0 ? s.substring(0, astIndex) : s;

            s = new StringBuilder(s.substring(prefix.length())).reverse().toString();
            astIndex = s.indexOf('*');
            suffix = new StringBuilder(astIndex >= 0 ? s.substring(0, astIndex) : s).reverse().toString();

            s = new StringBuilder(s.substring(astIndex)).reverse().toString();
            StringBuilder betweenBuilder = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c != '*') betweenBuilder.append(c);
            }
            between = betweenBuilder.toString();
        }
    }

    static String joinPrefixes(StringSegments[] sgs) {
        int maxLength = 0;
        for (StringSegments sg : sgs) {
            maxLength = Math.max(sg.prefix.length(), maxLength);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < maxLength; ++i) {
            char ch = 0;
            for (StringSegments sg : sgs) {
                if (sg.prefix.length() == i) continue;
                if (ch == 0 || ch == sg.prefix.charAt(i)) ch = sg.prefix.charAt(i);
                else return null;
            }
            result.append(ch);
        }

        return result.toString();
    }

    static String joinSuffixes(StringSegments[] sgs) {
        int maxLength = 0;
        for (StringSegments sg : sgs) {
            maxLength = Math.max(sg.suffix.length(), maxLength);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < maxLength; ++i) {
            char ch = 0;
            for (StringSegments sg : sgs) {
                if (sg.suffix.length() - i - 1 < 0) continue;
                if (ch == 0 || ch == sg.suffix.charAt(sg.suffix.length() - i - 1)) ch = sg.suffix.charAt(sg.suffix.length() - i - 1);
                else return null;
            }
            result.append(ch);
        }

        return result.reverse().toString();
    }

    static String solve(String[] p) {
        StringSegments[] sg = new StringSegments[p.length];
        for (int i = 0; i < p.length; ++i) {
            sg[i] = new StringSegments(p[i]);
        }
        String joinedPrefixes = joinPrefixes(sg);
        String joinedSuffixes = joinSuffixes(sg);
        if (joinedSuffixes == null || joinedPrefixes == null) return null;

        StringBuilder result = new StringBuilder();
        result.append(joinedPrefixes);
        for (StringSegments segment : sg) {
            result.append(segment.between);
        }
        result.append(joinedSuffixes);

        return result.toString();
    }

    public static void main(String[] params) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < t; ++i) {
            int n = Integer.valueOf(scanner.nextLine());
            String[] patterns = new String[n];
            for (int j = 0; j < n; ++j) {
                patterns[j] = scanner.nextLine();
            }
            String solution = solve(patterns);
            System.out.println(String.format("Test #%d: %s", i + 1, solution == null ? "*" : solution));
        }
    }
}
