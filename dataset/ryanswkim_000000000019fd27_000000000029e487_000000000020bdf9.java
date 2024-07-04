import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        outer: for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            ArrayList<Activity> activities = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                activities.add(new Activity(in.nextInt(), in.nextInt(), j));
            }
            activities.sort((a,b) -> a.start - b.start);
            char[] ret = new char[n];
            Activity C = new Activity(-1, -1, -1);
            Activity J = new Activity(-1, -1, -1);
            for (int j = 0; j < activities.size(); j++) {
                Activity cur = activities.get(j);
                if (cur.start < J.end && cur.start < C.end){
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    continue outer;
                }
                if (cur.start >= C.end){
                    ret[cur.index] = 'C';
                    C = cur;
                } else {
                    ret[cur.index] = 'J';
                    J = cur;
                }
            }
            System.out.println("Case #" + i + ": " + new String(ret));
        }
    }
    private static class Activity {
        int start, end, index;
        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}
