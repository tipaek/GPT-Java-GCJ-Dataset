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
            String res = null;
            List<String> middle = new ArrayList<>();
            for (String p : patterns) {
                if (!p.contains("*")) {
                    res = p;
                    break;
                }
                String[] segs = p.split("\\*");
                int lidx = 0, ridx = segs.length;
                if (segs[0].length() > 0) {
                    left = (left == null || left.length() < segs[0].length()) ? segs[0] : left;
                    lidx = 1;
                }
                if (p.charAt(p.length() - 1) != '*') {
                    right = (right == null || right.length() < segs[segs.length - 1].length()) ? segs[segs.length - 1] : right;
                    ridx = ridx - 1;
                }
                for (int i = lidx; i < ridx; ++i) {
                    if (segs[i].length() > 0) {
                        middle.add(segs[i]);
                    }
                }
            }
            if (res == null) {
                res = (left != null ? left : "")
                        + (middle.size() > 0 ? String.join("", middle) : "")
                        + (right != null ? right : "");
            }
            for (String pattern : patterns) {
                if (!res.matches(pattern.replace("*", ".*"))) {
                    return "*";
                }
            }
            return res;
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