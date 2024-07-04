import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {

    static class Activity {
        final int start;
        final int end;
        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class ActivityComparator implements Comparator<Activity> {
        @Override
        public int compare(Activity a1, Activity a2) {
            return a1.start - a2.start;
        }
    }

    static void test(int cases, Scanner sc) {
        int activities = sc.nextInt();
        PriorityQueue<Activity> activityPriorityQueue = new PriorityQueue<>(new ActivityComparator());
        StringBuilder schedule = new StringBuilder();
        int cameron = 0;
        int jamie = 0;
        for (int i = 0; i < activities; i++) {
            activityPriorityQueue.add(new Activity(sc.nextInt(), sc.nextInt()));
        }
        while (!activityPriorityQueue.isEmpty()) {
            Activity next = activityPriorityQueue.poll();
            if (next.start >= cameron) {
                schedule.append("C");
                cameron = next.end;
            } else if (next.start >= jamie){
                schedule.append("J");
                jamie = next.end;
            } else {
                System.out.println("Case #" + cases + ": " + "IMPOSSIBLE");
                return;
            }
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
