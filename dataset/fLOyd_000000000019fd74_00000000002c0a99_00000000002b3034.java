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
            List<String> middle = new ArrayList<>();
            for (String p : patterns) {
                String[] segs = p.split("\\*");
                int lidx = 0, ridx = segs.length;
                if (segs[0].length() > 0) {
                    if (left == null) {
                        left = segs[0];
                    } else if (left.length() > segs[0].length()) {
                        if (!left.substring(0, segs[0].length()).equals(segs[0])) {
                            return "*";
                        }
                    } else if (!segs[0].substring(0, left.length()).equals(left)) {
                        return "*";
                    } else {
                        left = segs[0];
                    }
                    lidx = 1;
                }
                if (p.charAt(p.length() - 1) != '*') {
                    if (right == null) {
                        right = segs[segs.length - 1];
                    } else if (right.length() > segs[segs.length - 1].length()) {
                        if (!right.substring(right.length() - segs[segs.length - 1].length()).equals(segs[segs.length - 1])) {
                            return "*";
                        }
                    } else if (!segs[segs.length - 1].substring(segs[segs.length - 1].length() - right.length()).equals(right)) {
                        return "*";
                    } else {
                        right = segs[segs.length - 1];
                    }
                    lidx = 1;
                    right = (right == null || right.length() < segs[segs.length - 1].length()) ? segs[segs.length - 1] : right;
                    ridx = ridx - 1;
                }
                for (int i = lidx; i < ridx; ++i) {
                    if (segs[i].length() > 0) {
                        middle.add(segs[i]);
                    }
                }
            }
            return (left != null ? left : "")
                    + (middle.size() > 0 ? String.join("", middle) : "")
                    + (right != null ? right : "");
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

    private static void initIO(Boolean useSystemIO) throws IOException {
        if (useSystemIO) {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            out = new PrintStream(System.out);
        } else {
            File inputFile = new File("Resources/CodeJam/_2020/Round1A/AInput.001");
            in = new Scanner(new FileInputStream(inputFile));
            File outputFile = new File("Resources/CodeJam/_2020/Round1A/AOutput.001");
            out = new PrintStream(outputFile);
            out = new PrintStream(System.out);
        }
    }
}