import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static class Schedule implements Comparable<Schedule>{
        int index;
        int start;
        int end;

        Schedule(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(final Schedule o) {
            return (start == o.start)
                    ? end - o.end
                    : start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        final int t = Integer.parseInt(br.readLine());
        for (int ti = 1; ti <=t; ti++) {
            final int n = Integer.parseInt(br.readLine());
            final Schedule[] times = new Schedule[n];
            for (int i = 0; i < n; i++) {
                final String[] inputArray = br.readLine().split(" ");
                final int s = Integer.parseInt(inputArray[0]);
                final int e = Integer.parseInt(inputArray[1]);
                times[i] = new Schedule(i, s, e);
            }
            Arrays.sort(times);
            final String[] ans = new String[n];
            int je = 0;
            int ce = 0;
            boolean impossible = false;
            for (int i = 0; i < n; i++) {
                final Schedule task = times[i];
                if (je <= task.start) {
                    ans[task.index] ="J";
                    je = task.end;
                } else if (ce <= task.start){
                    ans[task.index] = "C";
                    ce = task.end;
                } else {
                    impossible = true;
                    break;
                }
            }
            final StringBuilder sb = new StringBuilder();
            if (impossible) {
                sb.append("IMPOSSIBLE");
            } else {
                sb.append(String.join("", ans));
            }
            System.out.println(String.format("Case #%d: %s", ti, sb.toString()));
        }
    }
}
