import java.io.*;
import java.util.*;

public class Solution {
    private static Scanner in;
    private static PrintStream out;

    public static class Solver {

        private int n;
        private int[][] array;

        public void getInput(Scanner in) {
            n = in.nextInt();
            array = new int[n + 5][n + 5];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    array[i][j] = in.nextInt();
                }
            }
        }

        public String solve() {
            int kk = 0, rr = 0, cc = 0;
            for (int i = 0; i < n; ++i) {
                Set<Integer> rset = new HashSet<>();
                Set<Integer> cset = new HashSet<>();
                for (int j = 0; j < n; ++j) {
                    rset.add(array[i][j]);
                    cset.add(array[j][i]);
                }
                kk += array[i][i];
                rr += (rset.size() < n) ? 1 : 0;
                cc += (cset.size() < n) ? 1 : 0;
            }
            return String.format("%d %d %d", kk, rr, cc);
        }
    }

    public static void main(String[] args) throws IOException {
        initIO();
        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            Solver solver = new Solver();
            solver.getInput(in);
            out.println("Case #" + t + ": " + solver.solve());
        }
        out.close();
    }

    private static void initIO() throws IOException {
        File inputFile = new File("Resources/CodeJam/_2020/QualificationRound/AInput.000");
//        in = new Scanner(new FileInputStream(inputFile));
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        File outputFile = new File("Resources/CodeJam/_2020/QualificationRound/AOutput.000");
//        out = new PrintStream(outputFile);
        out = new PrintStream(System.out);
    }
}
