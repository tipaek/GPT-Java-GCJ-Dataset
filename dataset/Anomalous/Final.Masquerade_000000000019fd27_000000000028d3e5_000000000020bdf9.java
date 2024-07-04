import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTests = Integer.parseInt(reader.readLine());
        Scheduler scheduler = new Scheduler();

        for (int testIndex = 1; testIndex <= numberOfTests; testIndex++) {
            scheduler.processTestCase(testIndex, reader);
        }
    }

    static class Scheduler {

        public void processTestCase(int testCaseNumber, BufferedReader reader) throws IOException {
            StringBuilder result = new StringBuilder();
            ArrayList<TimeSlot> cameronSchedule = new ArrayList<>();
            ArrayList<TimeSlot> jamieSchedule = new ArrayList<>();
            int numberOfActivities = Integer.parseInt(reader.readLine());
            boolean isCameronBusy = false;
            boolean isImpossible = false;

            for (int i = 0; i < numberOfActivities; i++) {
                TimeSlot activity = new TimeSlot(reader.readLine().split(" "));
                if (!isImpossible) {
                    for (TimeSlot slot : cameronSchedule) {
                        if (slot.isOverlapping(activity)) {
                            isCameronBusy = true;
                            break;
                        }
                    }

                    if (isCameronBusy) {
                        for (TimeSlot slot : jamieSchedule) {
                            if (slot.isOverlapping(activity)) {
                                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                                isImpossible = true;
                                break;
                            }
                        }
                        if (!isImpossible) {
                            jamieSchedule.add(activity);
                            result.append("J");
                        }
                    } else {
                        cameronSchedule.add(activity);
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

class TimeSlot {
    int start;
    int end;

    public TimeSlot(String[] timeRange) {
        this.start = Integer.parseInt(timeRange[0]);
        this.end = Integer.parseInt(timeRange[1]);
    }

    boolean isOverlapping(TimeSlot other) {
        return !(this.end <= other.start || this.start >= other.end);
    }
}