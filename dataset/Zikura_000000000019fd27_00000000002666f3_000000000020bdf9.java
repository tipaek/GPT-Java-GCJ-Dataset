import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int numCases = s.nextInt();

        for(int caseNum=1;caseNum<=numCases;caseNum++) {
            int numActivities = s.nextInt();
            List<Activity> activities = new ArrayList<>();
            for(int i=0;i<numActivities;i++) {
                activities.add(new Activity(i, s.nextInt(), s.nextInt()));
            }

            System.out.printf("Case #%d: %s\n", caseNum, solve(activities));
        }
    }

    public static String solve(List<Activity> activities) {
        List<Activity> sortedActivities = new ArrayList<>(activities);
        sortedActivities.sort(Comparator.comparing(Activity::getStart).thenComparing(Activity::getEnd));
        Activity cameronCurrent = null;
        Activity jaimieCurrent = null;
        Map<Activity, String> activityMap = new HashMap<>();
        for(Activity activity : sortedActivities) {
            if(cameronCurrent==null || cameronCurrent.end <= activity.start) {
                activityMap.put(activity, "C");
                cameronCurrent = activity;
            } else if(jaimieCurrent==null || jaimieCurrent.end <= activity.start) {
                activityMap.put(activity, "J");
                jaimieCurrent = activity;
            } else {
                return "IMPOSSIBLE";
            }
        }
        StringBuilder result = new StringBuilder();
        for(Activity activity : activities) {
            result.append(activityMap.get(activity));
        }

        return result.toString();
    }

    public static class Activity {
        private final int num;
        final int start;
        final int end;

        public Activity(int num, int start, int end) {
            this.num = num;
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
            return num == activity.num &&
                    start == activity.start &&
                    end == activity.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num, start, end);
        }
    }
}
