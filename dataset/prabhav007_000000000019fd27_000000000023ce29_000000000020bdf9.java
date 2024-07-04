import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        ActivityComparator activityComparator = new ActivityComparator();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<Activity> activityList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                Activity activity = new Activity(startTime, endTime);
                activityList.add(activity);
            }
            List<Activity> sortedActivityList = new ArrayList<>(activityList);
            Map<Activity, String> activityAssignmentMap = new HashMap<>();
            Activity currentActivityForC = null;
            Activity currentActivityForJ = null;
            Boolean impossibleFlag = false;
            Collections.sort(sortedActivityList, activityComparator);
            for (int j = 0; j < sortedActivityList.size(); j++) {
                Activity activity = sortedActivityList.get(j);
                if (null == currentActivityForC) {
                    currentActivityForC = activity;
                    activityAssignmentMap.put(activity, "C");
                    continue;
                }
                if (null != currentActivityForC) {
                    if (currentActivityForC.before(activity)) {
                        currentActivityForC = activity;
                        activityAssignmentMap.put(activity, "C");
                        continue;
                    }
                }
                if (null == currentActivityForJ) {
                    currentActivityForJ = activity;
                    activityAssignmentMap.put(activity, "J");
                    continue;
                }
                if (null != currentActivityForJ) {
                    if (currentActivityForJ.before(activity)) {
                        currentActivityForJ = activity;
                        activityAssignmentMap.put(activity, "J");
                        continue;
                    }
                }
                impossibleFlag = true;
                break;
            }
            if(impossibleFlag) {
                System.out.println("Case #" + (i) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (i) + ": ");
                for(Activity activity:activityList) {
                    System.out.print(activityAssignmentMap.get(activity));
                }
                System.out.println("");
            }
//            System.out.println(sortedActivityList);
        }
    }

    static class ActivityComparator implements Comparator<Activity> {
        @Override
        public int compare(Activity o1, Activity o2) {
            if (o1.startTime < o2.startTime) {
                return -1;
            } else if (o1.startTime > o2.startTime) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    static class Activity {
        private int startTime;
        private int endTime;

        Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }

        public boolean before(Activity activity) {
            if (this.endTime <= activity.startTime) {
//                System.out.println("true");
                return true;
            }
//            System.out.println("false");
            return false;
        }
    }
}
