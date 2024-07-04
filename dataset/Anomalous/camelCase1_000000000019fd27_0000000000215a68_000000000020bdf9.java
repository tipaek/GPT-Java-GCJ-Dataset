import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int numActivities = nextInt();
            Activity[] activities = new Activity[numActivities];

            for (int i = 0; i < numActivities; i++) {
                activities[i] = new Activity(nextInt(), nextInt(), i);
            }

            Arrays.sort(activities);

            Activity cameron = null;
            Activity jamie = null;
            boolean[] assignment = new boolean[numActivities];

            for (Activity activity : activities) {
                if (cameron == null || cameron.end <= activity.start) {
                    cameron = activity;
                } else if (jamie == null || jamie.end <= activity.start) {
                    jamie = activity;
                    assignment[activity.index] = true;
                } else {
                    System.out.println("Case #" + caseNumber++ + ": IMPOSSIBLE");
                    continue;
                }
            }

            StringBuilder result = new StringBuilder();
            for (boolean assignedToJamie : assignment) {
                result.append(assignedToJamie ? 'J' : 'C');
            }

            System.out.println("Case #" + caseNumber++ + ": " + result);
        }
    }

    private static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) throw new IOException();
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static class Activity implements Comparable<Activity> {
        int start, end, index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Activity other) {
            if (this.start != other.start) {
                return this.start - other.start;
            }
            return this.end - other.end;
        }
    }
}