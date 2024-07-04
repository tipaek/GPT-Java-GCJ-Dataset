import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int activitiesCount = in.nextInt();
            List<ActivityTime> activityTimes = new ArrayList<ActivityTime>();
            for (int j = 0; j < activitiesCount; ++j) {
                activityTimes.add(new ActivityTime(in.nextInt(), in.nextInt(), j));
            }
            activityTimes.sort((o1, o2) -> o1.startTime.compareTo(o2.startTime));

            String result = solve(activitiesCount, activityTimes);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static class ActivityTime {
        public final Integer startTime;
        public final Integer endTime;
        public final Integer order;

        public ActivityTime(Integer startTime, Integer endTime, Integer order) {
            super();
            this.startTime = startTime;
            this.endTime = endTime;
            this.order = order;
        }
    }

    private static String solve(int activitiesCount, List<ActivityTime> activityTimes) {
        final String IMPOSSIBLE = "IMPOSSIBLE";
        String[] result = new String[activitiesCount];
        String currentParent = "C";
        int lastParentCIndex = 0;
        int lastParentJIndex = 0;
        int lastOtherParentIndex;

        for (int k = 0; k < activitiesCount; ++k) {
            ActivityTime currentActivity = activityTimes.get(k);
            if (k == 0) {
                result[currentActivity.order] = currentParent;
                lastParentCIndex = k;
            } else {
                ActivityTime previousActivity = activityTimes.get(k - 1);
                if (previousActivity.endTime <= currentActivity.startTime) {
                    result[currentActivity.order] = currentParent;
                    if (currentParent == "C") {
                        lastParentCIndex = k;
                    } else {
                        lastParentJIndex = k;
                    }
                } else {
                    if (k > 1) {
                        if (currentParent == "C") {
                            lastOtherParentIndex = lastParentJIndex;
                        } else {
                            lastOtherParentIndex = lastParentCIndex;
                        }
                        if (activityTimes.get(lastOtherParentIndex).endTime <= currentActivity.startTime) {
                            result[currentActivity.order] = currentParent == "C" ? "J" : "C";
                            currentParent = currentParent == "C" ? "J" : "C";
                            if (currentParent == "C") {
                                lastParentCIndex = k;
                            } else {
                                lastParentJIndex = k;
                            }
                        } else {
                            return IMPOSSIBLE;
                        }
                    } else {
                        result[currentActivity.order] = currentParent == "C" ? "J" : "C";
                        currentParent = currentParent == "C" ? "J" : "C";
                        if (currentParent == "C") {
                            lastParentCIndex = k;
                        } else {
                            lastParentJIndex = k;
                        }
                    }
                }
            }
        }
        return String.join("", result);
    }
}
