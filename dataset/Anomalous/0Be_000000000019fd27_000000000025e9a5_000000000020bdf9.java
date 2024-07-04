import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            result.append("Case #").append(t).append(": ");

            int activityCount = Integer.parseInt(reader.readLine());
            PriorityQueue<Activity> activitiesQueue = new PriorityQueue<>();

            for (int i = 0; i < activityCount; i++) {
                String[] input = reader.readLine().split("\\s+");
                activitiesQueue.add(new Activity(Integer.parseInt(input[0]), Integer.parseInt(input[1]), i));
            }

            boolean isPossible = true;
            Activity cameron = new Activity(-1, -1, 0);
            Activity jamie = new Activity(-1, -1, 0);
            char[] assignments = new char[activityCount];

            while (!activitiesQueue.isEmpty()) {
                Activity currentActivity = activitiesQueue.poll();
                if (currentActivity.start >= cameron.end) {
                    assignments[currentActivity.index] = 'C';
                    cameron = currentActivity;
                } else if (currentActivity.start >= jamie.end) {
                    assignments[currentActivity.index] = 'J';
                    jamie = currentActivity;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                for (char assignment : assignments) {
                    result.append(assignment);
                }
            } else {
                result.append("IMPOSSIBLE");
            }

            result.append('\n');
        }

        writer.print(result.toString());
        reader.close();
        writer.close();
    }
}

class Activity implements Comparable<Activity> {
    int start, end, index;

    Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    @Override
    public int compareTo(Activity other) {
        if (this.start != other.start) {
            return Integer.compare(this.start, other.start);
        }
        return Integer.compare(this.end, other.end);
    }
}