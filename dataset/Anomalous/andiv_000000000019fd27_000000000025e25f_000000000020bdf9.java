import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTests = scanner.nextInt();

        boolean wasPrevNextLine = false;

        for (int i = 1; i <= totalTests; i++) {
            if (!wasPrevNextLine) scanner.nextLine();
            int N = scanner.nextInt();
            Interval[] intervals = new Interval[N];

            for (int j = 0; j < N; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[j] = new Interval(start, end);
                scanner.nextLine();
            }
            wasPrevNextLine = true;
            String result = assignTasks(intervals);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String assignTasks(Interval[] intervals) {
        StringBuilder result = new StringBuilder();

        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
        PriorityQueue<Interval> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.end));
        Map<Character, Interval> assignedTasks = new HashMap<>();

        for (Interval interval : intervals) {
            if (!minHeap.isEmpty() && minHeap.peek().end <= interval.start) {
                Interval finishedTask = minHeap.poll();
                assignedTasks.remove(finishedTask.getAssignedChar());
            }

            minHeap.offer(interval);
            char assignedChar;
            if (!assignedTasks.containsKey('C')) {
                assignedChar = 'C';
                interval.setAssignedChar(assignedChar);
                assignedTasks.put('C', interval);
            } else if (!assignedTasks.containsKey('J')) {
                assignedChar = 'J';
                interval.setAssignedChar(assignedChar);
                assignedTasks.put('J', interval);
            } else {
                return "IMPOSSIBLE";
            }

            result.append(assignedChar);

            if (minHeap.size() > 2) return "IMPOSSIBLE";
        }

        return result.toString();
    }
}

class Interval {
    public int start, end;
    private char assignedChar;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setAssignedChar(char assignedChar) {
        this.assignedChar = assignedChar;
    }

    public char getAssignedChar() {
        return assignedChar;
    }
}