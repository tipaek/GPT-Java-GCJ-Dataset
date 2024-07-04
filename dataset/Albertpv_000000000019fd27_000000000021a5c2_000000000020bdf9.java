import java.util.Arrays;
import java.util.Scanner;

public class Solution {


    private static class Interval implements Comparable<Interval> {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            return Integer.compare(start, o.start);
        }
    }


    public String solve(Interval[] tasks) {
        int cameronEnds = 0, jamieEnds = 0;
        StringBuilder sb = new StringBuilder();

        Arrays.sort(tasks);

        for (Interval task : tasks) {

            if (cameronEnds <= task.start) {
                sb.append('C');
                cameronEnds = task.end;

            } else if (jamieEnds <= task.start) {
                sb.append('J');
                jamieEnds = task.end;

            } else {
                return "IMPOSSIBLE";
            }
        }

        return sb.toString();
    }


    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        Solution sol = new Solution();

        int T = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= T; t++) {

            int N = Integer.parseInt(scanner.nextLine());
            Interval intervals[] = new Interval[N];
            for (int i = 0; i < N; i++) {
                String strIntervals[] = scanner.nextLine().split(" ");
                intervals[i] = new Interval(Integer.parseInt(strIntervals[0]), Integer.parseInt(strIntervals[1]));
            }

            String res = sol.solve(intervals);

            System.out.println("Case #" + t + ": " + res);
        }

    }
}