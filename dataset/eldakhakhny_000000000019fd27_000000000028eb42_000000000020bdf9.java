import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 0; t < cases; t++) {
            int n = in.nextInt();
            ArrayList<Activity> activities =  new ArrayList<Activity>();
            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities.add(new Activity(start,end));
            }
            activities.sort(Activity::compareTo);
            int cameronEnd = 0;
            int jamieEnd = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <n ; i++) {
                if (cameronEnd <= activities.get(i).startingTime ){
                    sb.append('C');
                    cameronEnd = activities.get(i).endTime;
                } else if (jamieEnd <= activities.get(i).startingTime  ){
                    sb.append('J');
                    jamieEnd = activities.get(i).endTime;
                }else {
                    sb = new StringBuilder();
                    sb.append("IMPOSSIBLE");
                    break;
                }
            }
            int x = t+1;
            System.out.println("Case #" + x + ": " +sb.toString());

        }
    }
    static class Activity implements Comparable<Activity>{
        int startingTime;
        int endTime;

        public Activity(int startingTime, int endTime) {
            this.startingTime = startingTime;
            this.endTime = endTime;
        }

        // comparing starting time
        @Override
        public int compareTo(Activity o) {
            return startingTime - o.startingTime;
        }
    }
}
