import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static interface Solver {
        public String solve();
    }

    ////////// TODO: solver /////////////////
    private static class ListSolver implements Solver {

        List<String> tokens;

        public ListSolver(Scanner scanner) {
            tokens = new ArrayList<>();

            int numLines = Integer.parseInt(scanner.nextLine());
            for (int i=0; i<numLines; ++i) {
                String line = scanner.nextLine().trim();
                tokens.add(line);
            }
        }

        @Override
        public String solve() {
            StringBuilder sb = new StringBuilder();
            StringBuilder fsb = new StringBuilder();
            int[] idx = new int[tokens.size()];
            int[] fidx = new int[tokens.size()];
            for (int i=0; i<idx.length; ++i) {
                idx[i] = tokens.get(i).length() - 1;
                fidx[i] = 0;
            }

            boolean allStar = false;
            Character next = null;
            while (!allStar) {
                for (int i=0; i<idx.length; ++i) {
                    char c = tokens.get(i).charAt(idx[i]);
                    if (c == '*') continue;
                    if (next == null) {
                        next = c;
                    }
                    if (next != c) {
                        return "*"; // IMPOSSIBLE
                    }
                    idx[i]--;
                }
                if (next == null)
                    allStar = true;
                else {
                    sb.append(next);
                    next = null;
                }
            }

            allStar = false;
            next = null;
            while (!allStar) {
                for (int i=0; i<fidx.length; ++i) {
                    char c = tokens.get(i).charAt(fidx[i]);
                    if (c == '*') continue;
                    if (next == null) {
                        next = c;
                    }
                    if (next != c) {
                        return "*"; // IMPOSSIBLE
                    }
                    fidx[i]++;
                }
                if (next == null)
                    allStar = true;
                else {
                    fsb.append(next);
                    next = null;
                }
            }

            return finish(sb, fsb, idx, fidx);
        }

        public String finish(StringBuilder sb, StringBuilder fsb, int[] idx, int[] fidx) {
            for (int i=0; i<idx.length; ++i) {
                while (idx[i] >= fidx[i]) {
                    char c = tokens.get(i).charAt(idx[i]);
                    if (c != '*')
                        sb.append(c);
                    idx[i]--;
                }
            }
            return fsb.append(sb.reverse().toString()).toString();
        }
    }

    private static void handleInput(Scanner inputReader) {
        int numTestCases = Integer.parseInt(inputReader.nextLine());
        for (int i = 0; i < numTestCases; ++i) {
            Solver s = new ListSolver(inputReader); // TODO
            String output = s.solve();
            System.out.println(String.format("Case #%d: %s\n", (i + 1), output));
        }
    }

    public static void main(String[] args) {
        handleInput((new Scanner(new BufferedReader(new InputStreamReader(System.in)))));
        // testCases();
    }

    public static void testCases() {
        String input = "2\n" +
                "5\n" +
                "*CONUTS\n" +
                "*COCONUTS\n" +
                "*OCONUTS\n" +
                "*CONUTS\n" +
                "*S\n" +
                "2\n" +
                "*XZ\n" +
                "*XYZ";
        handleInput(new Scanner(input));
    }
}
