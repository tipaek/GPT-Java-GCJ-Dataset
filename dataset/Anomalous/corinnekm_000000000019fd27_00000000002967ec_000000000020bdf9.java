import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private static class TooManyRespsException extends Exception {
        public TooManyRespsException(String message) {
            super(message);
        }
    }

    public class Activity {
        private int start;
        private int end;
        private int index;
        private String responsible;

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

        @Override
        public String toString() {
            return "Activity{" +
                    "index=" + index +
                    ", start=" + start +
                    ", end=" + end +
                    ", responsible='" + responsible + '\'' +
                    '}';
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
                String[] activityDetails = sc.nextLine().split(" ");
                activities.add(sol.new Activity(activityDetails[0], activityDetails[1], a));
            }

            boolean impossible = false;

            for (Activity activity : activities) {
                List<Activity> overlappingActivities = getOverlapActivities(activity, activities);

                if (overlappingActivities.isEmpty()) {
                    activity.setResponsible("J");
                } else {
                    Set<String> resps = findResponsibleForActivities(overlappingActivities);
                    String resp = resps.stream().findFirst().orElse(null);

                    if (resps.size() > 1) {
                        impossible = true;
                        break;
                    }

                    if ("J".equals(resp)) {
                        activity.setResponsible("C");
                    } else {
                        activity.setResponsible("J");
                    }
                }
            }

            String result = impossible ? "IMPOSSIBLE"
                    : activities.stream().map(Activity::getResponsible).collect(Collectors.joining(""));

            System.out.printf("Case #%d: %s%n", t + 1, result);
        }
    }

    private static Set<String> findResponsibleForActivities(List<Activity> overlappingActivities) {
        return overlappingActivities.stream()
                .map(Activity::getResponsible)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    private static List<Activity> getOverlapActivities(Activity activity, List<Activity> activities) {
        return activities.stream()
                .filter(act -> act != activity && overlap(act.getStart(), act.end, activity.getStart(), activity.end))
                .collect(Collectors.toList());
    }

    public static boolean overlap(int start1, int end1, int start2, int end2) {
        return (start2 >= start1 && start2 < end1) || (start1 > start2 && start1 < end2);
    }
}