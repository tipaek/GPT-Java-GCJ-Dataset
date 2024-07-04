import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int loop=1; loop<=T; loop++) {
            int n = in.nextInt();

            Interval[] intervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(in.nextInt(), in.nextInt(), i);
            }

            Arrays.sort(intervals);

            String result = solve(n, intervals);

            sb.append("Case #");
            sb.append(loop);
            sb.append(": ");
            sb.append(result);
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    private static String solve(int n, Interval[] intervals) {
        // if both parents can fit it, make the parent with the later ending time take it
        // otherwise make the one that can take it or output impossible

        int parent1end = 0; // c
        int parent2end = 0; // j

        char[] intervalAssignments = new char[n];

        for (Interval i: intervals) {
            if (i.start < parent1end && i.start < parent2end) {
                return "IMPOSSIBLE";
            }

            else if (parent1end <= i.start && parent2end <= i.start) {
                // then take the later

                if (parent1end > parent2end) {
                    parent1end = i.end;
                    intervalAssignments[i.id] = 'C';
                }

                else {
                    parent2end = i.end;
                    intervalAssignments[i.id] = 'J';
                }
            }

            else if (parent1end <= i.start) {
                parent1end = i.end;
                intervalAssignments[i.id] = 'C';
            }

            else {
                parent2end = i.end;
                intervalAssignments[i.id] = 'J';
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(intervalAssignments[i]);
        }

        return sb.toString();
    }

    private static class Interval implements Comparable<Interval> {
        int start, end, id;

        Interval(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        @Override
        public int compareTo(Interval o) {
            return this.end - o.end;
        }
    }
}


