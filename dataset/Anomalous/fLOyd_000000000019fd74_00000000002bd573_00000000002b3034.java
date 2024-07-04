import java.io.*;
import java.util.*;

public class Solution {
    private static Scanner in;
    private static PrintStream out;

    private static class Solver {
        int n;
        List<String> patterns;

        void getInput(Scanner in) {
            patterns = new ArrayList<>();
            n = in.nextInt();
            for (int i = 0; i < n; ++i) {
                patterns.add(in.next());
            }
        }

        String solve() {
            String left = null, right = null;
            String result = null;
            List<String> middle = new ArrayList<>();

            for (String pattern : patterns) {
                if (!pattern.contains("*")) {
                    result = pattern;
                    break;
                }

                String[] segments = pattern.split("\\*");
                int leftIdx = 0, rightIdx = segments.length;

                if (segments[0].length() > 0) {
                    left = (left == null || left.length() < segments[0].length()) ? segments[0] : left;
                    leftIdx = 1;
                }

                if (pattern.charAt(pattern.length() - 1) != '*') {
                    right = (right == null || right.length() < segments[segments.length - 1].length()) ? segments[segments.length - 1] : right;
                    rightIdx = rightIdx - 1;
                }

                for (int i = leftIdx; i < rightIdx; ++i) {
                    if (segments[i].length() > 0) {
                        middle.add(segments[i]);
                    }
                }
            }

            if (result == null) {
                StringBuilder sb = new StringBuilder();
                if (left != null) sb.append(left);
                for (String mid : middle) sb.append(mid);
                if (right != null) sb.append(right);
                result = sb.toString();
            }

            for (String pattern : patterns) {
                if (!result.matches(pattern.replace("*", ".*"))) {
                    return "*";
                }
            }

            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        initIO(true);
        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            Solver solver = new Solver();
            solver.getInput(in);
            out.println("Case #" + t + ": " + solver.solve());
        }
        out.close();
    }

    private static void initIO(boolean useSystemIO) throws IOException {
        if (useSystemIO) {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            out = new PrintStream(System.out);
        } else {
            in = new Scanner(new FileInputStream("Resources/CodeJam/_2020/Round1A/AInput.001"));
            out = new PrintStream(new FileOutputStream("Resources/CodeJam/_2020/Round1A/AOutput.001"));
        }
    }
}