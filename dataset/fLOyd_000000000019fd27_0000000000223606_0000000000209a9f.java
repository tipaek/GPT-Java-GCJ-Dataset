import java.io.*;
import java.util.*;


public class Solution {
    private static Scanner in;
    private static PrintStream out;

    private static class Solver {
        private String s;

        void getInput(Scanner in) {
            s = in.next();
        }

        String solve() {
            StringBuilder res = new StringBuilder();
            int depth = 0;
            for (int i = 0; i < s.length(); ++i) {
                int v = s.charAt(i) - '0';
                if (v > depth) {
                    res.append(new String(new char[v - depth]).replace("\0", "("));
                } else if (v < depth) {
                    res.append(new String(new char[depth - v]).replace("\0", ")"));
                }
                res.append(s.charAt(i));
                depth = v;
            }
            res.append(new String(new char[depth]).replace("\0", ")"));
            return res.toString();
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
            File inputFile = new File("Resources/CodeJam/_2020/QualificationRound/BInput.000");
            in = new Scanner(new FileInputStream(inputFile));
            File outputFile = new File("Resources/CodeJam/_2020/QualificationRound/BOutput.000");
            out = new PrintStream(outputFile);
            out = new PrintStream(System.out);
        }
    }
}