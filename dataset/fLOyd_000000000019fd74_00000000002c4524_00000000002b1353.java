import java.io.*;
import java.util.*;


public class Solution {
    private static Scanner in;
    private static PrintStream out;

    private static class Solver {
        int n;
        void getInput(Scanner in) {
            n = in.nextInt();
        }

        String solve() {
            StringBuilder res = new StringBuilder();
            if (n <= 500) {
                for (int i = 0; i < n; ++i) {
                    res.append(String.format("%d 1\n", i + 1));
                }
            } else if (n <= 998) {
                for (int i = 0; i < n - 499; ++i) {
                    res.append(String.format("%d 1\n", i + 1));
                }
                res.append(String.format("%d 2\n", n - 498));
                for (int i = n - 499; i < 499; ++i) {
                    res.append(String.format("%d 1\n", i + 1));
                }
            } else {
                res.append("1 1\n");
                for (int i = 0; i < 44; ++i) {
                    res.append(String.format("%d 2\n", i + 2));
                }
                for (int i = 0; i < n - 991; ++i) {
                    res.append(String.format("%d 1\n", i + 45));
                }
            }
            return res.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        initIO(true);
        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            Solver solver = new Solver();
            solver.getInput(in);
            out.println("Case #" + t + ":");
            out.print(solver.solve());
        }
        out.close();
    }

    private static void initIO(Boolean useSystemIO) throws IOException {
        if (useSystemIO) {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            out = new PrintStream(System.out);
        } else {
            File inputFile = new File("Resources/CodeJam/_2020/Round1A/BInput.000");
            in = new Scanner(new FileInputStream(inputFile));
            File outputFile = new File("Resources/CodeJam/_2020/Round1A/BOutput.000");
            out = new PrintStream(outputFile);
            out = new PrintStream(System.out);
        }
    }
}