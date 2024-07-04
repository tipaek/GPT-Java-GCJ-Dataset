import java.io.*;
import java.util.*;

public class Solution {
    private static Scanner scanner;
    private static PrintStream output;

    private static class Timestamp {
        int minute;
        int eventType; // 0: end, 1: start
        int activityIndex;

        public Timestamp(int minute, int eventType, int activityIndex) {
            this.minute = minute;
            this.eventType = eventType;
            this.activityIndex = activityIndex;
        }
    }

    private static class Solver {
        private List<Timestamp> timestamps;
        private char[] result;

        void readInput(Scanner scanner) {
            int n = scanner.nextInt();
            timestamps = new ArrayList<>();
            result = new char[n];
            for (int i = 0; i < n; ++i) {
                timestamps.add(new Timestamp(scanner.nextInt(), 1, i));
                timestamps.add(new Timestamp(scanner.nextInt(), 0, i));
            }
            timestamps.sort((t1, t2) -> (t1.minute == t2.minute) ? t1.eventType - t2.eventType : t1.minute - t2.minute);
        }

        String findSolution() {
            boolean cAvailable = true, jAvailable = true;
            for (Timestamp t : timestamps) {
                if (t.eventType == 1) {
                    if (!cAvailable && !jAvailable) {
                        return "IMPOSSIBLE";
                    }
                    if (cAvailable) {
                        result[t.activityIndex] = 'C';
                        cAvailable = false;
                    } else {
                        result[t.activityIndex] = 'J';
                        jAvailable = false;
                    }
                } else {
                    if (result[t.activityIndex] == 'C') {
                        cAvailable = true;
                    } else {
                        jAvailable = true;
                    }
                }
            }
            return new String(result);
        }
    }

    public static void main(String[] args) throws IOException {
        initializeIO(true);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; ++t) {
            Solver solver = new Solver();
            solver.readInput(scanner);
            output.println("Case #" + t + ": " + solver.findSolution());
        }
        output.close();
    }

    private static void initializeIO(boolean useSystemIO) throws IOException {
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