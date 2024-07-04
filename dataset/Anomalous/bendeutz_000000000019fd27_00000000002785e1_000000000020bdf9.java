import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = in.nextInt();
        for (int i = 0; i < numberOfCases; i++) {
            int caseNumber = i + 1;
            int activities = in.nextInt();
            char[] schedule = new char[activities];
            Map<TimeSlot, Integer> activityMap = new HashMap<>();
            
            for (int j = 0; j < activities; j++) {
                activityMap.put(new TimeSlot(in.nextInt(), in.nextInt()), j);
            }
            
            TreeMap<TimeSlot, Integer> sortedActivities = new TreeMap<>(activityMap);
            List<TimeSlot> timeSlots = new ArrayList<>(sortedActivities.keySet());
            List<Integer> indices = new ArrayList<>(sortedActivities.values());

            int lastC = -1, lastJ = -1;
            boolean isImpossible = false;
            
            schedule[indices.get(0)] = 'C';
            lastC = 0;
            
            for (int j = 1; j < activities; j++) {
                TimeSlot current = timeSlots.get(j);
                if (lastJ == -1 || !current.overlaps(timeSlots.get(lastC))) {
                    schedule[indices.get(j)] = 'C';
                    lastC = j;
                } else if (!current.overlaps(timeSlots.get(lastJ))) {
                    schedule[indices.get(j)] = 'J';
                    lastJ = j;
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + new String(schedule));
            }
        }
    }

    static class TimeSlot implements Comparable<TimeSlot> {
        private final int startTime;
        private final int endTime;

        public TimeSlot(int start, int end) {
            this.startTime = start;
            this.endTime = end;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
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