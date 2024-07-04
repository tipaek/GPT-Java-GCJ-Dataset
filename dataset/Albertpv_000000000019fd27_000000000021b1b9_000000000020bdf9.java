import java.util.Arrays;
import java.util.Scanner;

public class Solution {


    private static class Interval implements Comparable<Interval> {
        int id;
        int start;
        int end;

        public Interval(int id, int start, int end) {
            this.id = id;
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
        char []res = new char[tasks.length];

        Arrays.sort(tasks);

        for (Interval task : tasks) {

            if (cameronEnds <= task.start) {
                res[task.id] = 'C';
                cameronEnds = task.end;

            } else if (jamieEnds <= task.start) {
                res[task.id] = 'J';
                jamieEnds = task.end;

            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(res);
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
                intervals[i] = new Interval(i, Integer.parseInt(strIntervals[0]), Integer.parseInt(strIntervals[1]));
            }

            String res = sol.solve(intervals);

            System.out.println("Case #" + t + ": " + res);
        }

    }
}
