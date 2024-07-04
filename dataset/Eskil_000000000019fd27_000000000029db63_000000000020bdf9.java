import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {

    public static class Activity implements Comparable<Activity> {
        int start;
        int end;
        int index;
        String person;

        public Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
            this.person = null;
        }

        public int compareTo(Activity a) {
            return start - a.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        int T = Integer.parseInt(s);
        outer:
        for (int i = 0; i < T; i++) {
            s = r.readLine();
            int N = Integer.parseInt(s);
            Activity[] acts = new Activity[N];
            for (int j = 0; j < N; j++) {
                s = r.readLine();
                String[] parts = s.split(" ");
                int start = Integer.parseInt(parts[0]);
                int end = Integer.parseInt(parts[1]);
                acts[j] = new Activity(j, start, end);
            }
            Arrays.sort(acts);
            int cFree = -1;
            int jFree = -1;
            for (int j = 0; j < N; j++) {
                int start = acts[j].start;
                int end = acts[j].end;
                if (cFree <= start) cFree = -1;
                if (jFree <= start) jFree = -1;
                if (cFree == -1) {
                    cFree = end;
                    acts[j].person = "C";
                } else if (jFree == -1) {
                    jFree = end;
                    acts[j].person = "J";
                } else {
                    System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
                    continue outer;
                }
            }
            Activity[] activs = new Activity[N];
            for (int j = 0; j < N; j++) {
                activs[acts[j].index] = acts[j];
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                sb.append(activs[j].person);
            }
            System.out.println("Case #" + (i+1) + ": " + sb.toString());
        }
    }
}