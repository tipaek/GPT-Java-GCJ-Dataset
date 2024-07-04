import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static class Event implements Comparable<Event> {
        int index;
        int start;
        int end;

        public Event(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Event other) {
            return Integer.compare(this.start, other.start);
        }
    }

    String schedule(int[][] intervals) {
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            events.add(new Event(i, intervals[i][0], intervals[i][1]));
        }
        Collections.sort(events);

        int cEnd = 0;
        int jEnd = 0;
        char[] result = new char[intervals.length];

        for (Event event : events) {
            if (cEnd <= event.start) {
                cEnd = event.end;
                result[event.index] = 'C';
            } else if (jEnd <= event.start) {
                jEnd = event.end;
                result[event.index] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(result);
    }

    static int[][] getMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] intervals = getMatrix(n, 2, scanner);
            System.out.printf("Case #%d: %s\n", testCase, solution.schedule(intervals));
        }
    }
}