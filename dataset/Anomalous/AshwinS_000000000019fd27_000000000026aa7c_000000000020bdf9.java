import java.io.*;
import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    private static final int TOTAL_TIMELINE = (24 * 60) + 1;

    class TimeSlot {
        int start;
        int end;

        public TimeSlot(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int hashCode() {
            return start ^ end;
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
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        StringBuilder output = new StringBuilder();

        for (int test = 1; test <= testCases; test++) {
            int tasks = sc.nextInt();
            PriorityQueue<TimeSlot> cQueue = new PriorityQueue<>(timeSlotComparator);
            PriorityQueue<TimeSlot> jQueue = new PriorityQueue<>(timeSlotComparator);
            StringBuilder taskAssignments = new StringBuilder();

            boolean possible = true;
            for (int t = 0; t < tasks; t++) {
                TimeSlot slot = new TimeSlot(sc.nextInt(), sc.nextInt());
                String assigned = assignTask(slot, cQueue, jQueue);
                if (assigned.isEmpty()) {
                    possible = false;
                    break;
                } else {
                    taskAssignments.append(assigned);
                }
            }

            output.append("Case #").append(test).append(": ");
            if (possible) {
                output.append(taskAssignments);
            } else {
                output.append("IMPOSSIBLE");
            }
            output.append("\n");
        }

        System.out.print(output);
        sc.close();
    }

    private String assignTask(TimeSlot slot, PriorityQueue<TimeSlot> cQueue, PriorityQueue<TimeSlot> jQueue) {
        int cDelta = calculateDelta(slot, cQueue);
        int jDelta = calculateDelta(slot, jQueue);

        if (cDelta == -1 && jDelta == -1) return "";

        if (cDelta == 0 || (cDelta != -1 && cDelta < jDelta)) {
            cQueue.add(slot);
            return "C";
        } else {
            jQueue.add(slot);
            return "J";
        }
    }

    private int calculateDelta(TimeSlot slot, PriorityQueue<TimeSlot> queue) {
        if (queue.isEmpty()) return 0;

        int delta = -1;
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