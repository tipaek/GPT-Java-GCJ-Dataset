import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in)
        );
        int T = Integer.parseInt(in.readLine());
        
        for (int x = 0; x++ < T;) {
            int N = Integer.parseInt(in.readLine());
            Activity[] A = new Activity[N];
            for (int i = 0; i < N; i++) {
                String[] line = in.readLine().split(" ");
                A[i] = new Activity();
                A[i].start = Integer.parseInt(line[0]);
                A[i].end = Integer.parseInt(line[1]);
            }
            String y = solve(A);
            System.out.printf("Case #%d: %s\n", x, y);
        }
    }

    static String solve(Activity[] activities) {
        List<Activity> A = new ArrayList<>();
        for (Activity a : activities) {
            A.add(a);
        }
        Collections.sort(A);
        int cameronEnd = 0;
        int jamieEnd = 0;
        for (Activity a : A) {
            if (a.start >= cameronEnd) {
                cameronEnd = a.end;
                a.assignee = 'C';
            } else if (a.start >= jamieEnd) {
                jamieEnd = a.end;
                a.assignee = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        String seq = "";
        for (Activity a : activities) {
            seq += a.assignee;
        }
        return seq;
    }
}
class Activity implements Comparable<Activity> {
    int start;
    int end;
    char assignee;
    public int compareTo(Activity that) {
        return this.start == that.start
            ? this.end - that.end
            : this.start - that.start;
    }
}
