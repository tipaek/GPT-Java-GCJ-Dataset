import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private static final String C = "C";
    private static final String J = "J";

    static class Activity {
        private final int start;
        private final int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Activity activity = (Activity) o;
            return start == activity.start &&
                    end == activity.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nCases = scanner.nextInt();
        for (int i = 1; i <= nCases; ++i) {
            int n = scanner.nextInt();
            Map<Activity, Integer> activities = new HashMap<>();
            List<Activity> orderedActivities = new ArrayList<>();
            String[] solution = new String[n];
            for (int j = 0; j < n; ++j) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Activity activity = new Activity(start, end);
                activities.put(activity, j);
                orderedActivities.add(activity);
            }
            Collections.sort(orderedActivities, (first, second) -> first.getStart() != second.getStart() ?
                    Integer.compare(first.getStart(), second.getStart()) : Integer.compare(first.getEnd(), second.getEnd()));
            boolean isFailed = false;
            Activity occupiedC = null;
            Activity occupiedJ = null;
            for (int j = 0; j < n; ++j) {
                if (occupiedC != null && orderedActivities.get(j).getStart() >= occupiedC.getEnd()) {
                    occupiedC = null;
                }
                if (occupiedJ != null && orderedActivities.get(j).getStart() >= occupiedJ.getEnd()) {
                    occupiedJ = null;
                }
                if (occupiedC == null) {
                    occupiedC = orderedActivities.get(j);
                    solution[activities.get(occupiedC)] = C;
                } else if (occupiedJ == null) {
                    occupiedJ = orderedActivities.get(j);
                    solution[activities.get(occupiedJ)] = J;
                } else {
                    isFailed = true;
                    break;
                }
            }
            System.out.println(String.format("Case #%d: %s", i, isFailed ? "IMPOSSIBLE" : Arrays.asList(solution).stream().collect(Collectors.joining())));
        }
    }

}
