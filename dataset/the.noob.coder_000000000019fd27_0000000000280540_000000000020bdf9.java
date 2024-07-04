import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solver solver = new Solver();

        int testCases = sc.nextInt();

        for (int testCase =0; testCase<testCases; testCase++) {
            int n = sc.nextInt();
            Activity[] activities = new Activity[n];

            for (int i =0; i<n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                activities[i] = new Activity(start, end);
            }
            System.out.println(solver.solve(activities, testCase+1));
        }
    }
}

class Solver {

    Activity[] activities;

    public String solve(Activity[] activities, int t) {
        this.activities = activities;
        Arrays.sort(this.activities);
        for(Activity activity: activities)
            System.out.println(activity.toString());

        return "Case #"+t+": "+solveRec(0, 0, 0);
    }

    String solveRec(int cEarlyTime, int jEarlyTime, int activityIndex) {
        if (activityIndex == activities.length) return "";

        Activity activity = activities[activityIndex];
        int startTime = activity.start;
        int endTime = activity.end;

        int minTime = Math.min(cEarlyTime, jEarlyTime);
        if (minTime > startTime)	return "IMPOSSIBLE";

        else {
            if (minTime == cEarlyTime) {
                String restString = solveRec(endTime, jEarlyTime, activityIndex+1);
                if("IMPOSSIBLE".equals(restString)) {
                    if (jEarlyTime < endTime) {
                        String restString2 = solveRec(cEarlyTime, endTime, activityIndex+1);
                        if( !"IMPOSSIBLE".equals(restString2)) {
                            return "J"+restString2;
                        }
                    }
                    return "IMPOSSIBLE";
                }
                return "C"+restString;
            }
            else {
                String restString = solveRec(cEarlyTime, endTime, activityIndex+1);
                if("IMPOSSIBLE".equals(restString)) {
                    if (cEarlyTime < endTime) {
                        String restString2 = solveRec(endTime, jEarlyTime, activityIndex+1);
                        if( !"IMPOSSIBLE".equals(restString2)) {
                            return "C"+restString2;
                        }
                    }
                    return "IMPOSSIBLE";
                }
                return "J"+restString;
            }
        }
    }
}

class Activity implements Comparable<Activity>{
    int start;
    int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Activity activity) {
        return this.start - activity.start;
    }

    @Override
    public String toString() {
        return start + " " + end;
    }

}