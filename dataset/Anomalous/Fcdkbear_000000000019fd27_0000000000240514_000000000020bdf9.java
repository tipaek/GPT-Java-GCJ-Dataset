import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int tests = in.nextInt();
        for (int testNumber = 1; testNumber <= tests; ++testNumber) {
            int n = in.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities.add(new Activity(start, end, i));
            }
            activities.sort(Comparator.comparingInt(a -> a.start));
            int cameronFinish = 0;
            int jamesFinish = 0;
            int[] result = new int[n];
            boolean possible = true;
            for (Activity activity : activities) {
                if (activity.start >= cameronFinish) {
                    cameronFinish = activity.end;
                    result[activity.index] = 1;
                } else if (activity.start >= jamesFinish) {
                    jamesFinish = activity.end;
                } else {
                    possible = false;
                }
            }
            out.printf("Case #%d: ", testNumber);
            if (possible) {
                for (int i = 0; i < n; ++i) {
                    out.print(result[i] == 1 ? 'C' : 'J');
                }
            } else {
                out.print("IMPOSSIBLE");
            }
            out.println();
        }
        out.close();
    }

    static class Activity {
        int start;
        int end;
        int index;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}