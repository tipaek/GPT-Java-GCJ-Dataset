import java.util.*;
import java.io.*;

class Interval {
    int start;
    int end;
    int index;

    Interval(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(br.readLine());
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                intervals.add(new Interval(start, end, i));
            }

            intervals.sort(Comparator.comparingInt(interval -> interval.start));

            int cEnd = intervals.get(0).end;
            int jEnd = 0;
            char[] result = new char[n];
            result[intervals.get(0).index] = 'C';

            boolean possible = true;

            for (int i = 1; i < n; i++) {
                Interval current = intervals.get(i);
                if (cEnd <= current.start) {
                    result[current.index] = 'C';
                    cEnd = current.end;
                } else if (jEnd <= current.start) {
                    result[current.index] = 'J';
                    jEnd = current.end;
                } else {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + t + ": " + new String(result));
            }
        }
    }
}