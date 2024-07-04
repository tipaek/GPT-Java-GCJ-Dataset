import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            PriorityQueue<Activity> activities = new PriorityQueue<>();
            
            for (int j = 0; j < n; j++) {
                String[] times = reader.readLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int finish = Integer.parseInt(times[1]);
                activities.add(new Activity(start, finish, j));
            }
            
            boolean isImpossible = false;
            int cEnd = 0, jEnd = 0;
            char[] schedule = new char[n];
            
            while (!activities.isEmpty()) {
                Activity activity = activities.poll();
                
                if (activity.start >= cEnd) {
                    cEnd = activity.finish;
                    schedule[activity.index] = 'C';
                } else if (activity.start >= jEnd) {
                    jEnd = activity.finish;
                    schedule[activity.index] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            if (isImpossible) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", i + 1);
            } else {
                System.out.printf("Case #%d: %s%n", i + 1, new String(schedule));
            }
        }
    }

    static class Activity implements Comparable<Activity> {
        int start, finish, index;

        Activity(int start, int finish, int index) {
            this.start = start;
            this.finish = finish;
            this.index = index;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }
}