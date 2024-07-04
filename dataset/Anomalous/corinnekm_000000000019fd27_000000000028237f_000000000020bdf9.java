import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static class TooManyRespsException extends Exception {
        public TooManyRespsException(String message) {
            super(message);
        }
    }

    public class Activity {
        private int start;
        private int end;
        private String responsible;

        public Activity(String start, String end) {
            this.start = Integer.parseInt(start);
            this.end = Integer.parseInt(end);
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
                    "start=" + start +
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
                String[] tabAct = sc.nextLine().split(" ");
                activities.add(sol.new Activity(tabAct[0], tabAct[1]));
            }

            boolean impossible = false;

            for (Activity activity : activities) {
                List<Activity> overlappingActivities = getOverlapActivities(activity, activities);

                if (overlappingActivities.isEmpty()) {
                    activity.setResponsible("J");
                } else {
                    Set<String> resps = findResponsibleForActivities(overlappingActivities);
                    if (resps.size() > 1) {
                        impossible = true;
                        break;
                    }
                    String resp = resps.iterator().hasNext() ? resps.iterator().next() : null;
                    if ("J".equals(resp)) {
                        activity.setResponsible("C");
                    } else {
                        activity.setResponsible("J");
                    }
                }
            }

            String result = impossible ? "IMPOSSIBLE"
                    : activities.stream().map(Activity::getResponsible).collect(Collectors.joining(""));
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }

    private static Set<String> findResponsibleForActivities(List<Activity> overlappingActivities) {
        Set<String> resps = new HashSet<>();
        for (Activity activity : overlappingActivities) {
            if (activity.getResponsible() != null) {
                resps.add(activity.getResponsible());
            }
        }
        return resps;
    }

    private static List<Activity> getOverlapActivities(Activity activity, List<Activity> activities) {
        List<Activity> overlappingActivities = new ArrayList<>();
        for (Activity act : activities) {
            if (act != activity && isOverlapping(act.getStart(), act.end, activity.getStart(), activity.end)) {
                overlappingActivities.add(act);
            }
        }
        return overlappingActivities;
    }

    private static boolean isOverlapping(int start1, int end1, int start2, int end2) {
        return (start2 > start1 && start2 < end1) || (start1 > start2 && start1 < end2);
    }
}