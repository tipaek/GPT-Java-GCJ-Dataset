import java.util.*;
import java.io.*;

public class Solution {

    private static class Problem {

        private final int id;
        private final String input;

        public Problem(int id, String input) {
            this.id = id;
            this.input = input;
        }

        @Override
        public String toString() {
            return "\nProblem " + id + ": input=" + input;
        }

        public void output() {
            StringBuilder sb = new StringBuilder();
            int nesting = 0;
            for (int i = 0; i < input.length(); i++) {
                int value = Character.getNumericValue(input.charAt(i));
                if (value > nesting) {
                    for (int j = 0; j < value - nesting; j++) {
                        sb.append('(');
                    }
                }
                if (value < nesting) {
                    for (int j = 0; j < nesting - value; j++) {
                        sb.append(')');
                    }
                }
                sb.append(value);
                nesting = value;
            }
            for (int i = 0; i < nesting; i++) {
                sb.append(')');
            }

            //System.out.println(toString());
            System.out.println(String.format("Case #%d: %s", id, sb.toString()));
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int casesCount = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        List<Problem> problems = new ArrayList<>();
        for (int caseId = 1; caseId <= casesCount; caseId++) {
            problems.add(new Problem(caseId, in.nextLine()));
        }

        problems.forEach(Problem::output);
    }

}
