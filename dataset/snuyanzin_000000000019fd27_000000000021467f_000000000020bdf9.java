
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCases = Integer.parseInt(br.readLine());
            for (int i = 1; i <= numberOfCases; i++) {
                int numberOfActivities = Integer.parseInt(br.readLine());
                PriorityQueue<Activity> queue = new PriorityQueue<>();
                for (int j = 0; j < numberOfActivities; j++) {
                    String[] input = br.readLine().split(" ");
                    Activity activity = new Activity(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
                    queue.add(activity);
                }
                Activity cameron = null;
                Activity jamie = null;
                StringBuilder sb = new StringBuilder(numberOfActivities);
                while (!queue.isEmpty()) {
                    Activity activity = queue.poll();
                    if (cameron == null || cameron.end <= activity.start) {
                        cameron = activity;
                        sb.append('C');
                    } else if (jamie == null || jamie.end <= activity.start) {
                        jamie = activity;
                        sb.append('J');
                    } else {
                        sb = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
                System.out.println("Case #" + i + ": " + sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Activity implements Comparable<Activity> {
        private int start;
        private int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity o) {
            return Integer.compare(start, o.start);
        }
    }
}
