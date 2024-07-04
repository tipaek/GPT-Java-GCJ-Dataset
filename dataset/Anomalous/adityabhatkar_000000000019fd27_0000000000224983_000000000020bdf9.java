import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static class Interval {
        int startTime;
        int endTime;
        String person;
        int index;

        Interval(int index, int startTime, int endTime) {
            this.index = index;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = Integer.parseInt(scanner.nextLine());

        for (int testIndex = 1; testIndex <= tests; testIndex++) {
            int numOfIntervals = Integer.parseInt(scanner.nextLine());
            boolean isImpossible = false;
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < numOfIntervals; i++) {
                String[] intervalStr = scanner.nextLine().split(" ");
                intervals.add(new Interval(i, Integer.parseInt(intervalStr[0]), Integer.parseInt(intervalStr[1])));
            }

            intervals.sort(Comparator.comparingInt(interval -> interval.startTime));

            String currentPerson = "C";
            intervals.get(0).person = currentPerson;
            int cEndTime = intervals.get(0).endTime;
            int jEndTime = 0;

            for (int i = 1; i < numOfIntervals; i++) {
                if (intervals.get(i - 1).endTime > intervals.get(i).startTime) {
                    currentPerson = "J".equals(currentPerson) ? "C" : "J";

                    if ("C".equals(currentPerson)) {
                        if (cEndTime > intervals.get(i).startTime) {
                            isImpossible = true;
                            break;
                        }
                        cEndTime = intervals.get(i).endTime;
                    } else {
                        if (jEndTime > intervals.get(i).startTime) {
                            isImpossible = true;
                            break;
                        }
                        jEndTime = intervals.get(i).endTime;
                    }
                }
                intervals.get(i).person = currentPerson;
            }

            if (isImpossible) {
                System.out.println("Case #" + testIndex + ": IMPOSSIBLE");
            } else {
                intervals.sort(Comparator.comparingInt(interval -> interval.index));
                StringBuilder result = new StringBuilder();
                for (Interval interval : intervals) {
                    result.append(interval.person);
                }
                System.out.println("Case #" + testIndex + ": " + result);
            }
        }
    }
}