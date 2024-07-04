import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int totalCases = testCases;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            List<Time> timeList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                timeList.add(new Time(start, end, i));
            }

            timeList.sort(Comparator.comparingInt(time -> time.start));

            Time lastTimeForC = null;
            Time lastTimeForJ = null;
            boolean isImpossible = false;
            char[] assignedTasks = new char[n];

            for (Time time : timeList) {
                if (lastTimeForC == null || time.start >= lastTimeForC.end) {
                    lastTimeForC = time;
                    assignedTasks[time.index] = 'C';
                } else if (lastTimeForJ == null || time.start >= lastTimeForJ.end) {
                    lastTimeForJ = time;
                    assignedTasks[time.index] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + (totalCases - testCases) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (totalCases - testCases) + ": " + new String(assignedTasks));
            }
        }
    }

    static class Time {
        int start;
        int end;
        int index;

        public Time(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}