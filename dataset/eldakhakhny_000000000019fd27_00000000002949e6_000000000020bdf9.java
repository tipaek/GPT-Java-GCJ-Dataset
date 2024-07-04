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
                activities.add(new Activity(start,end, i));
            }
            activities.sort(Activity::compareTo);
            int cameronEnd = 0;
            int jamieEnd = 0;
            boolean flag = false;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <n ; i++) {
                Activity ac = activities.get(i);
                if (cameronEnd <= activities.get(i).startingTime ){
                    activities.get(i).setOwner('C');
                    cameronEnd = activities.get(i).endTime;
                } else if (jamieEnd <= activities.get(i).startingTime  ){
                   activities.get(i).setOwner('J');
                   jamieEnd = activities.get(i).endTime;
                }else  {
                    sb = new StringBuilder();
                    sb.append("IMPOSSIBLE");
                    flag = true;
                    break;
                }
            }

            int x = t+1;

            if (flag){
                System.out.println("Case #" + x + ": " +sb.toString());
             } else {
                Activity result[] = new Activity[n];

                for (int i = 0; i <n ; i++){
                    result[activities.get(i).index] = activities.get(i);
                }
                for (int i = 0; i <n ; i++){
                    sb.append(result[i].owner);
                }
                System.out.println("Case #" + x + ": " +sb.toString());
            }

        }
    }
    static class Activity implements Comparable<Activity>{
        int startingTime;
        int endTime;
        int index;

        public char getOwner() {
            return owner;
        }

        public void setOwner(char owner) {
            this.owner = owner;
        }

        char owner;

        public Activity(int startingTime, int endTime, int index) {
            this.startingTime = startingTime;
            this.endTime = endTime;
            this.index = index;
        }

        // comparing starting time
        @Override
        public int compareTo(Activity o) {
            return startingTime - o.startingTime;
        }
        public int indexer(Activity o) {
            return index - o.index;
        }
    }

}
