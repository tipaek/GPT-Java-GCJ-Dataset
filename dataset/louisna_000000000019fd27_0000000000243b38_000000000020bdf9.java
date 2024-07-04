import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int T;

    private static class Schedule implements Comparable<Schedule>{
        public int start, end;
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
            for (int i = 0; i < N; i++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                schedule[i] = new Schedule(start, end);
            }

            // Process
            Arrays.sort(schedule);
            StringBuilder sb = new StringBuilder();
            boolean impossible = false;
            int endJ = 0, endC = 0;
            for (int i = 0; i < N; i++) {
                Schedule s = schedule[i];

                // Check for J
                if (s.start >= endJ) {
                    sb.append('J');
                    endJ = s.end;
                } else if (s.start >= endC) {
                    sb.append('C');
                    endC = s.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + (t+1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (t + 1) + ": " + sb.toString());
            }
        }

        scan.close();

    }
}
