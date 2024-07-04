import java.io.*;
import java.util.*;

public class Solution {

    private static final int TOTAL_TIMELINE = (24 * 60) + 1;
    private Scanner scanner;

    class TimeSlot {
        int start;
        int end;

        public TimeSlot(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            TimeSlot timeSlot = (TimeSlot) obj;
            return start == timeSlot.start && end == timeSlot.end;
        }

        public boolean overlaps(TimeSlot other) {
            return (start < other.end && end > other.start);
        }
    }

    private final Comparator<TimeSlot> timeSlotComparator = (o1, o2) -> {
        if (o1.end <= o2.start) return -1;
        if (o1.start >= o2.end) return 1;
        return 0;
    };

    public static void main(String[] args) {
        new Solution().findOptimizedSolution();
    }

    private void findOptimizedSolution() {
        StringBuilder output = new StringBuilder();
        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        PriorityQueue<TimeSlot> cQueue = new PriorityQueue<>(timeSlotComparator);
        PriorityQueue<TimeSlot> jQueue = new PriorityQueue<>(timeSlotComparator);

        for (int test = 0; test < testCases; test++) {
            StringBuilder taskAssignments = new StringBuilder();
            output.append("Case #").append(test + 1).append(": ");
            int tasks = scanner.nextInt();

            for (int t = 0; t < tasks; t++) {
                TimeSlot slot = new TimeSlot(scanner.nextInt(), scanner.nextInt());
                String user = assignTask(slot, cQueue, jQueue);
                if (user.isEmpty()) {
                    taskAssignments.setLength(0);
                    taskAssignments.append("IMPOSSIBLE");
                    break;
                } else {
                    taskAssignments.append(user);
                }
            }

            output.append(taskAssignments);
            System.out.println(output.toString());
            output.setLength(0);
            cQueue.clear();
            jQueue.clear();
        }
        scanner.close();
    }

    private String assignTask(TimeSlot slot, PriorityQueue<TimeSlot> cQueue, PriorityQueue<TimeSlot> jQueue) {
        int cDelta = calculateDelta(slot, cQueue);
        int jDelta = calculateDelta(slot, jQueue);

        if (cDelta == -1 && jDelta == -1) {
            return "";
        }
        if (cDelta == 0) {
            cQueue.add(slot);
            return "C";
        } else if (jDelta == 0) {
            jQueue.add(slot);
            return "J";
        } else if (cDelta < jDelta) {
            cQueue.add(slot);
            return "C";
        } else {
            jQueue.add(slot);
            return "J";
        }
    }

    private int calculateDelta(TimeSlot slot, PriorityQueue<TimeSlot> queue) {
        int delta = -1;

        if (queue.isEmpty()) {
            return 0;
        }

        for (TimeSlot s : queue) {
            if (slot.start >= s.end) {
                delta = slot.start - s.end;
            } else if (slot.end <= s.start) {
                delta = s.start - slot.end;
            }
        }
        return delta;
    }
}