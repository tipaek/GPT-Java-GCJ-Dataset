import java.util.*;

public class Solution {
    static class Event implements Comparable<Event> {
        int start, end;

        public Event(int start, int end) {
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
        for (int[] interval : intervals) {
            events.add(new Event(interval[0], interval[1]));
        }
        Collections.sort(events);

        int cEnd = 0, jEnd = 0;
        StringBuilder result = new StringBuilder();

        for (Event event : events) {
            if (cEnd <= event.start) {
                cEnd = event.end;
                result.append("C");
            } else if (jEnd <= event.start) {
                jEnd = event.end;
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    static int[][] readMatrix(int rows, int cols, Scanner scanner) {
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
            int[][] intervals = readMatrix(n, 2, scanner);
            System.out.printf("Case #%d: %s\n", testCase, solution.schedule(intervals));
        }
    }
}