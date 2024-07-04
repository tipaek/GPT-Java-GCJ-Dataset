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
        int start;
        int end;
        String responsable;

        public Activity(String start, String end) {
            this.start = Integer.parseInt(start);
            this.end = Integer.parseInt(end);
        }

        public void setResponsable(String responsable) {
            this.responsable = responsable;
        }

        public String getResponsable() {
            return responsable;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "start=" + start +
                    ", end=" + end +
                    ", responsable='" + responsable + '\'' +
                    '}';
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
            System.out.println("********************************");
            int nbActivities = Integer.parseInt(sc.nextLine());
            for (int a = 0; a < nbActivities; a++) {
                String[] tabAct = sc.nextLine().split(" ");
                activities.add(sol.new Activity(tabAct[0], tabAct[1]));
            }

            boolean impossible = false;
            for (Activity activity : activities) {
                List<Activity> overlappingActivities = getOverlapActivities(activity, activities);

                if (overlappingActivities.isEmpty()) {
                    activity.setResponsable("C");
                } else {
                    try {
                        String resp = findRespForActivities(overlappingActivities);
                        activity.setResponsable(resp != null && resp.equals("C") ? "J" : "C");
                    } catch (TooManyRespsException e) {
                        impossible = true;
                        break;
                    }
                }
            }

            String result = impossible ? "IMPOSSIBLE" : activities.stream()
                    .map(Activity::getResponsable)
                    .collect(Collectors.joining(""));
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }

    private static String findRespForActivities(List<Activity> overlappingActivities) throws TooManyRespsException {
        Set<String> resps = new HashSet<>();
        for (Activity activity : overlappingActivities) {
            if (activity.getResponsable() != null) {
                resps.add(activity.getResponsable());
            }
        }
        if (resps.size() > 1) {
            throw new TooManyRespsException("Too many resps");
        }
        return resps.isEmpty() ? null : resps.iterator().next();
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

    public static boolean overlap(int start1, int end1, int start2, int end2) {
        return (start2 >= start1 && start2 < end1) || (start1 > start2 && start1 < end2);
    }
}