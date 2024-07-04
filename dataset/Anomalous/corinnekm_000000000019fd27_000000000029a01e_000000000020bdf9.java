import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Solution {

    public class Activity {
        int index;
        int start;
        int end;
        String responsable;

        public Activity(String start, String end, int index) {
            this.start = Integer.parseInt(start);
            this.end = Integer.parseInt(end);
            this.index = index;
        }

        public void setResponsable(String responsable) {
            this.responsable = responsable;
        }

        public String getResponsable() {
            return responsable;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < T; t++) {
            List<Activity> activities = new ArrayList<>();
            int nbActivities = Integer.parseInt(sc.nextLine());

            for (int a = 0; a < nbActivities; a++) {
                String[] tabAct = sc.nextLine().split(" ");
                activities.add(sol.new Activity(tabAct[0], tabAct[1], a));
            }

            boolean impossible = false;
            for (Activity activity : activities) {
                List<Activity> overlappingActivities = getOverlapActivities(activity, activities);

                if (overlappingActivities.isEmpty()) {
                    activity.setResponsable("J");
                } else {
                    Set<String> resps = findRespForActivities(overlappingActivities);
                    if (resps.size() > 1) {
                        impossible = true;
                        break;
                    }
                    String resp = resps.iterator().hasNext() ? resps.iterator().next() : null;
                    activity.setResponsable(resp != null && resp.equals("J") ? "C" : "J");
                }
            }

            String result = impossible ? "IMPOSSIBLE"
                    : activities.stream().map(Activity::getResponsable).collect(Collectors.joining(""));
            System.out.printf("Case #%d: %s%n", t + 1, result);
        }
    }

    private static Set<String> findRespForActivities(List<Activity> overlappingActivities) {
        Set<String> resps = new HashSet<>();
        for (Activity activity : overlappingActivities) {
            if (activity.getResponsable() != null) {
                resps.add(activity.getResponsable());
            }
        }
        return resps;
    }

    private static List<Activity> getOverlapActivities(Activity activity, List<Activity> activities) {
        List<Activity> overlappingActs = new ArrayList<>();
        for (Activity act : activities) {
            if (act != activity && overlap(act, activity)) {
                overlappingActs.add(act);
            }
        }
        return overlappingActs;
    }

    public static boolean overlap(Activity period, Activity selection) {
        return (period.end > selection.start && period.start < selection.end);
    }
}