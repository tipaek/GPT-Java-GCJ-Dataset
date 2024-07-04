import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public class Activity {
        int index;
        int start;
        int end;
        String responsible;

        public Activity(String start, String end, int index) {
            this.start = Integer.parseInt(start);
            this.end = Integer.parseInt(end);
            this.index = index;
        }

        public void setResponsible(String responsible) {
            this.responsible = responsible;
        }

        public String getResponsible() {
            return responsible;
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
                Activity activityObj = sol.new Activity(tabAct[0], tabAct[1], a);
                activities.add(activityObj);
            }

            boolean impossible = assignResponsibilities(activities);

            String result = impossible ? "IMPOSSIBLE"
                    : activities.stream().map(Activity::getResponsible).collect(Collectors.joining(""));

            System.out.printf("Case #%d: %s%n", t + 1, result);
        }
    }

    private static boolean assignResponsibilities(List<Activity> activities) {
        boolean impossible = false;

        for (Activity activity : activities) {
            List<Activity> overlappingActivities = getOverlappingActivities(activity, activities);

            if (overlappingActivities.isEmpty()) {
                activity.setResponsible("J");
            } else {
                Set<String> responsibles = findResponsiblesForActivities(overlappingActivities);

                if (responsibles.size() > 1) {
                    impossible = true;
                }

                String responsible = responsibles.stream().findFirst().orElse(null);
                if ("J".equals(responsible)) {
                    activity.setResponsible("C");
                } else {
                    activity.setResponsible("J");
                }
            }
        }

        return impossible;
    }

    private static Set<String> findResponsiblesForActivities(List<Activity> overlappingActivities) {
        return overlappingActivities.stream()
                .map(Activity::getResponsible)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    private static List<Activity> getOverlappingActivities(Activity activity, List<Activity> activities) {
        return activities.stream()
                .filter(act -> !act.equals(activity) && overlap(act, activity))
                .collect(Collectors.toList());
    }

    public static boolean overlap(Activity period, Activity selection) {
        return (period.end > selection.start && period.start < selection.end);
    }
}