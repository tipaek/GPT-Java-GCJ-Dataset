import java.util.*;
import java.io.*;

public class Solution {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = nextInt();
            Activity[] activities = new Activity[n];

            for (int i = 0; i < n; i++) {
                activities[i] = new Activity(nextInt(), nextInt(), i);
            }

            Arrays.sort(activities);

            Activity cameron = null;
            Activity jamie = null;
            boolean[] assignedToJamie = new boolean[n];

            if (assignActivities(activities, assignedToJamie, cameron, jamie)) {
                printResult(caseNumber++, assignedToJamie);
            } else {
                System.out.println("Case #" + caseNumber++ + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean assignActivities(Activity[] activities, boolean[] assignedToJamie, Activity cameron, Activity jamie) {
        for (Activity activity : activities) {
            if (cameron == null || cameron.endTime <= activity.startTime) {
                cameron = activity;
            } else if (jamie == null || jamie.endTime <= activity.startTime) {
                jamie = activity;
                assignedToJamie[jamie.id] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    private static void printResult(int caseNumber, boolean[] assignedToJamie) {
        StringBuilder result = new StringBuilder();
        for (boolean isJamie : assignedToJamie) {
            result.append(isJamie ? 'J' : 'C');
        }
        System.out.println("Case #" + caseNumber + ": " + result);
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

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}

class Activity implements Comparable<Activity> {
    int startTime, endTime, id;

    public Activity(int startTime, int endTime, int id) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.id = id;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.endTime, other.endTime);
    }
}