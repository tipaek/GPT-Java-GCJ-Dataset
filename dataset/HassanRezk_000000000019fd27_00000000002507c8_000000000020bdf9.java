import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.lang.String.format;

public class Solution {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String... args) throws IOException {
        int cases = Integer.parseInt(in.readLine());
        String line;
        String[] splittedLine;
        for(int caseI = 1; caseI <= cases; ++caseI) {
            int n = Integer.parseInt(in.readLine());
            List<Activity> activityList = new ArrayList<>();
            for(int i = 0; i < n; ++i) {
                line = in.readLine();
                splittedLine = line.split(" ");

                int start = Integer.parseInt(splittedLine[0]);
                int end = Integer.parseInt(splittedLine[1]);

                activityList.add(new Activity(start, end, i));
            }
            Collections.sort(activityList);
            String s = solve(n, activityList);
            out.write(format("Case #%d: %s\n", caseI, s));
        }
        in.close();
        out.close();
    }

    static String solve(int n, List<Activity> sortedActivityList) {
        Activity busyC = null;
        Activity busyJ = null;
        char[] chrs = new char[n];
        for(Activity a : sortedActivityList) {
            int aStart = a.start;

            if(busyC != null) {
                int cEnd = busyC.end;
                if(aStart >= cEnd) {
                    busyC = null;
                }
            }
            if(busyJ != null) {
                int jEnd = busyJ.end;
                if(aStart >= jEnd) {
                    busyJ = null;
                }
            }

            if(busyC == null) {
                busyC = a;
                chrs[busyC.i] = 'C';
            } else if(busyJ == null) {
                busyJ = a;
                chrs[busyJ.i] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(chrs);
    }

    static class Activity implements Comparable<Activity> {
        int start;
        int end;
        int i;

        Activity(int start, int end, int i) {
            this.start = start;
            this.end = end;
            this.i = i;
        }

        @Override
        public int compareTo(Activity o) {
            if(start != o.start) return start - o.start;
            if(end != o.end) return end - o.end;
            return i - o.i;
        }

        @Override
        public boolean equals(Object o) {
            if(!(o instanceof Activity)) return false;
            Activity that = (Activity) o;
            return this.compareTo(that) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end, i);
        }

        @Override
        public String toString() {
            return "Index: " + i +  ", start: "+ start + ", end: " + end;
        }
    }
}
