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
            int lastEnd = -1;
            for (int z = 0; z < n; z++) {
                if (activities[z].start >= lastEnd) {
                    activities[z].who = 1;
                    lastEnd = activities[z].end;
                }
            }
            lastEnd = -1;
            for (int z = 0; z < n; z++) {
                if (activities[z].who != 1) {
                    if (activities[z].start >= lastEnd) {
                        lastEnd = activities[z].end;
                    } else {
                        impossible = true;
                        break;
                    }
                }
            }
            if (impossible) {
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                Arrays.sort(activities, Comparator.comparingInt(o -> o.index));
                for (activity a : activities) {
                    if (a.who == 1) {
                        stringBuilder.append("C");
                    } else {
                        stringBuilder.append("J");
                    }
                }
                System.out.println("Case #" + i + ": " + stringBuilder.toString());
            }
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