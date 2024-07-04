import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {

    static class Activity {
        final int start;
        final int end;
        final int pos;
        Activity(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    static class ActivityComparator implements Comparator<Activity> {
        @Override
        public int compare(Activity a1, Activity a2) {
            int diff = a1.start - a2.start;
            if (diff == 0) {
                return a1.end - a2.end;
            } else {
                return diff;
            }
        }
    }

    static void test(int cases, Scanner sc) {
        int activities = sc.nextInt();
        PriorityQueue<Activity> activityPriorityQueue = new PriorityQueue<>(new ActivityComparator());
        int cameron = 0;
        int jamie = 0;
        for (int i = 0; i < activities; i++) {
            activityPriorityQueue.add(new Activity(sc.nextInt(), sc.nextInt(), i));
        }
        String[] ans = new String[activities];
        while (!activityPriorityQueue.isEmpty()) {
            Activity next = activityPriorityQueue.poll();
            if (next.start >= cameron) {
                ans[next.pos] = "C";
                cameron = next.end;
            } else if (next.start >= jamie){
                ans[next.pos] = "J";
                jamie = next.end;
            } else {
                System.out.println("Case #" + cases + ": " + "IMPOSSIBLE");
                return;
            }
        }
        String schedule = "";
        for (String s : ans) {
            schedule += s;
        }
        System.out.println("Case #" + cases + ": " + schedule.toString());

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = sc.nextInt();
        for (int i = 1; i <= cases; i++) {
            test(i, sc);
        }
    }
}
