import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTests = Integer.parseInt(reader.readLine());
        TestSolver solver = new TestSolver();
        for (int i = 1; i <= numberOfTests; i++) {
            solver.solveTest(i, reader);
        }
    }

    static class TestSolver {

        public void solveTest(int testCaseNumber, BufferedReader reader) throws IOException {
            StringBuilder result = new StringBuilder();
            ArrayList<Interval> cameronTasks = new ArrayList<>();
            ArrayList<Interval> jamieTasks = new ArrayList<>();
            int numberOfIntervals = Integer.parseInt(reader.readLine());
            boolean cameronBusy = false;
            boolean isImpossible = false;

            for (int i = 0; i < numberOfIntervals; i++) {
                Interval interval = new Interval(reader.readLine().split(" "));
                if (!isImpossible) {
                    for (Interval cameronTask : cameronTasks) {
                        if (cameronTask.overlaps(interval)) {
                            cameronBusy = true;
                            break;
                        }
                    }

                    if (cameronBusy) {
                        for (Interval jamieTask : jamieTasks) {
                            if (jamieTask.overlaps(interval)) {
                                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                                isImpossible = true;
                                break;
                            }
                        }
                        if (!isImpossible) {
                            jamieTasks.add(interval);
                            result.append("J");
                        }
                    } else {
                        cameronTasks.add(interval);
                        result.append("C");
                    }

                    cameronBusy = false;
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + testCaseNumber + ": " + result);
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

    boolean overlaps(Interval other) {
        return !(this.end <= other.start || this.start >= other.end);
    }
}

/*
Example input:
4
3
50 60
50 100
55 60
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