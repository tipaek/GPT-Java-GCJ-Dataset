import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
import java.util.Comparator;

public class Solution {


    static class Activity {
        private int startTime;
        private int endTime;

        public Activity(int startTime, int endTime) {
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
    }


    public static boolean doTheyOverlap(int start1, int end1, int start2, int end2) {
        //non overlapping intervals
        if (end2 < end1 && end2 < start1) {
            return false;
            //overlapping intervals
        } else if (start2 < start1 && end2 <= start1) {
            return false;
        } else if (start2 < end1 && start2 >= start1) {
            return true;
            //overlapping intervals
        } else if (start2 < end1 && end1 > start1) {
            return true;
        } else {
            return false;
        }
    }





    public static boolean containsOverlappingActivity(HashSet<Activity> hs, Activity act) {
        int startTime = act.getStartTime();
        int endTime = act.getEndTime();
        for (Activity a : hs) {
            if (doTheyOverlap(a.getStartTime(), a.getEndTime(), startTime, endTime)) {
                //if true they do overlap
                return true;
            } else {
                continue;
            }
        }
        return false;
    }



    public static String checkIntervals(ArrayList<Activity> a) {
        StringBuilder sb = new StringBuilder();
        HashSet<Activity> actForJ = new HashSet<>();
        HashSet<Activity> actForC = new HashSet<>();

        for (int i = 0; i < a.size(); i++) {
            int startTime = a.get(i).getStartTime();
            int endTime = a.get(i).getEndTime();
            if (!containsOverlappingActivity(actForC, a.get(i))) {
                sb.append('C');
                actForC.add(a.get(i));
                continue;
            } else if (!containsOverlappingActivity(actForJ, a.get(i))) {
                //if no overlapping activity, print J
                sb.append('J');
                actForJ.add(a.get(i));
                continue;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
            int activities = in.nextInt();
            ArrayList<Activity> act = new ArrayList<>();
            for (int k = 0; k < activities; k++) {
                Activity a = new Activity(in.nextInt(), in.nextInt());
                act.add(a);
            }
            Collections.sort(act, new Comparator<Activity>() {
                @Override
                public int compare(Activity o1, Activity o2) {
                    return o1.getStartTime() - o2.getStartTime();
                }
            });
            for (Activity e : act) {
                System.out.println(e.getStartTime() + " " + e.getEndTime());
            }
            System.out.println("Case #" + i + ": " + checkIntervals(act));
        }
    }
}