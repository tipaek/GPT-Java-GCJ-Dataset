import java.util.*;

public class Solution {

    static class Test {
        public static void main(String[] args) {
            solve(new Scanner(Solution.class.getResourceAsStream("input.txt")));
        }
    }

    public static void main(String[] args) {
        solve(new Scanner(System.in));
    }

    private static void solve(Scanner scanner) {
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            List<String> patterns = new ArrayList<>(N);
            for (int i = 0; i < N; i++) {
                String pattern = scanner.next();
                patterns.add(pattern);
            }

            System.out.printf("Case #%d: %s\n", t + 1, solve(patterns));
        }
    }

    private static String solve(List<String> patterns) {
        StringBuilder middleSb = new StringBuilder();
        List<String> prefixes = new ArrayList<>(patterns.size());
        List<String> suffixes = new ArrayList<>(patterns.size());

        for (String pattern : patterns) {
            int first = pattern.indexOf("*");
            int last = pattern.lastIndexOf("*");

            prefixes.add(pattern.substring(0, first));
            String middle = pattern.substring(first, last + 1);
            suffixes.add(pattern.substring(last + 1));

            middleSb.append(middle.replaceAll("\\*", ""));
        }

//        System.out.println("prefixes = " + prefixes);
//        System.out.println("suffixes = " + suffixes);

        String longerSuffix = suffixes.stream().max(Comparator.comparingInt(String::length)).get();

        if (suffixes.stream().anyMatch(suffix -> !longerSuffix.endsWith(suffix))) {
            return "*";
        }

        String longerPrefix = prefixes.stream().max(Comparator.comparingInt(String::length)).get();

        if (prefixes.stream().anyMatch(prefix -> !longerPrefix.startsWith(prefix))) {
            return "*";
        }

        return longerPrefix + middleSb.toString() + longerSuffix;
    }

}
