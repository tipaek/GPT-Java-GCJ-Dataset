import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        List<String> results = new ArrayList<>();
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>(N);
            for (int i = 0; i < N; i++) {
                intervals.add(new Interval(scanner.nextInt(), scanner.nextInt()));
            }

            results.add(parenting(intervals));
        }

        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

        for (int i = 0; i < results.size(); i++) {
            pw.println(String.format("Case #%d: %s", (i + 1), results.get(i)));
            pw.flush();
        }

        pw.close();
        scanner.close();
    }

    private static class Interval implements Comparable<Interval> {
        private int start;
        private int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }

    private static class Activity {
        private char actor;
        private Interval interval;

        public Activity(char actor, Interval interval) {
            this.actor = actor;
            this.interval = interval;
        }
    }

    private static String parenting(List<Interval> intervals) {
        Collections.sort(intervals);

        Queue<Character> freeParents = new LinkedList<>();
        freeParents.add('J');
        freeParents.add('C');

        PriorityQueue<Activity> activityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.interval.end));

        StringBuilder schedule = new StringBuilder(intervals.size());
        for (Interval interval : intervals) {
            while (!activityQueue.isEmpty() && activityQueue.peek().interval.end <= interval.start) {
                Activity activity = activityQueue.poll();
                freeParents.add(activity.actor);
            }

            if (freeParents.isEmpty()) {
                return "IMPOSSIBLE";
            }

            Activity activity = new Activity(freeParents.poll(), interval);
            activityQueue.add(activity);
            schedule.append(activity.actor);
        }
        
        while(!activityQueue.isEmpty()) {
            Activity activity = activityQueue.poll();
            schedule.append(activity.actor);
        }

        return schedule.toString();
    }

}
