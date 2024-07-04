import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int activityCount = scanner.nextInt();
            char[] schedule = new char[activityCount];
            Map<TimeSlot, Integer> activityMap = new HashMap<>();

            for (int i = 0; i < activityCount; i++) {
                activityMap.put(new TimeSlot(scanner.nextInt(), scanner.nextInt()), i);
            }

            TreeMap<TimeSlot, Integer> sortedActivities = new TreeMap<>(activityMap);
            List<TimeSlot> timeSlots = new ArrayList<>(sortedActivities.keySet());
            List<Integer> indices = new ArrayList<>(sortedActivities.values());

            int lastC = -1, lastJ = -1;
            boolean isPossible = true;

            for (int i = 0; i < activityCount; i++) {
                TimeSlot currentSlot = timeSlots.get(i);
                if (lastC == -1 || !currentSlot.overlaps(timeSlots.get(lastC))) {
                    schedule[indices.get(i)] = 'C';
                    lastC = i;
                } else if (lastJ == -1 || !currentSlot.overlaps(timeSlots.get(lastJ))) {
                    schedule[indices.get(i)] = 'J';
                    lastJ = i;
                } else {
                    isPossible = false;
                    break;
                }
            }

            String result = isPossible ? new String(schedule) : "IMPOSSIBLE";
            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }

    static class TimeSlot implements Comparable<TimeSlot> {
        private final int startTime;
        private final int endTime;

        public TimeSlot(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public boolean overlaps(TimeSlot other) {
            return this.startTime < other.endTime && this.endTime > other.startTime;
        }

        @Override
        public int compareTo(TimeSlot other) {
            return Integer.compare(this.startTime, other.startTime);
        }

        @Override
        public String toString() {
            return startTime + " " + endTime;
        }
    }
}