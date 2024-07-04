import java.io.*;
import java.util.*;

public class Solution {
    private static Scanner scanner;
    private static PrintStream output;

    private static class Solver {
        int n;
        List<String> patterns;

        void getInput(Scanner scanner) {
            patterns = new ArrayList<>();
            n = scanner.nextInt();
            for (int i = 0; i < n; ++i) {
                patterns.add(scanner.next());
            }
        }

        String solve() {
            String left = null, right = null;
            List<String> middle = new ArrayList<>();

            for (String pattern : patterns) {
                String[] segments = pattern.split("\\*");
                int leftIndex = 0, rightIndex = segments.length;

                if (segments[0].length() > 0) {
                    if (left == null) {
                        left = segments[0];
                    } else if (left.length() > segments[0].length()) {
                        if (!left.startsWith(segments[0])) {
                            return "*";
                        }
                    } else if (!segments[0].startsWith(left)) {
                        return "*";
                    } else {
                        left = segments[0];
                    }
                    leftIndex = 1;
                }

                if (pattern.charAt(pattern.length() - 1) != '*') {
                    if (right == null) {
                        right = segments[segments.length - 1];
                    } else if (right.length() > segments[segments.length - 1].length()) {
                        if (!right.endsWith(segments[segments.length - 1])) {
                            return "*";
                        }
                    } else if (!segments[segments.length - 1].endsWith(right)) {
                        return "*";
                    } else {
                        right = segments[segments.length - 1];
                    }
                    rightIndex = segments.length - 1;
                }

                for (int i = leftIndex; i < rightIndex; ++i) {
                    if (segments[i].length() > 0) {
                        middle.add(segments[i]);
                    }
                }
            }

            return (left != null ? left : "") +
                   String.join("", middle) +
                   (right != null ? right : "");
        }
    }

    public static void main(String[] args) throws IOException {
        initIO(true);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; ++t) {
            Solver solver = new Solver();
            solver.getInput(scanner);
            output.println("Case #" + t + ": " + solver.solve());
        }
        output.close();
    }

    private static void initIO(boolean useSystemIO) throws IOException {
        if (useSystemIO) {
            scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            output = System.out;
        } else {
            File inputFile = new File("Resources/CodeJam/_2020/Round1A/AInput.001");
            scanner = new Scanner(new FileInputStream(inputFile));
            File outputFile = new File("Resources/CodeJam/_2020/Round1A/AOutput.001");
            output = new PrintStream(outputFile);
        }
    }
}