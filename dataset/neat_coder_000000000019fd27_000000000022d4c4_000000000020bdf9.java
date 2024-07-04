import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTestCases = in.nextInt();
        int testcase = 1;
        while (in.hasNext()) {
            int schedules = in.nextInt();
            final int[][] overlapping = new int[schedules][];
            for (int i = 0; i < schedules; i++) {
                final int start = in.nextInt();
                final int end = in.nextInt();
                overlapping[i] = new int[] { start, end };
            }
            String i = numberOfOverlappingTasks(overlapping);
            System.out.println("Case #" + testcase + ": " + i);
            testcase++;
        }
    }

    public static class period {
        public period(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public int start;
        public int end;
        public int index;
    }

    public static class babyOwner {
        public babyOwner(String owner, int end, int index) {
            this.owner = owner;
            this.end = end;
            this.index = index;
        }

        public String owner;
        public int end;
        public int index;
    }

    public static String numberOfOverlappingTasks(int[][] intervals) {
        final PriorityQueue<period> schedule = new PriorityQueue<>(Comparator.comparingInt(o -> o.start));
        for (int i1 = 0; i1 < intervals.length; i1++) {
            int[] i = intervals[i1];
            schedule.add(new period(i[0], i[1], i1));
        }
        final String[] babyOwner = new String[intervals.length];
        final PriorityQueue<babyOwner> currentlyBusy = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));

        while (!schedule.isEmpty()) {
            final period poll = schedule.poll();
            if (!currentlyBusy.isEmpty() && currentlyBusy.peek().end <= poll.start) {
                currentlyBusy.remove();
            }
            if (currentlyBusy.isEmpty()) {
                currentlyBusy.add(new babyOwner("J", poll.end, poll.index));
                babyOwner[poll.index] = "J";
            } else if (currentlyBusy.size() == 1) {
                if (currentlyBusy.peek().owner == "J") {
                    currentlyBusy.add(new babyOwner("C", poll.end, poll.index));
                    babyOwner[poll.index] = "C";
                } else {
                    currentlyBusy.add(new babyOwner("J", poll.end, poll.index));
                    babyOwner[poll.index] = "J";
                }
            } else {
                return "IMPOSSIBLE";
            }
        }
        return String.join("", babyOwner);
    }
}