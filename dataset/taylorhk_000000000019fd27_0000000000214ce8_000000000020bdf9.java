import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int caseCnt = s.nextInt();
        s.nextLine();
        for (int i = 0; i < caseCnt; i++) {
            int activityCnt = s.nextInt();
            s.nextLine();
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < activityCnt; j++) {
                int start = s.nextInt();
                int end = s.nextInt();
                activities.add(new Activity(start, end));
                s.nextLine();
            }
            activities.sort((a, b) -> Integer.compare(a.start, b.start));
            int cEnd = 0, jEnd = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < activityCnt; j++) {
                if (activities.get(j).start >= cEnd) {
                    sb.append("C");
                    cEnd = activities.get(j).end;
                } else if (activities.get(j).start >= jEnd) {
                    sb.append("J");
                    jEnd = activities.get(j).end;
                } else {
                    sb = new StringBuilder();
                    sb.append("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + sb.toString());
        }
    }
}
class Activity {
    int start;
    int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
