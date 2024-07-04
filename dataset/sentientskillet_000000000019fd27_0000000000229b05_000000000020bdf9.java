import java.io.*;
import java.util.*;

public class Solution {
    public static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(f.readLine());
        for(int i=0; i<T; i++) {
            Time[] times = readTimes();
            out.printf("Case #%d: %s%n", i+1, solveTimes(times));
        }
        out.close();
    }
    public static Time[] readTimes() throws IOException {
        int N = Integer.parseInt(f.readLine());
        Time[] times = new Time[N];
        for(int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            times[i] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
        }
        return times;
    }
    public static String solveTimes(Time[] times) {
        int N = times.length;
        char[] schedule = new char[N];
        Arrays.sort(times);

        int Cend = 0;
        int Jend = 0;
        for(int i = 0; i<N; i++) {
            if(times[i].start >= Cend) {
                schedule[times[i].i] = 'C';
                Cend = times[i].end;
            } else if (times[i].start >= Jend) {
                schedule[times[i].i] = 'J';
                Jend = times[i].end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(schedule);
        return sb.toString();
    }
}

class Time implements Comparable<Time> {
    int start, end, i;

    public Time(int start, int end, int i) {
        this.start = start;
        this.end = end;
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return start == time.start &&
                end == time.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public int compareTo(Time o) {
       return Integer.compare(start, o.start) == 0 ? Integer.compare(end, o.end) : Integer.compare(start, o.start);
    }
}