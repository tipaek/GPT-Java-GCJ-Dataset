import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int k = 1; k <= t; ++k) {
            int n = in.nextInt();
            System.out.println( "Case #" + k + ": " + solve(in, n));
        }
    }

    private static String solve (Scanner in, int n) {
        StringBuilder res = new StringBuilder();
        ArrayList<Activity> sortedActivities = new ArrayList<>();
        ArrayList<Activity> activities = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();

            Activity activity = new Activity(start, end);
            activities.add(activity);
            sortedActivities.add(activity);
        }

        Collections.sort(sortedActivities);

        //Cameron
        Activity currentCameron = null;

        for(int i=0; i<sortedActivities.size(); i++) {
            if (!sortedActivities.get(i).overlap(currentCameron)) {
                currentCameron=sortedActivities.get(i);
                currentCameron.assignTo('C');
            }
        }

        //Jamie
        Activity currentJamie=null;
        for(int i=1; i<sortedActivities.size(); i++) {
            Activity currActivity = sortedActivities.get(i);
            if (!currActivity.isAssignedTo('C') && !currActivity.overlap(currentJamie)) {
                currentJamie=sortedActivities.get(i);
                currentJamie.assignTo('J');
            }
        }

        //res
        for(int i=0; i<activities.size(); i++) {
            Activity currActivity = activities.get(i);
            if (currActivity.isAssignedTo('C')) {
                res.append('C');
            } else if (currActivity.isAssignedTo('J')) {
                res.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }

        return res.toString();
    }

}

class Activity implements Comparable<Activity> {
    private int start;
    private int end;
    private char assign;

    public Activity ( int start, int end) {
        this.start = start;
        this.end = end;
        this.assign='N';
    }

    public boolean overlap (Activity a) {
        if(a==null) return false;
        return this.start < a.end && this.end > a.start;
    }

    public void assignTo (char me) {
        this.assign = me;
    }

    public boolean isAssignedTo (char it) {
        return this.assign == it;
    }

    @Override
    public int compareTo(Activity o) {
        return this.start - o.start;
    }
}

