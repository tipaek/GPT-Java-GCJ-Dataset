import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
          
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = in.nextInt();
        
        for (int i=1; i <= t; i++) {
            
             String result = "J";
            int numOfActivities = in.nextInt();
            PriorityQueue<Activity> actQueue = new PriorityQueue<>();
            Activity[] sortedActs = new Activity[numOfActivities];
            
            for (int j = 0; j < numOfActivities; j++) {
                actQueue.add(new Activity(in.nextInt(), in.nextInt(), j));
                sortedActs = actQueue.toArray(new Activity[0]);
            }
            
            Activity currentJActivity = actQueue.poll();
            Activity currentCActivity = new Activity(0, 0, 0);
            
            while (!actQueue.isEmpty()) {
                Activity act = actQueue.poll();
                if (act.noClash(currentJActivity)) {
                    act.doBy("J");
                    currentJActivity = act;
                } else if (act.noClash(currentCActivity)) {
                    act.doBy("C");
                    currentCActivity = act;
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }
            
            Arrays.sort(sortedActs, (a, b) -> {
                return a.index < b.index
                    ? -1
                    : 1;
                });
            if (result != "IMPOSSIBLE") {
                for (Activity a : sortedActs) {
                    result += a.doer;
                }
            }
            
            System.out.printf("Case #%d: %s\n", i, result);
        }
    }
 
}

class Activity implements Comparable<Activity> {
    int start;
    int end;
    int index;
    String doer = "";
    
    Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
    
    void doBy(String doer) {
        this.doer = doer;
    }
    
    @Override
    public int compareTo(Activity a) {
        return this.start > a.start
            ? 1
            : -1;
    }
    
    boolean noClash(Activity a) {
        return a.start >= this.end || this.start >= a.end;
    }
}
        