import java.io.*;
import java.util.*;

public class Solution implements Comparable<Solution> {
    int start, end, index;
    boolean visited, ended;

    public Solution() {}

    public Solution(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
        this.visited = false;
        this.ended = false;
    }

    @Override
    public int compareTo(Solution other) {
        if (this.start != other.start) {
            return this.start - other.start;
        }
        return this.end - other.end;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        List<String> results = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            Solution[] intervals = new Solution[N];
            int maxEnd = Integer.MIN_VALUE;

            for (int j = 0; j < N; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervals[j] = new Solution(start, end, j);
                if (end > maxEnd) {
                    maxEnd = end;
                }
            }

            Arrays.sort(intervals);
            StringBuilder schedule = new StringBuilder("0".repeat(N));
            List<Character> available = new ArrayList<>(Arrays.asList('J', 'C'));
            int current1 = 0, current2 = 1, next = 2;

            for (int time = intervals[0].start; time <= maxEnd; time++) {
                if (current1 < N && intervals[current1].end == time) {
                    available.add('J');
                    current1 = next++;
                }
                if (current2 < N && intervals[current2].end == time) {
                    available.add('C');
                    current2 = next++;
                }
                if (current1 < N && intervals[current1].start == time) {
                    if (!available.isEmpty()) {
                        schedule.setCharAt(intervals[current1].index, available.remove(0));
                    } else {
                        schedule = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
                if (current2 < N && intervals[current2].start == time) {
                    if (!available.isEmpty()) {
                        schedule.setCharAt(intervals[current2].index, available.remove(0));
                    } else {
                        schedule = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
                if (next < N && intervals[next].start == time) {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            results.add(schedule.toString());
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }
}