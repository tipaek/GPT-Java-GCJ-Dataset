import java.io.*;
import java.util.*;

public class Solution {
    private static Scanner scanner;
    private static PrintStream output;

    private static class Timestamp {
        int minute;
        int type; // 0: end, 1: start
        int activity;

        public Timestamp(int minute, int type, int activity) {
            this.minute = minute;
            this.type = type;
            this.activity = activity;
        }
    }

    private static class Solver {
        private List<Timestamp> timestamps;
        private char[] assignments;

        void readInput(Scanner scanner) {
            int n = scanner.nextInt();
            timestamps = new ArrayList<>();
            assignments = new char[n];
            for (int i = 0; i < n; ++i) {
                timestamps.add(new Timestamp(scanner.nextInt(), 1, i));
                timestamps.add(new Timestamp(scanner.nextInt(), 0, i));
            }
            timestamps.sort((a, b) -> a.minute == b.minute ? a.type - b.type : a.minute - b.minute);
        }

        String solve() {
            boolean cFree = true, jFree = true;
            for (Timestamp t : timestamps) {
                if (t.type == 1) {
                    if (!cFree && !jFree) {
                        return "IMPOSSIBLE";
                    }
                    if (cFree) {
                        assignments[t.activity] = 'C';
                        cFree = false;
                    } else {
                        assignments[t.activity] = 'J';
                        jFree = false;
                    }
                } else {
                    if (assignments[t.activity] == 'C') {
                        cFree = true;
                    } else {
                        jFree = true;
                    }
                }
            }
            return new String(assignments);
        }
    }

    public static void main(String[] args) throws IOException {
        setupIO(true);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            Solver solver = new Solver();
            solver.readInput(scanner);
            output.println("Case #" + i + ": " + solver.solve());
        }
        output.close();
    }

    private static void setupIO(boolean useSystemIO) throws IOException {
        if (useSystemIO) {
            scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            output = new PrintStream(System.out);
        } else {
            File inputFile = new File("Resources/CodeJam/_2020/QualificationRound/CInput.000");
            scanner = new Scanner(new FileInputStream(inputFile));
            File outputFile = new File("Resources/CodeJam/_2020/QualificationRound/COutput.000");
            output = new PrintStream(outputFile);
        }
    }
}