import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            Time[] times = new Time[n];
            for (int j = 0; j < n; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                times[j] = new Time(a, b);
            }
            Arrays.sort(times);
            Time cameron = new Time(0, 0);
            Time james = new Time(0, 0);
            StringBuilder ans = new StringBuilder();
            cameron = new Time(times[0].start, times[0].end);
            ans.append("C");
            boolean possible = true;
            for (int j = 1; j < n; j++) {
                if (times[j].start >= cameron.end) {
                    ans.append("C");
                    cameron = times[j];
                } else if (times[j].start >= james.end) {
                    ans.append("J");
                    james = times[j];
                } else {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            if (possible) {
                System.out.println("Case #" + (i + 1) + ": " + ans.toString());
            }
        }
        sc.close();
    }

    static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time other) {
            return Integer.compare(this.start, other.start);
        }
    }
}