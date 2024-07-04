import java.util.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tc = 1; tc <= tests; tc++) {
            int N = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            List<String> patterns = new ArrayList<>(N);
            for (int j = 0; j < N; j++) {
                patterns.add(scanner.nextLine());
            }

            String answer = solve(patterns);
            System.out.println("Case #" + tc + ": " + answer);
        }

        scanner.close();
    }

    public static String solve(List<String> patterns) {
        String longestPattern = patterns.stream()
                                        .map(pattern -> pattern.replaceAll("\\*", ""))
                                        .max(Comparator.comparing(String::length))
                                        .orElse("");

        return patterns.stream()
                .map(pattern -> pattern.replaceAll("\\*", ""))
                .allMatch(longestPattern::contains) ? longestPattern : "*";
    }
}
