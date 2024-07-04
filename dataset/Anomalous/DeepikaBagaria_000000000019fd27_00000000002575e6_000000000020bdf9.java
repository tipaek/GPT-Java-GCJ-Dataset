import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

    private static class TimeObj {
        int time;
        boolean isStart;
        int id;
        char alloc;

        TimeObj(int time, boolean isStart, int id) {
            this.time = time;
            this.isStart = isStart;
            this.id = id;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        final String impossible = "IMPOSSIBLE";

        for (int tt = 0; tt < t; tt++) {
            int n = Integer.parseInt(br.readLine());
            TimeObj[] times = new TimeObj[2 * n];
            char[] allocation = new char[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                times[2 * i] = new TimeObj(start, true, i);
                times[2 * i + 1] = new TimeObj(end, false, i);
            }

            Arrays.sort(times, new Comparator<TimeObj>() {
                @Override
                public int compare(TimeObj o1, TimeObj o2) {
                    if (o1.time != o2.time) {
                        return Integer.compare(o1.time, o2.time);
                    }
                    return Boolean.compare(o2.isStart, o1.isStart);
                }
            });

            boolean camAvailable = true;
            boolean jamAvailable = true;
            boolean possible = true;

            for (TimeObj time : times) {
                if (time.isStart) {
                    if (camAvailable) {
                        camAvailable = false;
                        allocation[time.id] = 'C';
                    } else if (jamAvailable) {
                        jamAvailable = false;
                        allocation[time.id] = 'J';
                    } else {
                        possible = false;
                        break;
                    }
                } else {
                    if (allocation[time.id] == 'C') {
                        camAvailable = true;
                    } else if (allocation[time.id] == 'J') {
                        jamAvailable = true;
                    }
                }
            }

            System.out.println("Case #" + (tt + 1) + ": " + (possible ? new String(allocation) : impossible));
        }
    }
}