import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static class Interval {
        int id;
        int start;
        int end;
        char assignment = 0;

        public Interval(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

        public void assign(char assignment) {
            this.assignment = assignment;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader);

        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int intervalsCount = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>(intervalsCount);
            for (int j = 0; j < intervalsCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(j, start, end));
            }
            String result = assignIntervals(intervals);

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String assignIntervals(List<Interval> intervals) {
        char[] assignments = new char[intervals.size()];
        intervals.sort(Comparator.comparingInt(interval -> interval.start));
        PriorityQueue<Interval> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(interval -> interval.end));
        Deque<Character> availableAssignments = new ArrayDeque<>(Arrays.asList('C', 'J'));

        for (Interval interval : intervals) {
            while (!priorityQueue.isEmpty() && priorityQueue.peek().end <= interval.start) {
                Interval finishedInterval = priorityQueue.poll();
                availableAssignments.push(finishedInterval.assignment);
            }

            if (availableAssignments.isEmpty()) {
                return "IMPOSSIBLE";
            }

            char assignedParent = availableAssignments.pop();
            assignments[interval.id] = assignedParent;
            interval.assign(assignedParent);
            priorityQueue.offer(interval);
        }

        return new String(assignments);
    }
}