import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(f.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            final int N = Integer.parseInt(f.readLine());
            Interval[] jobs = new Interval[N];
            Map<Interval, Integer> indexes = new HashMap<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                jobs[i] = new Interval(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                indexes.put(jobs[i], i);
            }

            Arrays.sort(jobs);

            int end1 = 0, end2 = 0;
            char[] s = new char[N];
            boolean doable = true;
            for (int i = 0; i < N; i++) {
                if (jobs[i].start >= end1) {
                    end1 = jobs[i].end;
                    s[i] = 'J';
                } else if (jobs[i].start >= end2) {
                    end2 = jobs[i].end;
                    s[i] = 'C';
                } else {
                    doable = false;
                    break;
                }
            }

            String t;
            if (doable) {
                char[] array = new char[N];
                for (int i = 0; i < N; i++) {
                    array[indexes.get(jobs[i])] = s[i];
                }
                t = new String(array);
            } else {
                t = "IMPOSSIBLE";
            }

            System.out.printf("Case #%d: %s\n", testCase + 1, t);

        }
    }

    private static class Interval implements Comparable<Interval> {

        private int start;
        private int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override public int compareTo(Interval i) {
            return start - i.start;
        }
    }

}
