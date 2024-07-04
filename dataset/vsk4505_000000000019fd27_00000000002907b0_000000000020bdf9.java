import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public final static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            List<Interval> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                list.add(new Interval(j, scanner.nextInt(), scanner.nextInt()));
            }
            Collections.sort(list);

            int lastCEndTime = 0;
            int lastJEndtime = 0;
            char[] jobs = new char[N];
            boolean impossible = false;
            for (Interval interval : list) {
                if (lastCEndTime <= interval.start) {
                    jobs[interval.id] = interval.job = 'C';
                    lastCEndTime = interval.end;
                } else if (lastJEndtime <= interval.start) {
                    jobs[interval.id] = interval.job = 'J';
                    lastJEndtime = interval.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + (impossible ? "IMPOSSIBLE" : new String(jobs)));
        }
    }

    static class Interval implements Comparable<Interval> {
        int id;
        int start;
        int end;
        char job;

        public Interval(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            return this.start - o.start;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }
}
