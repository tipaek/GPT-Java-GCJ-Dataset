import java.util.*;

public class Solution {
    public static void main(String[] args) {
        solve(new Scanner(System.in));
    }

    private static class TimeSlot implements Comparable<TimeSlot> {
        public int index;
        public int start;
        public int end;

        public TimeSlot(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(TimeSlot timeSlot) {
            return this.start - timeSlot.start;
        }
    }
    public static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int timeSlotCount = scanner.nextInt();
            List<TimeSlot> timeSlotList = new ArrayList<>();
            for (int j = 0; j < timeSlotCount; j++) {
                timeSlotList.add(new TimeSlot(j, scanner.nextInt(), scanner.nextInt()));
            }
            String result = solve(timeSlotList);
            System.out.print("Case #" + (i + 1) + ": ");
            System.out.print(result);
            if (i != n - 1)
                System.out.println();
        }
    }

    private static String solve(List<TimeSlot> timeSlotList) {
        int nextCameron = 0;
        int nextJamie = 0;
        char[] result = new char[timeSlotList.size()];

        Collections.sort(timeSlotList);
        for (TimeSlot timeSlot : timeSlotList) {
            if (nextCameron <= timeSlot.start) {
                nextCameron = timeSlot.end;
                result[timeSlot.index] = 'C';
            } else if (nextJamie <= timeSlot.start) {
                nextJamie = timeSlot.end;
                result[timeSlot.index] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return new String(result);
    }
}
