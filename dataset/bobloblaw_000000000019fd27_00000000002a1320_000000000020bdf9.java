import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        public int compareTo(Event o) {
            return Integer.compare(start, o.start);
        }
    }

    String schedule(int[][] arr) {
        List<Event> events = IntStream.range(0, arr.length)
                .mapToObj(index -> new Event(index, arr[index][0], arr[index][1]))
                .sorted()
                .collect(Collectors.toList());
        int cEnd = 0;
        int jEnd = 0;
        char[] out = new char[arr.length];
        for (Event event : events) {
            if (cEnd <= event.start) {
                cEnd = event.end;
                out[event.index] = 'C';
            } else if (jEnd <= event.start) {
                jEnd = event.end;
                out[event.index] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(out);
    }

    static int[][] getMatrix(int r, int c, Scanner sc) {
        int[][] arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution p = new Solution();

        int tests = sc.nextInt();
        for (int test = 1; test <= tests; test++) {
            int n = sc.nextInt();
            int[][] arr = getMatrix(n, 2, sc);
            System.out.printf("Case #%d: %s\n", test, p.schedule(arr));
        }
    }
}
