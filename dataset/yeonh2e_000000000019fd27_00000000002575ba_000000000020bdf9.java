import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            Activity[] acts = new Activity[N];
            for (int i = 0; i < N; i++) {
                acts[i] = new Activity(in.nextInt(), in.nextInt(), i);
            }
            Arrays.sort(acts);

            char[] asgn = new char[N];
            int endC = 0;
            int endJ = 0;
            boolean possible = true;
            for (int i = 0; i < N; i++) {
                if (acts[i].start >= endC) {
                    endC = acts[i].end;
                    asgn[acts[i].idx] = 'C';
                } else if (acts[i].start >= endJ) {
                    endJ = acts[i].end;
                    asgn[acts[i].idx] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            System.out.printf("Case #%d: %s\n", t, possible ? String.valueOf(asgn) : "IMPOSSIBLE");
        }
    }
}

class Activity implements Comparable<Activity> {
    int start, end, idx;
    Activity(int S, int E, int i) {
        this.start = S;
        this.end = E;
        this.idx = i;
    }

    @Override
    public int compareTo(Activity activity) {
        return Integer.compare(this.start, activity.start);
    }
}
