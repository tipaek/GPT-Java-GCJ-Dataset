import java.util.*;
import java.io.*;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                intervals.add(new Interval(start, end));
            }

            intervals.sort(Comparator.comparingInt(o -> o.end));

            int cEnd = intervals.get(0).end;
            int jEnd = 0;
            StringBuilder schedule = new StringBuilder("C");

            boolean possible = true;

            for (int i = 1; i < n; i++) {
                Interval current = intervals.get(i);
                Interval previous = intervals.get(i - 1);

                if (previous.end <= current.start) {
                    schedule.append('C');
                    cEnd = current.end;
                    jEnd = 0;
                } else if (cEnd <= current.start) {
                    schedule.append('C');
                    cEnd = current.end;
                } else if (jEnd <= current.start) {
                    schedule.append('J');
                    jEnd = current.end;
                } else {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + t + ": " + schedule.toString());
            }
        }
    }
}