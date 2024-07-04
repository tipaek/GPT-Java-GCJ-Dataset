import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTests = Integer.parseInt(reader.readLine());
        TaskSolver solver = new TaskSolver();
        for (int i = 1; i <= numberOfTests; i++) {
            solver.execute(i, reader);
        }
    }

    static class TaskSolver {

        public void execute(int testCaseNumber, BufferedReader reader) throws IOException {
            StringBuilder result = new StringBuilder();
            ArrayList<Interval> cameronSchedule = new ArrayList<>();
            ArrayList<Interval> jamieSchedule = new ArrayList<>();
            int numberOfTasks = Integer.parseInt(reader.readLine());
            boolean isCameronBusy = false;
            boolean isImpossible = false;

            for (int i = 0; i < numberOfTasks; i++) {
                Interval task = new Interval(reader.readLine().split(" "));
                if (!isImpossible) {
                    for (Interval interval : cameronSchedule) {
                        if (interval.conflictsWith(task)) {
                            isCameronBusy = true;
                            break;
                        }
                    }

                    if (isCameronBusy) {
                        for (Interval interval : jamieSchedule) {
                            if (interval.conflictsWith(task)) {
                                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                                isImpossible = true;
                                break;
                            }
                        }
                        if (!isImpossible) {
                            jamieSchedule.add(task);
                            result.append("J");
                        }
                    } else {
                        cameronSchedule.add(task);
                        result.append("C");
                    }

                    isCameronBusy = false;
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

    public Interval(String[] timeRange) {
        start = Integer.parseInt(timeRange[0]);
        end = Integer.parseInt(timeRange[1]);
    }

    boolean conflictsWith(Interval other) {
        return !(end <= other.start || start >= other.end);
    }
}