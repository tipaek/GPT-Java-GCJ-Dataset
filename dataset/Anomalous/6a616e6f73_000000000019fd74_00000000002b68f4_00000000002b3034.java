import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // scanner = example();
        // scanner = bigTest();

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            Input input = Input.fromScanner(scanner);
            printCase(t, solve(input));
        }
    }

    private static Scanner example() {
        return new Scanner("6\n" +
                "5\n" +
                "*CONUTS\n" +
                "*COCONUTS\n" +
                "*OCONUTS\n" +
                "*CONUTS\n" +
                "*S\n" +
                "2\n" +
                "*XZ\n" +
                "*XYZ\n" +
                "4\n" +
                "H*O\n" +
                "HELLO*\n" +
                "*HELLO\n" +
                "HE*\n" +
                "2\n" +
                "CO*DE\n" +
                "J*AM\n" +
                "2\n" +
                "**Q**\n" +
                "*A*\n" +
                "2\n" +
                "A*C*E\n" +
                "*B*D*");
    }

    private static Scanner bigTest() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int T = 100;
        int A = 255;
        int maxLength = 500;

        sb.append(T).append('\n');
        for (int t = 0; t < T; t++) {
            sb.append(A).append('\n');
            for (int i = 0; i < A; i++) {
                int length = 1 + random.nextInt(maxLength);
                // TODO: Generate random string of `length`
            }
        }
        return new Scanner(sb.toString());
    }

    private static class Input {
        private final List<String> patterns;

        public Input(List<String> patterns) {
            this.patterns = patterns;
        }

        public static Input fromScanner(Scanner scanner) {
            int N = scanner.nextInt();
            scanner.nextLine();
            List<String> patterns = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                patterns.add(scanner.nextLine());
            }
            return new Input(patterns);
        }
    }

    private static void printCase(int t, String s) {
        System.out.printf("Case #%d: %s%n", t + 1, s);
    }

    private static String solve(Input input) {
        List<List<String>> segments = input.patterns.stream()
                .map(p -> p.replaceAll("\\*\\*+", "*"))
                .map(p -> p.split("\\*", -1))
                .map(Arrays::asList)
                .collect(Collectors.toList());

        String prefix = longestCommonPrefix(segments);
        if (prefix == null) return "*";

        String suffix = longestCommonSuffix(segments);
        if (suffix == null) return "*";

        return new StringBuilder()
                .append(prefix)
                .append(middles(segments))
                .append(suffix)
                .toString();
    }

    private static String middles(List<List<String>> segments) {
        StringBuilder sb = new StringBuilder();
        segments.stream()
                .filter(s -> s.size() > 2)
                .forEach(s -> s.subList(1, s.size() - 1).forEach(sb::append));
        return sb.toString();
    }

    private static String longestCommonPrefix(List<List<String>> segments) {
        final String prefix = segments.stream()
                .map(s -> s.get(0))
                .reduce((s1, s2) -> s1.length() < s2.length() ? s2 : s1)
                .orElse("");

        boolean allMatch = segments.stream()
                .map(s -> s.get(0))
                .allMatch(p -> p.startsWith(prefix));

        return allMatch ? prefix : null;
    }

    private static String longestCommonSuffix(List<List<String>> segments) {
        final String suffix = segments.stream()
                .map(s -> s.get(s.size() - 1))
                .reduce((s1, s2) -> s1.length() < s2.length() ? s2 : s1)
                .orElse("");

        boolean allMatch = segments.stream()
                .map(s -> s.get(s.size() - 1))
                .allMatch(s -> s.endsWith(suffix));

        return allMatch ? suffix : null;
    }
}