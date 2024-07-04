
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

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

        Segment(Segment seg1, Segment seg2) {
            this.seqState = seg1.seqState == SeqState.INCREASING || seg2.seqState == SeqState.DECREASING
                    ? SeqState.DUAL
                    : SeqState.DUAL2;
            this.value = seg1.value + seg2.value;
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
                    if (j < value.length() && value.charAt(j) < ch) {
                        break;
                    }
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
                for (int i = 0; i < prevDepth; i++) {
                    sb.append('(');
                }

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
                    if (j < value.length() && value.charAt(j) > ch) {
                        break;
                    }
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
            StringBuilder sb = new StringBuilder();

            Segment prev = null;
            for (int i = 0; i < segments.size(); i++) {
                Segment segment = segments.get(i);
                if (prev == null) {
                    prev = segment;
                } else {
                    if (i + 1 < segments.size()) {
                        String prevStr = new Segment(prev, segment).addParentheses();
                        String nextStr = new Segment(segment, segments.get(i + 1)).addParentheses();
                        if (prevStr.length() < nextStr.length()) {
                            sb.append(prevStr);
                            prev = null;
                        } else {
                            sb.append(prev.addParentheses());
                            prev = segment;
                        }
                    } else {
                        sb.append(new Segment(prev, segment).addParentheses());
                        prev = null;
                    }
                }
            }
            if (prev != null) {
                sb.append(prev.addParentheses());
            }
            return sb.toString();
        }).run();
    }
}
