import java.io.*;
import java.util.*;

public class Solution {
    private static BufferedReader br;
    private static StringTokenizer sc;
    private static PrintWriter out;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        sc = new StringTokenizer("");

        TaskD solver = new TaskD();
        solver.solve();

        br.close();
        out.close();
    }

    static class Activity {
        int id;
        char person;
        int start;
        int end;
    }

    static class TaskD {
        public void solve() throws IOException {
            int t = nextInt();

            for (int ii = 0; ii < t; ii++) {
                int n = nextInt();
                Activity[] activities = new Activity[n];
                List<Activity> activityList = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    activities[i] = new Activity();
                    activities[i].start = nextInt();
                    activities[i].end = nextInt();
                    activities[i].id = i;
                    activityList.add(activities[i]);
                }

                Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

                List<Activity> timeline = new ArrayList<>();
                Activity firstActivity = new Activity();
                firstActivity.person = activities[0].person = 'C';
                firstActivity.start = activities[0].start;
                firstActivity.end = activities[0].end;
                firstActivity.id = 1;
                timeline.add(firstActivity);

                boolean isImpossible = false;
                List<Activity> newTimeline = new ArrayList<>();

                for (int i = 1; i < n; i++) {
                    boolean intersect = false;

                    for (int j = 0; j < timeline.size(); j++) {
                        if (activities[i].start < timeline.get(j).end && activities[i].end > timeline.get(j).start) {
                            intersect = true;

                            if (timeline.get(j).id == 2) {
                                out.println("Case #" + (ii + 1) + ": IMPOSSIBLE");
                                isImpossible = true;
                                break;
                            }

                            activities[i].person = (timeline.get(j).person == 'C') ? 'J' : 'C';

                            int[] times = {activities[i].start, activities[i].end, timeline.get(j).start, timeline.get(j).end};
                            Arrays.sort(times);

                            if (times[0] != times[1]) {
                                Activity act = new Activity();
                                act.start = times[0];
                                act.end = times[1];
                                act.id = 1;
                                act.person = (activities[i].start > timeline.get(j).start) ? timeline.get(j).person : activities[i].person;
                                newTimeline.add(act);
                            }

                            Activity act = new Activity();
                            act.start = times[1];
                            act.end = times[2];
                            act.id = 2;
                            newTimeline.add(act);

                            if (times[2] != times[3]) {
                                act = new Activity();
                                act.start = times[2];
                                act.end = times[3];
                                act.id = 1;
                                act.person = (activities[i].end < timeline.get(j).end) ? timeline.get(j).person : activities[i].person;
                                newTimeline.add(act);
                            }

                            timeline.remove(j);
                            j--;
                        }
                    }

                    if (isImpossible) break;

                    if (intersect) {
                        timeline.addAll(newTimeline);
                        newTimeline.clear();
                    } else {
                        Activity act = new Activity();
                        act.person = activities[i].person = 'C';
                        act.start = activities[i].start;
                        act.end = activities[i].end;
                        act.id = 1;
                        timeline.add(act);
                    }
                }

                if (!isImpossible) {
                    StringBuilder result = new StringBuilder();
                    for (Activity activity : activityList) {
                        result.append(activity.person);
                    }
                    out.println("Case #" + (ii + 1) + ": " + result);
                }
            }
        }
    }

    private static String nextToken() throws IOException {
        while (!sc.hasMoreTokens()) {
            String s = br.readLine();
            if (s == null) return null;
            sc = new StringTokenizer(s.trim());
        }
        return sc.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
}