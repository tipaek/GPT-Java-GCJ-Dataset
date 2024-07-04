import java.util.*;
import java.io.*;

class TimeSection {
    int startTime;
    int endTime;
}

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases

        for (int testCase = 1; testCase <= t; ++testCase) {
            int n = in.nextInt(); // Number of activities
            TimeSection[] activities = new TimeSection[n];
            StringBuilder schedule = new StringBuilder();
            ArrayList<TimeSection> cameronActivities = new ArrayList<>();
            ArrayList<TimeSection> jamieActivities = new ArrayList<>();
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                activities[i] = new TimeSection();
                activities[i].startTime = in.nextInt();
                activities[i].endTime = in.nextInt();

                if (i == 0) {
                    cameronActivities.add(activities[i]);
                    schedule.append("C");
                } else {
                    boolean assigned = false;

                    if (!hasOverlap(activities[i], cameronActivities)) {
                        cameronActivities.add(activities[i]);
                        schedule.append("C");
                        assigned = true;
                    }

                    if (!assigned && !hasOverlap(activities[i], jamieActivities)) {
                        jamieActivities.add(activities[i]);
                        schedule.append("J");
                        assigned = true;
                    }

                    if (!assigned) {
                        isPossible = false;
                        break;
                    }
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + schedule.toString());
            }
        }
    }

    static boolean hasOverlap(TimeSection t1, ArrayList<TimeSection> activities) {
        for (TimeSection t2 : activities) {
            if (t1.startTime < t2.endTime && t1.endTime > t2.startTime) {
                return true;
            }
        }
        return false;
    }
}