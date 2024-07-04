import java.io.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Solution {
    public static int stringToInt(String s) {
        return Integer.parseInt(s);
    }

    public static class Activity implements Comparable<Activity> {
        int start;
        int end;
        int index;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Activity other) {
            if (this.start == other.start) {
                return this.end - other.end;
            }
            return this.start - other.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
        StringTokenizer tokenizer;

        int testCases = stringToInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            result.append("Case #").append(t).append(": ");

            int activityCount = stringToInt(reader.readLine());
            PriorityQueue<Activity> activities = new PriorityQueue<>();

            for (int j = 1; j <= activityCount; j++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int start = stringToInt(tokenizer.nextToken());
                int end = stringToInt(tokenizer.nextToken());
                activities.add(new Activity(start, end, j));
            }

            String[] schedule = new String[activityCount + 1];
            int cAvailable = 0;
            int jAvailable = 0;
            boolean possible = true;

            while (!activities.isEmpty()) {
                Activity current = activities.poll();

                if (current.start >= cAvailable) {
                    cAvailable = current.end;
                    schedule[current.index] = "C";
                } else if (current.start >= jAvailable) {
                    jAvailable = current.end;
                    schedule[current.index] = "J";
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                for (int j = 1; j <= activityCount; j++) {
                    result.append(schedule[j]);
                }
                result.append("\n");
            } else {
                result.append("IMPOSSIBLE\n");
            }
        }

        writer.write(result.toString());
        writer.flush();
        writer.close();
    }
}