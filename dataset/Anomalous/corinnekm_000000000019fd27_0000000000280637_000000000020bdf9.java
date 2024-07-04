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
        private String responsable;

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
                    ", responsable='" + responsable + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++) {
            List<Activity> activities = new ArrayList<>();
            int nbActivities = Integer.parseInt(scanner.nextLine());
            for (int a = 0; a < nbActivities; a++) {
                String[] activityDetails = scanner.nextLine().split(" ");
                activities.add(solution.new Activity(activityDetails[0], activityDetails[1]));
            }

            boolean impossible = false;
            for (Activity activity : activities) {
                List<Activity> overlappingActivities = getOverlappingActivities(activity, activities);
                if (overlappingActivities.isEmpty()) {
                    activity.setResponsable("C");
                } else {
                    try {
                        String resp = findResponsable(overlappingActivities);
                        if ("C".equals(resp)) {
                            activity.setResponsable("J");
                        } else {
                            activity.setResponsable("C");
                        }
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

    private static String findResponsable(List<Activity> overlappingActivities) throws TooManyRespsException {
        Set<String> responsables = new HashSet<>();
        for (Activity activity : overlappingActivities) {
            if (activity.getResponsable() != null) {
                responsables.add(activity.getResponsable());
            }
        }
        if (responsables.size() > 1) {
            throw new TooManyRespsException("Too many responsables");
        }
        return responsables.stream().findFirst().orElse(null);
    }

    private static List<Activity> getOverlappingActivities(Activity activity, List<Activity> activities) {
        List<Activity> overlappingActivities = new ArrayList<>();
        for (Activity act : activities) {
            if (act != activity && overlaps(act.getStart(), act.end, activity.getStart(), activity.end)) {
                overlappingActivities.add(act);
            }
        }
        return overlappingActivities;
    }

    private static boolean overlaps(int start1, int end1, int start2, int end2) {
        return (start2 >= start1 && start2 < end1) || (start1 >= start2 && start1 < end2);
    }
}