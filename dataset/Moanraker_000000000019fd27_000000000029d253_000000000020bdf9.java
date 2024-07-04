import java.io.IOException;
import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            oneRun(i);
        }
    }

    private static void oneRun(int num) {
        int N = sc.nextInt();

        Activity[] activities = new Activity[N];
        for (int i = 0; i < N; i++) {
            activities[i] = new Activity(sc.nextInt(), sc.nextInt(), i);
        }
        Arrays.sort(activities);

        System.out.print(String.format("Case #%s: ", num));

        char[] names = new char[]{'C', 'J'};
        Activity[] assignment = new Activity[2];
        outer:
        for (int i = 0; i < activities.length; i++) {
            Activity a = activities[i];

            for (int j = 0; j < assignment.length; j++) {
                if (assignment[j] != null) {
                    if (assignment[j].end <= a.start) {
                        assignment[j] = null;
                    }
                }

                if (assignment[j] == null) {
                    assignment[j] = a;
                    a.assignee = names[j];
                    continue outer;
                }
            }

            System.out.println("IMPOSSIBLE");
            return;
        }

        Arrays.sort(activities, Activity.indexComp);
        for (int i = 0; i < activities.length; i++) {
            System.out.print(activities[i].assignee);
        }

        System.out.println();
    }

    static class Activity implements Comparable<Activity> {
        int start, end, index;
        char assignee;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Activity o) {
            return Integer.compare(start, o.start);
        }

        public static Comparator<Activity> indexComp = Comparator.comparingInt(o -> o.index);
    }
}