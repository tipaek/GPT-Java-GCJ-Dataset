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
                String[] input = reader.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int finish = Integer.parseInt(input[1]);
                activities.offer(new Activity(start, finish, j));
            }
            
            boolean isImpossible = false;
            int endC = 0, endJ = 0;
            char[] result = new char[n];
            
            while (!activities.isEmpty()) {
                Activity current = activities.poll();
                
                if (current.start >= endC) {
                    endC = current.finish;
                    result[current.index] = 'C';
                } else if (current.start >= endJ) {
                    endJ = current.finish;
                    result[current.index] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + new String(result));
            }
        }
    }

    static class Activity implements Comparable<Activity> {
        int start;
        int finish;
        int index;

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