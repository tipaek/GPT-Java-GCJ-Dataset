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
            for (int x = 0; x < n; x++) {
                String[] line = reader.readLine().split(" ");
                activities.add(new Activity(Integer.parseInt(line[0]), Integer.parseInt(line[1]), x));
            }
            boolean impossible = false;
            int jEnd = 0;
            int cEnd = 0;
            StringBuilder result = new StringBuilder();
            result.setLength(activities.size());
            for (Activity activity : activities) {
                if (activity.start >= cEnd) {
                    cEnd = activity.finish;
                    result.setCharAt(activity.index, 'C');
                } else if (activity.start >= jEnd) {
                    jEnd = activity.finish;
                    result.setCharAt(activity.index, 'J');
                }  else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println(String.format("Case #%d: %s", (i + 1), "IMPOSSIBLE"));
            } else {
                System.out.println(String.format("Case #%d: %s", (i + 1), result.toString()));
            }


        }
    }

    public static class Activity implements Comparable<Activity> {

        private final int start;
        private final int finish;
        private final int index;

        Activity(int start, int finish, int index) {
            this.start = start;
            this.finish = finish;
            this.index = index;
        }

        @Override
        public int compareTo(Activity activity) {
            return start - activity.start;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "start=" + start +
                    ", finish=" + finish +
                    '}';
        }
    }

}