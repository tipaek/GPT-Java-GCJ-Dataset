import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(bufferedReader);
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            boolean impossible = false;
            int n = in.nextInt();
            activity[] activities = new activity[n];
            for (int j = 0; j < n; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                if (end <= start || end > 24 * 60 || start < 0)
                    impossible = true;
                activities[j] = new activity(start, end, j);
            }
            Arrays.sort(activities, Comparator.comparingInt(o -> o.end));

            if (impossible) {
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
                continue;
            }

            int lastC = -1;
            int lastJ = -1;
            StringBuilder stringBuilder = new StringBuilder();
            for (int z = 0; z < n; z++) {
                activity activity = activities[z];
                if (activity.start >= lastC) {
                    lastC = activity.end;
                    activities[z].who = 1;
                    continue;
                }
                if (activity.start >= lastJ) {
                    lastJ = activity.end;
                    activities[z].who = 2;
                    continue;
                }
                impossible = true;
            }
            if (impossible) {
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
                continue;
            }
//            lastEnd = -1;
//            for (int z = 0; z < n; z++) {
//                if (activities[z].who != 1) {
//                    if (activities[z].start >= lastEnd) {
//                        lastEnd = activities[z].end;
//                    } else {
//                        impossible = true;
//                        break;
//                    }
//                }
//            }
           // Arrays.sort(activities, Comparator.comparingInt(o -> o.index));
            for (int i1 = 0; i1 < n; i1++) {
                activity a = activities[i1];
                if (a.who == 1) {
                    stringBuilder.append("C");
                } else if (a.who == 2) {
                    stringBuilder.append("J");
                }
            }
            System.out.println("Case #" + i + ": " + stringBuilder.toString());
        }
    }
}


class activity {
    public int start;
    public int end;
    public int index;
    public int who = 0;

    public activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
        this.who = 0;
    }
}