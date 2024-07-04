import java.util.Scanner;
import java.util.PriorityQueue;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
          
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = in.nextInt();
        
        for (int i=1; i <= t; i++) {
            
             String result = "J";
            int numOfActivities = in.nextInt();
            PriorityQueue<Activity> actQueue = new PriorityQueue<>();
            
            for (int j = 0; j < numOfActivities; j++) {
                actQueue.add(new Activity(in.nextInt(), in.nextInt()));
            }
            
            Activity currentJActivity = actQueue.poll();
            Activity currentCActivity = new Activity(0, 0);
            
            while (!actQueue.isEmpty()) {
                Activity act = actQueue.poll();
                if (act.noClash(currentJActivity)) {
                    currentJActivity = act;
                    result += "J";
                } else if (act.noClash(currentCActivity)) {
                    currentCActivity = act;
                    result += "C";
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }
            
            System.out.printf("Case #%d: %s\n", i, result);
        }
    }
 
}

class Activity implements Comparable<Activity> {
    int start;
    int end;
    
    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    public int compareTo(Activity a) {
        return this.start > a.start
            ? 1
            : this.start < a.start
                ? -1
                : 0;
    }
    
    boolean noClash(Activity a) {
        return a.start >= this.end || this.start >= a.end;
    }
}
        