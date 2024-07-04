import java.util.*;
import java.io.*;

public class Solution {
        public static void main(String[] args) {
                Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
                int t = in.nextInt();
                for (int i = 1; i <= t; ++i) {
                        int n = in.nextInt();

                        Interval[] activities = new Interval[n];

                        for (int k = 0; k < n; k++) {
                                int from  = in.nextInt();
                                int to = in.nextInt();
                                activities[k] = new Interval(from, to);
                        }

                        Interval[] activitiesC = activities.clone();
                        Arrays.sort(activitiesC);

                        int c = 0;
                        int j = 0;
                        boolean failed = false;

                        for (int k = 0; k < n; k++) {
                                if (activitiesC[k].from >= c) {
                                        activitiesC[k].p = 'C';
                                        c = activitiesC[k].to;
                                } else if (activitiesC[k].from >= j) {
                                        activitiesC[k].p = 'J';
                                        j = activitiesC[k].to;
                                } else {
                                        failed = true;
                                        break;
                                }
                        }

                        if (failed) {
                                System.out.println("Case #" + i + ": IMPOSSIBLE");
                        } else {

                                StringBuilder sb = new StringBuilder();

                                for (int k = 0; k < n; k++) {
                                        sb.append(activities[k].p);
                                }

                                System.out.println("Case #" + i + ": " + sb.toString());
                        }
                }
        }

        static class Interval implements Comparable<Interval> {

                int from;
                int to;
                char p;

                public Interval(int from, int to) {
                        this.from = from;
                        this.to = to;
                }

                public String toString() {
                        return p + ": [" + from + ", " + to + "]";
                }

                @Override
                public int compareTo(Interval o) {
                        Integer a = from;
                        Integer b = o.from;
                        return  a.compareTo(b);
                }
        }

}
