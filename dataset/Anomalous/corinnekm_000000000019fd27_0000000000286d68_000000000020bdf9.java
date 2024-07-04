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
        private int index;
        private int start;
        private int end;
        private String responsable;

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

        @Override
        public String toString() {
            return "Activity{" +
                    "index=" + index +
                    ", start=" + start +
                    ", end=" + end +
                    ", responsable='" + responsable + '\'' +
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
                activities.add(sol.new Activity(tabAct[0], tabAct[1], a));
            }

            boolean impossible = assignResponsables(activities);

            String result = impossible ? "IMPOSSIBLE" :
                    activities.stream().map(Activity::getResponsable).collect(Collectors.joining(""));
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }

    private static boolean assignResponsables(List<Activity> activities) {
        boolean impossible = false;
        for (Activity activity : activities) {
            List<Activity> overlappingActivities = getOverlapActivities(activity, activities);

            if (overlappingActivities.isEmpty()) {
                activity.setResponsable("J");
            } else {
                Set<String> resps = findRespForActivities(overlappingActivities);
                if (resps.size() > 1) {
                    impossible = true;
                }
                String resp = resps.iterator().hasNext() ? resps.iterator().next() : null;
                if ("J".equals(resp)) {
                    activity.setResponsable("C");
                } else {
                    activity.setResponsable("J");
                }
            }
        }
        return impossible;
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
            if (act != activity && overlap(act.start, act.end, activity.start, activity.end)) {
                overlappingActs.add(act);
            }
        }
        return overlappingActs;
    }

    private static boolean overlap(int begin1, int end1, int begin2, int end2) {
        return (begin2 >= begin1 && begin2 < end1) || (begin1 >= begin2 && begin1 < end2);
    }
}