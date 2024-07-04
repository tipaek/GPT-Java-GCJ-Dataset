import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static class Activity implements Comparable<Activity> {
        public int start;
        public int end;
        public int index;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Activity o) {
            return Integer.compare(this.start, o.start);
        }
    }
    public static Activity[] ACTIVITIES;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            ACTIVITIES = new Activity[N];
            for (int n = 0; n < N; n++) {
                String[] parts = br.readLine().split(" ");
                ACTIVITIES[n] = new Activity(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), n);
            }
            System.out.println("Case #" + (t+1) + ": " + solve());
        }
        br.close();
    }

    public static String solve() {
        int jfree = 0;
        int cfree = 0;
        int L = ACTIVITIES.length;
        Arrays.sort(ACTIVITIES);
        char[] c = new char[L];
        for (Activity a : ACTIVITIES) {
            if (a.start < jfree) {
                if (a.start < cfree) {
                    return "IMPOSSIBLE";
                }

                cfree = a.end;
                c[a.index] = 'C';
            } else {
                jfree = a.end;
                c[a.index] = 'J';
            }
        }
        return new String(c);
    }
}
