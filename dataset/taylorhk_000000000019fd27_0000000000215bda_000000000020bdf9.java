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
                activities.add(new Activity(j, start, end));
                s.nextLine();
            }
            activities.sort((a, b) -> Integer.compare(a.start, b.start));
            int cEnd = 0, jEnd = 0;
            StringBuilder sb = new StringBuilder();
            int turn[] = new int[activityCnt];
            boolean imp = false;
            for (int j = 0; j < activityCnt; j++) {
                if (activities.get(j).start >= cEnd) {
                    turn[activities.get(j).id] = 0;
//                    sb.append("C");
                    cEnd = activities.get(j).end;
                    } else if (activities.get(j).start >= jEnd) {
                    turn[activities.get(j).id] = 1;
//                    sb.append("J");
                    jEnd = activities.get(j).end;
                } else {
                    sb = new StringBuilder();
                    sb.append("IMPOSSIBLE");
                    imp = true;
                    break;
                }
            }
            if (!imp) {
                for (int t : turn) {
                    if (t == 0) sb.append("C");
                    else sb.append("J");
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + sb.toString());
        }
    }
}
class Activity {
    int id;
    int start;
    int end;

    public Activity(int id, int start, int end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }
}
