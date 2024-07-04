import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private static class TooManyRespsException extends Exception {
        public TooManyRespsException(String message) {
            super(message);
        }
    }

    public class Activity {
        private final int index;
        private final int start;
        private final int end;
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

    public static void main(String[] args) throws FileNotFoundException {
        Solution solution = new Solution();
        Scanner sc = new Scanner(new File("resources/input1.txt"));
        // Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < T; t++) {
            List<Activity> activities = new ArrayList<>();
            int nbActivities = Integer.parseInt(sc.nextLine());
            for (int a = 0; a < nbActivities; a++) {
                String[] tabAct = sc.nextLine().split(" ");
                activities.add(solution.new Activity(tabAct[0], tabAct[1], a));
            }

            boolean impossible = false;
            for (Activity activity : activities) {
                List<Activity> overlappingActivities = getOverlappingActivities(activity, activities);
                if (overlappingActivities.isEmpty()) {
                    activity.setResponsable("J");
                } else {
                    Set<String> resps = findResponsablesForActivities(overlappingActivities);
                    if (resps.size() > 1) {
                        impossible = true;
                        break;
                    }
                    String resp = resps.iterator().hasNext() ? resps.iterator().next() : null;
                    activity.setResponsable(resp != null && resp.equals("J") ? "C" : "J");
                }
            }

            String result = impossible ? "IMPOSSIBLE" :
                    activities.stream().map(Activity::getResponsable).collect(Collectors.joining(""));

            System.out.printf("Case #%d: %s%n", t + 1, result);
        }
    }

    private static Set<String> findResponsablesForActivities(List<Activity> overlappingActivities) {
        return overlappingActivities.stream()
                .map(Activity::getResponsable)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    private static List<Activity> getOverlappingActivities(Activity activity, List<Activity> activities) {
        return activities.stream()
                .filter(act -> act != activity && overlap(act.start, act.end, activity.start, activity.end))
                .collect(Collectors.toList());
    }

    public static boolean overlap(int start1, int end1, int start2, int end2) {
        return (start2 >= start1 && start2 < end1) || (start1 >= start2 && start1 < end2);
    }
}