import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(reader.readLine().trim());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(reader.readLine().trim());
            Activity[] activities = new Activity[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                activities[i] = new Activity(start, end, i);
            }

            Arrays.sort(activities, Comparator.comparingInt((Activity a) -> a.start).thenComparingInt(a -> a.end));

            int Cend = 0;
            int Jend = 0;
            boolean possible = true;
            char[] schedule = new char[N];

            for (Activity activity : activities) {
                if (Cend <= activity.start) {
                    schedule[activity.idx] = 'C';
                    Cend = activity.end;
                } else if (Jend <= activity.start) {
                    schedule[activity.idx] = 'J';
                    Jend = activity.end;
                } else {
                    possible = false;
                    break;
                }
            }

            String result = possible ? new String(schedule) : "IMPOSSIBLE";
            out.printf("Case #%d: %s\n", t, result);
        }

        reader.close();
        out.close();
    }

    static class Activity {
        int start;
        int end;
        int idx;

        Activity(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }
    }
}