import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        int testCases = Integer.parseInt(in.readLine());
        StringBuilder result = new StringBuilder();
        
        for (int currCase = 1; currCase <= testCases; currCase++) {
            result.append("Case #").append(currCase).append(": ");
            
            int numActivities = Integer.parseInt(in.readLine());
            PriorityQueue<Activity> activityQueue = new PriorityQueue<>();
            
            for (int i = 0; i < numActivities; i++) {
                String[] input = in.readLine().split("\\s+");
                activityQueue.add(new Activity(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
            }
            
            boolean isPossible = true;
            Activity cameron = new Activity(-1, -1);
            Activity jamie = new Activity(-1, -1);
            StringBuilder schedule = new StringBuilder();
            
            while (!activityQueue.isEmpty()) {
                Activity current = activityQueue.poll();
                if (current.start >= cameron.end) {
                    schedule.append('C');
                    cameron = current;
                } else if (current.start >= jamie.end) {
                    schedule.append('J');
                    jamie = current;
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            result.append(isPossible ? schedule : "IMPOSSIBLE").append('\n');
        }
        
        out.print(result);
        in.close();
        out.close();
    }
}

class Activity implements Comparable<Activity> {
    int start, end;

    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Activity other) {
        if (this.start != other.start) {
            return Integer.compare(this.start, other.start);
        }
        return Integer.compare(this.end, other.end);
    }
}