import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTests = Integer.parseInt(reader.readLine());
        Scheduler scheduler = new Scheduler();
        for (int i = 1; i <= numberOfTests; i++) {
            scheduler.processTestCase(i, reader);
        }
    }

    static class Scheduler {

        public void processTestCase(int testCaseNumber, BufferedReader reader) throws IOException {
            StringBuilder result = new StringBuilder();
            ArrayList<Interval> cameronTasks = new ArrayList<>();
            ArrayList<Interval> jamieTasks = new ArrayList<>();
            int numberOfTasks = Integer.parseInt(reader.readLine());
            boolean cameronBusy = false;
            boolean isImpossible = false;

            for (int i = 0; i < numberOfTasks; i++) {
                Interval task = new Interval(reader.readLine().split(" "));
                if (!isImpossible) {
                    for (Interval cameronTask : cameronTasks) {
                        if (cameronTask.conflictsWith(task)) {
                            cameronBusy = true;
                            break;
                        }
                    }

                    if (cameronBusy) {
                        for (Interval jamieTask : jamieTasks) {
                            if (jamieTask.conflictsWith(task)) {
                                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                                isImpossible = true;
                                break;
                            }
                        }
                        if (!isImpossible) {
                            jamieTasks.add(task);
                            result.append("J");
                        }
                    } else {
                        cameronTasks.add(task);
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

    public Interval(String[] timeRange) {
        this.start = Integer.parseInt(timeRange[0]);
        this.end = Integer.parseInt(timeRange[1]);
    }

    boolean conflictsWith(Interval other) {
        return !(this.end <= other.start || this.start >= other.end);
    }
}