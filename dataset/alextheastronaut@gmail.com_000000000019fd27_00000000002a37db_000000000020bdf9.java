import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int numCases = Integer.parseInt(br.readLine());
        for (int i = 1; i <= numCases; i++) {
            int numTimes = Integer.parseInt(br.readLine());
            Time[] times = new Time[numTimes];
            for (int j = 0; j < numTimes; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                times[j] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Time[] sorted = Arrays.copyOf(times, times.length);
            Arrays.sort(sorted);
            pw.println("Case #" + i + ": " + solution(sorted, times));
        }

        pw.flush();
        pw.close();
        br.close();
    }

    static String solution(Time[] sorted, Time[] times) {
        StringBuilder sb = new StringBuilder();
        Time c, j;
        c = j = null;
        for (Time t: sorted) {
            if (c == null || c.end <= t.start) {
                c = t;
                t.owner = 'C';
            } else if (j == null || j.end <= t.start) {
                j = t;
                t.owner = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (Time t: times) {
            sb.append(t.owner);
        }

        return sb.toString();
    }

    static class Time implements Comparable<Time>{
        int start, end;
        char owner = 'b';

        public Time(int _start, int _end) {
            start = _start;
            end = _end;
        }

        @Override
        public int compareTo(Time time) {
            return start - time.start;
        }
    }
}