import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        TaskSolver solver = new TaskSolver();
        for (int i = 1; i <= testCases; i++) {
            solver.solve(i, reader);
        }
    }

    static class TaskSolver {

        public void solve(int caseNumber, BufferedReader reader) throws IOException {
            StringBuilder result = new StringBuilder();
            List<Interval> cIntervals = new ArrayList<>();
            List<Interval> jIntervals = new ArrayList<>();
            int numIntervals = Integer.parseInt(reader.readLine());
            boolean isImpossible = false;

            for (int i = 0; i < numIntervals; i++) {
                Interval interval = new Interval(reader.readLine().split(" "));
                if (!isImpossible) {
                    boolean cConflict = cIntervals.stream().anyMatch(existing -> existing.overlaps(interval));

                    if (cConflict) {
                        boolean jConflict = jIntervals.stream().anyMatch(existing -> existing.overlaps(interval));
                        if (jConflict) {
                            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                            isImpossible = true;
                        } else {
                            jIntervals.add(interval);
                            result.append("J");
                        }
                    } else {
                        cIntervals.add(interval);
                        result.append("C");
                    }
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + caseNumber + ": " + result);
            }
        }
    }
}

class Interval {
    int start;
    int end;

    public Interval(String[] times) {
        this.start = Integer.parseInt(times[0]);
        this.end = Integer.parseInt(times[1]);
    }

    public boolean overlaps(Interval other) {
        return !(this.end <= other.start || this.start >= other.end);
    }
}

/*

4
3
30 40
0 35
20 29
3
0 1440
1 3
2 4
5
99 150
1 100
100 301
2 5
150 250
2
0 720
720 1440

 */