import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private final Scanner scanner;
    private final InputStream in;
    private final PrintStream out;

    public Solution(InputStream in, PrintStream out) {
        this.in = in;
        this.out = out;
        this.scanner = new Scanner(in);
    }

    public static void main(String[] args) {
        Solution nestingDepth = new Solution(System.in, System.out);
        nestingDepth.execute();
    }

    public void execute() {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            processTest(i, input);
        }
    }

    public void processTest(int testNum, String input) {
        for (int i = 1; i <= 9; i++) {
            input = addBracketsAroundNumber(input, i);
        }
        out.println("Case #" + testNum + ": " + input);
    }

    public String addBracketsAroundNumber(String input, int number) {
        List<Match> matches = findMatches(input, number);
        StringBuilder sb = new StringBuilder(input);

        for (Match match : matches) {
            if (sb.charAt(match.from) != '(' || sb.charAt(match.to) != ')') {
                sb.insert(match.to + 1, ')');
                sb.insert(match.from, '(');
            }
        }

        return sb.toString();
    }

    public List<Match> findMatches(String input, int number) {
        char targetChar = Character.forDigit(number, 10);
        int startAt = input.length() - 1;
        List<Match> matches = new ArrayList<>();

        input = replaceBracketedNumbers(input, number);
        int endLocation = input.lastIndexOf(targetChar, startAt);

        while (endLocation >= 0) {
            int startLocation = endLocation - 1;
            while (startLocation >= 0 && input.charAt(startLocation) == targetChar) {
                startLocation--;
            }

            matches.add(new Match(startLocation + 1, endLocation));
            endLocation = input.lastIndexOf(targetChar, startLocation);
        }

        return matches;
    }

    public String replaceBracketedNumbers(String input, int number) {
        for (int i = 1; i < number; i++) {
            char[] inputArray = input.toCharArray();
            char replaceChar = Character.forDigit(i + 1, 10);
            String regex = "\\(" + i + "+\\)";
            Matcher matcher = Pattern.compile(regex).matcher(input);

            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                for (int j = start; j < end; j++) {
                    inputArray[j] = replaceChar;
                }
            }

            input = new String(inputArray);
        }
        return input;
    }

    static class Match {
        final int from;
        final int to;

        public Match(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Match match = (Match) o;
            return from == match.from && to == match.to;
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Match.class.getSimpleName() + "[", "]")
                    .add("from=" + from)
                    .add("to=" + to)
                    .toString();
        }
    }
}