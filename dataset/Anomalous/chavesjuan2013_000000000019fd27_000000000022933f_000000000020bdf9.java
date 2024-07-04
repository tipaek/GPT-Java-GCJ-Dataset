import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++) {
            int activityCount = Integer.parseInt(br.readLine());
            ArrayList<Activity> activities = new ArrayList<>();
            ArrayList<Pair> events = new ArrayList<>();

            for (int j = 0; j < activityCount; j++) {
                String[] times = br.readLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                activities.add(new Activity(start, end, j));
                events.add(new Pair(start, 1));
                events.add(new Pair(end, 0));
            }

            Collections.sort(activities, Comparator.comparingInt((Activity a) -> a.start)
                                                   .thenComparingInt(a -> a.end));
            Collections.sort(events, Comparator.comparingInt((Pair p) -> p.time)
                                               .thenComparingInt(p -> p.type));

            int concurrentActivities = 0;
            boolean possible = true;

            for (Pair event : events) {
                if (event.type == 0) {
                    concurrentActivities--;
                } else {
                    concurrentActivities++;
                }

                if (concurrentActivities > 2) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                activities.get(0).responsible = "C";
                Activity cameronCurrent = activities.get(0);

                for (int k = 1; k < activityCount; k++) {
                    if (overlaps(cameronCurrent, activities.get(k))) {
                        activities.get(k).responsible = "J";
                    } else {
                        activities.get(k).responsible = "C";
                        cameronCurrent = activities.get(k);
                    }
                }

                activities.sort(Comparator.comparingInt(a -> a.id));
                StringBuilder result = new StringBuilder();

                for (Activity activity : activities) {
                    result.append(activity.responsible);
                }

                System.out.println("Case #" + (i + 1) + ": " + result.toString());
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }

    static boolean overlaps(Activity a1, Activity a2) {
        return !(a2.end <= a1.start || a1.end <= a2.start);
    }

    static class Activity {
        int start, end, id;
        String responsible;

        public Activity(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }
    }

    static class Pair {
        int time, type;

        public Pair(int time, int type) {
            this.time = time;
            this.type = type;
        }
    }
}