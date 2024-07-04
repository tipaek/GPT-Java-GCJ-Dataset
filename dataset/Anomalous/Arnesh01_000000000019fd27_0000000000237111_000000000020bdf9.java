import java.io.*;
import java.util.*;

public class Solution {
    
    public static class Activity implements Comparable<Activity> {
        int start;
        int end;
        int pos;
        char assignedTo;

        public Activity(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
            this.assignedTo = 'A';
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            Activity[] activities = new Activity[N];

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                activities[i] = new Activity(start, end, i);
            }

            Arrays.sort(activities);
            boolean isPossible = true;

            for (int i = 0; i < N; i++) {
                int cCount = 0;
                int jCount = 0;
                for (int j = 0; j < i; j++) {
                    if (activities[j].end > activities[i].start) {
                        if (activities[j].assignedTo == 'C') {
                            cCount++;
                        } else {
                            jCount++;
                        }
                    }
                }

                if (cCount > 0 && jCount > 0) {
                    isPossible = false;
                    break;
                } else {
                    activities[i].assignedTo = (cCount == 0) ? 'C' : 'J';
                }
            }

            StringBuilder schedule = new StringBuilder(N);
            if (!isPossible) {
                schedule.append("IMPOSSIBLE");
            } else {
                for (int i = 0; i < N; i++) {
                    schedule.append('A');
                }
                for (int i = 0; i < N; i++) {
                    schedule.setCharAt(activities[i].pos, activities[i].assignedTo);
                }
            }

            result.append("Case #").append(t).append(": ").append(schedule).append("\n");
        }

        System.out.print(result);
    }
}