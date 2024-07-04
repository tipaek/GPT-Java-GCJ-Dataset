import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int testCases = Integer.parseInt(reader.readLine());
        for (int t = 0; t < testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            Interval[] intervals = new Interval[2 * n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                intervals[2 * i] = new Interval(start, 0, 2 * i + 1, 2 * i);
                intervals[2 * i + 1] = new Interval(end, 1, 2 * i, 2 * i + 1);
            }

            writer.print("Case #" + (t + 1) + ": ");
            Arrays.sort(intervals);
            String result = "";
            int cameron = -1;
            int jamie = -1;
            String[] schedule = new String[n];

            for (Interval interval : intervals) {
                if (cameron != -1 && jamie != -1 && interval.type == 0) {
                    result = "IMPOSSIBLE";
                    Arrays.fill(schedule, "");
                    break;
                }
                if (interval.type == 1) {
                    if (cameron == interval.otherIndex) {
                        cameron = -1;
                    } else {
                        jamie = -1;
                    }
                } else {
                    if (cameron == -1) {
                        schedule[interval.index / 2] = "C";
                        cameron = interval.index;
                    } else {
                        schedule[interval.index / 2] = "J";
                        jamie = interval.index;
                    }
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                for (String s : schedule) {
                    result += s;
                }
            }
            writer.println(result);
        }

        reader.close();
        writer.close();
    }
}

class Interval implements Comparable<Interval> {
    int time;
    int type;
    int otherIndex;
    int index;

    Interval(int time, int type, int otherIndex, int index) {
        this.time = time;
        this.type = type;
        this.otherIndex = otherIndex;
        this.index = index;
    }

    @Override
    public int compareTo(Interval other) {
        if (this.time == other.time) {
            return other.type - this.type;
        }
        return this.time - other.time;
    }
}