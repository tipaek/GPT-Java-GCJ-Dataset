import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static class Schedule implements Comparable<Schedule>{
        int start;
        int end;

        Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(final Schedule o) {
            return (start == o.start)
                    ? end - o.end
                    : start-o.start;
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
                times[i] = new Schedule(s, e);
            }
            Arrays.sort(times);
            final StringBuilder sb = new StringBuilder();
            int je = 0;
            int ce = 0;
            for (int i = 0; i < n; i++) {
                final Schedule task = times[i];
                if (je <= task.start) {
                    sb.append("J");
                    je = task.end;
                } else if (ce <= task.start){
                    sb.append("C");
                    ce = task.end;
                } else {
                    sb.delete(0, sb.length());
                    sb.append("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println(String.format("Case #%d: %s", ti, sb.toString()));
        }
    }
}
