import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

class Jam {
    /**
     * Scanner of StdIn.
     */
    private final Scanner scanner;

    /**
     * Number of test cases.
     */
    private final int numberOfCases;

    /**
     * The function that reads one test case and returns the solution.
     */
    private final Function<Scanner, String> solution;

    public Jam(Function<Scanner, String> solution) {
        scanner = new Scanner(System.in);
        numberOfCases = scanner.nextInt();
        this.solution = solution;
    }

    public void run() {
        for (int i = 0; i < numberOfCases; i++) {
            final String answer = solution.apply(scanner);
            System.out.printf("Case #%d: %s\n", i + 1, answer);
        }
    }
}

public class Solution {

    private enum SeqState {
        INCREASING,
        DECREASING,
        FLAT,
        DUAL,
        DUAL2,
    }

    private static class Segment {
        final SeqState seqState;
        final String value;

        Segment(SeqState seqState, String value) {
            this.seqState = seqState;
            this.value = value;
        }

        String addParentheses() {
            StringBuilder sb = new StringBuilder();
            if (seqState == SeqState.FLAT) {
                int depth = value.charAt(0) - '0';
                for (int i = 0; i < depth; i++) {
                    sb.append('(');
                }
                sb.append(value);
                for (int i = 0; i < depth; i++) {
                    sb.append(')');
                }
            } else if (seqState == SeqState.INCREASING) {
                int prevDepth = 0;
                int j = 0;
                while (j < value.length()) {
                    char ch = value.charAt(j++);
                    int depth = (ch - '0') - prevDepth;
                    for (int i = 0; i < depth; i++) {
                        sb.append('(');
                    }
                    sb.append(ch);
                    while (j < value.length() && value.charAt(j) == ch) {
                        sb.append(ch);
                        j++;
                    }
                    prevDepth += depth;
                }
                for (int i = 0; i < prevDepth; i++) {
                    sb.append(')');
                }
            } else if (seqState == SeqState.DECREASING) {
                int prevDepth = 0;
                int j = value.length() - 1;
                while (j >= 0) {
                    char ch = value.charAt(j--);
                    int depth = (ch - '0') - prevDepth;
                    for (int i = 0; i < depth; i++) {
                        sb.append(')');
                    }
                    sb.append(ch);
                    while (j >= 0 && value.charAt(j) == ch) {
                        sb.append(ch);
                        j--;
                    }
                    prevDepth += depth;
                }
                for (int i = 0; i < prevDepth; i++) {
                    sb.append('(');
                }
                sb.reverse();
            } else if (seqState == SeqState.DUAL) {
                int prevDepth = 0;
                int j = 0;
                while (j < value.length()) {
                    char ch = value.charAt(j++);
                    int depth = (ch - '0') - prevDepth;
                    for (int i = 0; i < depth; i++) {
                        sb.append('(');
                    }
                    sb.append(ch);
                    while (j < value.length() && value.charAt(j) == ch) {
                        sb.append(ch);
                        j++;
                    }
                    prevDepth += depth;
                    if (j < value.length() && value.charAt(j) < ch) break;
                }
                while (j < value.length()) {
                    char ch = value.charAt(j++);
                    int depth = prevDepth - (ch - '0');
                    for (int i = 0; i < depth; i++) {
                        sb.append(')');
                    }
                    sb.append(ch);
                    while (j < value.length() && value.charAt(j) == ch) {
                        sb.append(ch);
                        j++;
                    }
                    prevDepth -= depth;
                }
                for (int i = 0; i < prevDepth; i++) {
                    sb.append(')');
                }
            } else if (seqState == SeqState.DUAL2) {
                int prevDepth = value.charAt(0) - '0';
                for (int i = 0; i < prevDepth; i++) sb.append('(');

                int j = 0;
                char ch = value.charAt(j++);
                sb.append(ch);
                while (j < value.length() && value.charAt(j) == ch) {
                    sb.append(ch);
                    j++;
                }

                while (j < value.length()) {
                    ch = value.charAt(j++);
                    int depth = prevDepth - (ch - '0');
                    for (int i = 0; i < depth; i++) {
                        sb.append(')');
                    }
                    sb.append(ch);
                    while (j < value.length() && value.charAt(j) == ch) {
                        sb.append(ch);
                        j++;
                    }
                    prevDepth -= depth;
                    if (j < value.length() && value.charAt(j) > ch) break;
                }

                while (j < value.length()) {
                    ch = value.charAt(j++);
                    int depth = (ch - '0') - prevDepth;
                    for (int i = 0; i < depth; i++) {
                        sb.append('(');
                    }
                    sb.append(ch);
                    while (j < value.length() && value.charAt(j) == ch) {
                        sb.append(ch);
                        j++;
                    }
                    prevDepth += depth;
                }
                for (int i = 0; i < prevDepth; i++) {
                    sb.append(')');
                }
            }
            return sb.toString();
        }

        @Override
        public String toString() {
            return "Segment{" + "seqState=" + seqState + ", value='" + value + '\'' + '}';
        }
    }

    /**
     * Splits input string of digits into monotonic increasing/decreasing sub strings.
     *
     * @param s the input string.
     * @return a list of Segment.
     */
    private static List<Segment> splitMonotonic(String s) {
        List<Segment> result = new ArrayList<>();
        int i = 0;
        int n = s.length();

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(i++));
        SeqState state = SeqState.FLAT;

        while (i < n) {
            char ch = s.charAt(i++);
            char prevChar = sb.charAt(sb.length() - 1);
            if (ch > prevChar && state == SeqState.DECREASING || ch < prevChar && state == SeqState.INCREASING) {
                result.add(new Segment(state, sb.toString()));
                sb.setLength(0);
                sb.append(ch);
                state = SeqState.FLAT;
                continue;
            }
            sb.append(ch);
            if (state == SeqState.FLAT) {
                if (ch > prevChar) {
                    state = SeqState.INCREASING;
                } else if (ch < prevChar) {
                    state = SeqState.DECREASING;
                }
            }
        }

        if (sb.length() > 0) {
            result.add(new Segment(state, sb.toString()));
        }
        return result;
    }

    public static void main(String[] args) {
        new Jam(scanner -> {
            String s = scanner.next();
            List<Segment> segments = splitMonotonic(s);

            List<Segment> merged = new ArrayList<>();
            Segment prev = null;
            for (Segment segment : segments) {
                if (prev != null && (prev.seqState == SeqState.INCREASING || segment.seqState == SeqState.DECREASING)) {
                    merged.add(new Segment(SeqState.DUAL, prev.value + segment.value));
                    prev = null;
                    continue;
                } if (prev != null && (prev.seqState == SeqState.DECREASING || segment.seqState == SeqState.INCREASING)) {
                    merged.add(new Segment(SeqState.DUAL2, prev.value + segment.value));
                    prev = null;
                    continue;
                } else if (prev != null) {
                    merged.add(prev);
                }
                prev = segment;
            }
            if (prev != null) {
                merged.add(prev);
            }
            return merged.stream().map(Segment::addParentheses).collect(Collectors.joining());
        }).run();
    }
}
