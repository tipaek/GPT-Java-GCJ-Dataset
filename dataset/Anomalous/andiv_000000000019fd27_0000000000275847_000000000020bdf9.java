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
                intervals[j] = new Interval(start, end, j);
                scanner.nextLine();
            }
            wasPrevNextLine = true;
            String result = solve(intervals);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String solve(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
        PriorityQueue<Interval> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.end));
        Map<Character, Interval> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        int max = 0;

        for (Interval interval : intervals) {
            if (!minHeap.isEmpty() && minHeap.peek().end <= interval.start) {
                Interval finished = minHeap.poll();
                map.remove(finished.getCh());
            }

            minHeap.offer(interval);
            char operator;
            if (!map.containsKey('C')) {
                operator = 'C';
            } else if (!map.containsKey('J')) {
                operator = 'J';
            } else {
                return "IMPOSSIBLE";
            }
            interval.setCh(operator);
            map.put(operator, interval);

            max = Math.max(max, minHeap.size());
            if (max > 2) return "IMPOSSIBLE";
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a.number));
        for (Interval interval : intervals) {
            result.append(interval.getCh());
        }
        return result.toString();
    }
}

class Interval {
    int start, end, number;
    private char ch;

    public Interval(int start, int end, int number) {
        this.start = start;
        this.end = end;
        this.number = number;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public char getCh() {
        return ch;
    }
}