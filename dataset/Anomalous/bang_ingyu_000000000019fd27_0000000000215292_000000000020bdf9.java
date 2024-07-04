import java.io.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Solution {

    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    private static class Activity implements Comparable<Activity> {
        int start;
        int end;
        int index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Activity other) {
            if (this.end == other.end) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringBuilder sb = new StringBuilder();
            int testCases = parseInt(br.readLine());

            for (int i = 1; i <= testCases; i++) {
                sb.append("Case #").append(i).append(": ");

                int numActivities = parseInt(br.readLine());
                PriorityQueue<Activity> activities = new PriorityQueue<>();

                for (int j = 1; j <= numActivities; j++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    int start = parseInt(st.nextToken());
                    int end = parseInt(st.nextToken());
                    activities.add(new Activity(start, end, j));
                }

                String[] schedule = new String[numActivities + 1];
                int cEndTime = 0;
                int jEndTime = 0;
                boolean possible = true;

                while (!activities.isEmpty()) {
                    Activity current = activities.poll();

                    if (current.start >= cEndTime) {
                        cEndTime = current.end;
                        schedule[current.index] = "C";
                    } else if (current.start >= jEndTime) {
                        jEndTime = current.end;
                        schedule[current.index] = "J";
                    } else {
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    for (int j = 1; j <= numActivities; j++) {
                        sb.append(schedule[j]);
                    }
                    sb.append("\n");
                } else {
                    sb.append("IMPOSSIBLE\n");
                }
            }

            bw.write(sb.toString());
        }
    }
}