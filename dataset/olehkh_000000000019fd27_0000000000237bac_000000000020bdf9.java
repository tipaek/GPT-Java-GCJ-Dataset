import java.util.*;
import java.io.*;

class Activity implements Comparable<Activity> {
    int start;
    int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    public int compareTo(Activity o) {
        return this.start - o.start;
    }
}


public class Solution {

    private final static String C = "C";
    private final static String J = "J";
    private final static String IMPOSSIBLE = "IMPOSSIBLE";


   private static List<Activity> activities = new ArrayList<>();

   private static String ppr(int caseNum, List<Activity> activities) {
       StringBuilder result = new StringBuilder();
       boolean cBusy = false;
       boolean jBusy = false;
       int cEndTime = -1;
       int jEndTime = -1;

       for (Activity activity : activities) {
            if (cBusy && activity.start >= cEndTime) {
                cEndTime = activity.end;
                result.append(C);
            } else if (jBusy && activity.start >= jEndTime) {
                jEndTime = activity.end;
                result.append(J);
            } else if (!cBusy) {
                cEndTime = activity.end;
                cBusy = true;
                result.append(C);
            } else if (!jBusy) {
                jEndTime = activity.end;
                jBusy = true;
                result.append(J);
            } else {
                result = new StringBuilder();
                result.append(IMPOSSIBLE);
                break;
            }
       }
       return "Case #" + caseNum + ": " + result.toString();
   }


    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
           int cases = in.nextInt();
           activities = new ArrayList<>();
           for (int c = 0; c < cases; c++) {
               activities.add(new Activity(in.nextInt(), in.nextInt()));
           }
           Collections.sort(activities);
            System.out.println(ppr(i, activities));
        }
    }
}