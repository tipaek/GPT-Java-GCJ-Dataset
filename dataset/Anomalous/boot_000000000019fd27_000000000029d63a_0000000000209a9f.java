import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private Scanner scanner;
    private String digits;

    public Solution(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Solution solution = new Solution(scanner);
            int testCases = scanner.nextInt();

            for (int tc = 1; tc <= testCases; tc++) {
                solution.processInput();
                System.out.printf("Case #%d:", tc);
                solution.solve();
                System.out.println();
            }
        }
    }

    void processInput() {
        digits = scanner.next();
    }

    void solve() {
        System.out.printf(" %s", addBrackets(splitSegments(digits), 0));
    }

    private List<String> splitSegments(String s) {
        List<String> segments = new ArrayList<>();
        int startIdx = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(startIdx)) {
                segments.add(s.substring(startIdx, i));
                startIdx = i;
            }
        }

        if (startIdx < s.length()) {
            segments.add(s.substring(startIdx));
        }

        return segments;
    }

    private String addBrackets(List<String> segments, int depth) {
        if (segments.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        for (String segment : segments) {
            int digit = segment.charAt(0) - '0';
            while (depth < digit) {
                result.append('(');
                depth++;
            }
            while (depth > digit) {
                result.append(')');
                depth--;
            }
            result.append(segment);
        }

        while (depth > 0) {
            result.append(')');
            depth--;
        }

        return result.toString();
    }
}