import java.util.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            int N = sc.nextInt();
            int C = 0;
            int J = 0;
            Activity sortedActivities[] = new Activity[N];
            Activity unsortedActivities[] = new Activity[N];
            for (int j = 0; j < N; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                Activity newActivity = new Activity(start, end);

                sortedActivities[j] = newActivity;
                unsortedActivities[j] = newActivity;

            }
            Arrays.sort(sortedActivities);

            StringBuilder sb = new StringBuilder();
            boolean flag = false;

            for(Activity a : sortedActivities) {
                if (C <= a.start) {
                    C = a.end;
                    a.setChild('C');
                } else if (J <= a.start) {
                    J = a.end;
                    a.setChild('J');
                } else {
                    sb.append("IMPOSSIBLE");
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                for(Activity a : unsortedActivities) {
                    sb.append(a.c);
                }
            }

            System.out.printf("Case #%d: %s\n", i + 1, sb.toString());
        }
    }

    public static class Activity implements Comparable<Activity>{
        int start;
        int end;
        char c;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Activity other) {
            return this.start - other.start;
        }

        public void setChild(char c) {
            this.c = c;
        }
    }
}
