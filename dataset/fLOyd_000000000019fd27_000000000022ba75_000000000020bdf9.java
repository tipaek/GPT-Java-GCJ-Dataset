import java.io.*;
import java.util.*;

public class Solution {
    private static Scanner in;
    private static PrintStream out;

    private static class Timestamp {
        int min;
        int type; // 0: end, 1: start
        int act;

        public Timestamp(int min, int type, int act) {
            this.min = min;
            this.type = type;
            this.act = act;
        }
    }

    private static class Solver {
        private ArrayList<Timestamp> ts;
        private char[] res;


        void getInput(Scanner in) {
            int t = in.nextInt();
            ts = new ArrayList<>();
            res = new char[t];
            for (int i = 0; i < t; ++i) {
                ts.add(new Timestamp(in.nextInt(), 1, i));
                ts.add(new Timestamp(in.nextInt(), 0, i));
            }
            ts.sort((t1, t2) -> (t1.min == t2.min) ? t1.type - t2.type : t1.min - t2.min);
        }

        String solve() {
            boolean cAvailable = true, jAvailable = true;
            for (Timestamp t : ts) {
                if (t.type == 1) {
                    if (!cAvailable && !jAvailable) {
                        return "IMPOSSIBLE";
                    }
                    if (cAvailable) {
                        res[t.act] = 'C';
                        cAvailable = false;
                    } else {
                        res[t.act] = 'J';
                        jAvailable = false;
                    }
                } else {
                    if (res[t.act] == 'C') {
                        cAvailable = true;
                    } else {
                        jAvailable = true;
                    }
                }
            }
            return String.valueOf(res);
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
            File inputFile = new File("Resources/CodeJam/_2020/QualificationRound/CInput.000");
            in = new Scanner(new FileInputStream(inputFile));
            File outputFile = new File("Resources/CodeJam/_2020/QualificationRound/COutput.000");
            out = new PrintStream(outputFile);
            out = new PrintStream(System.out);
        }
    }
}