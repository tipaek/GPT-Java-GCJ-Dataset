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
            List<activity> activities = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                if (end < start || end > 24 * 60 || start < 0)
                    impossible = true;
                activities.add(new activity(start, end, j));
            }
            activities.sort(Comparator.comparingInt(o -> o.end));
            int lastEnd = -1;
            for (int z = 0; z < n; z++) {
                if (activities.get(z).start >= lastEnd) {
                    activities.get(z).who = 1;
                    lastEnd = activities.get(z).end;
                }
            }
            lastEnd = -1;
            for (int z = 0; z < n; z++) {
                if (activities.get(z).who == 0) {
                    if (activities.get(z).start >= lastEnd) {
                        lastEnd = activities.get(z).end;
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
                activities.sort(Comparator.comparingInt(o -> o.index));
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
    int start;
    int end;
    int index;
    int who = 0;

    activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}