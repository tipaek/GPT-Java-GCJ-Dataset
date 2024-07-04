import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int T;

    private static class Schedule implements Comparable<Schedule>{
        public int start, end;
        public char attributed;
        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Schedule o) {
            if (this.start == o.start) return this.end - o.end;
            return this.start - o.start;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        T = scan.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scan.nextInt();

            // Get the schedule
            Schedule[] schedule = new Schedule[N];
            Schedule[] sorted = new Schedule[N];
            for (int i = 0; i < N; i++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                schedule[i] = new Schedule(start, end);
                sorted[i] = schedule[i];
            }

            // Process
            Arrays.sort(sorted);
            boolean impossible = false;
            int endJ = 0, endC = 0;
            for (int i = 0; i < N; i++) {
                Schedule s = sorted[i];

                // Check for J
                if (s.start >= endJ) {
                    s.attributed = 'J';
                    endJ = s.end;
                } else if (s.start >= endC) {
                    s.attributed = 'C';
                    endC = s.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + (t+1) + ": IMPOSSIBLE");
            } else {
                StringBuilder sb = new StringBuilder();
                for (Schedule s: schedule) {
                    sb.append(s.attributed);
                }
                System.out.println("Case #" + (t + 1) + ": " + sb.toString());
            }
        }

        scan.close();

    }
}
