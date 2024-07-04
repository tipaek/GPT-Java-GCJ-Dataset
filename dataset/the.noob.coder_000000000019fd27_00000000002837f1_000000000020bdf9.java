import java.util.*;
import java.io.*;
import java.lang.*;

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
                activities[i] = new Activity(start, end, i);
            }
            System.out.println(solver.solve(activities, testCase+1));
        }
    }
}

class Solver {

    Activity[] activities;

    public String solve(Activity[] activities, int t) {
        this.activities = activities;
        Arrays.sort(this.activities, new SortByStart());

        return "Case #"+t+": "+solveFinal();
    }

    String solveFinal() {
        String solveRecVal = solveRec(0, 0 , 0);
        if ("IMPOSSIBLE".equals(solveRecVal))   return solveRecVal;
        else {
            Arrays.sort(activities, new SortByNum());
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0; i<activities.length; i++) {
                stringBuilder.append(activities[i].person);
            }
            return stringBuilder.toString();
        }
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
                    activity.person = null;
                    return "IMPOSSIBLE";
                }
                activity.person = "C";
                return "C"+restString;
            }
            else {
                String restString = solveRec(cEarlyTime, endTime, activityIndex+1);
                if("IMPOSSIBLE".equals(restString)) {
                    activity.person = null;
                    return "IMPOSSIBLE";
                }
                activity.person = "J";
                return "J"+restString;
            }
        }
    }
}

class Activity {
    int start;
    int end;
    int activityNum;
    String person;    //person who does this activity

    public Activity(int start, int end, int activityNum) {
        this.start = start;
        this.end = end;
        this.activityNum = activityNum;
    }

    @Override
    public String toString() {
        return start + " " + end;
    }
}

class SortByStart implements Comparator<Activity>{

    @Override
    public int compare (Activity o1, Activity o2) {
        return o1.start -o2.start;
    }
}

class SortByNum implements Comparator<Activity>{

    @Override
    public int compare (Activity o1, Activity o2) {
        return o1.activityNum - o2.activityNum;
    }
}