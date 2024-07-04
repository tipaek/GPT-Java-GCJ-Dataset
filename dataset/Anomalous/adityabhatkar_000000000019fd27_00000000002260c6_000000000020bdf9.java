import java.util.*;

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
            List<Interval> intervals = new ArrayList<>();
            boolean isImpossible = false;

            for (int i = 0; i < numOfIntervals; i++) {
                String[] intervalInput = scanner.nextLine().split(" ");
                intervals.add(new Interval(i, Integer.parseInt(intervalInput[0]), Integer.parseInt(intervalInput[1])));
            }

            intervals.sort(Comparator.comparingInt(interval -> interval.startTime));

            int cEndTime = 0, jEndTime = 0;
            StringBuilder result = new StringBuilder();

            for (Interval interval : intervals) {
                if (interval.startTime >= cEndTime) {
                    interval.person = "C";
                    cEndTime = interval.endTime;
                } else if (interval.startTime >= jEndTime) {
                    interval.person = "J";
                    jEndTime = interval.endTime;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + testIndex + ": IMPOSSIBLE");
            } else {
                intervals.sort(Comparator.comparingInt(interval -> interval.index));
                for (Interval interval : intervals) {
                    result.append(interval.person);
                }
                System.out.println("Case #" + testIndex + ": " + result);
            }
        }
    }
}