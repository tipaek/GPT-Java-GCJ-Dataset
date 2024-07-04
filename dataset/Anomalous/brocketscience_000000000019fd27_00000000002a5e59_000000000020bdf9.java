import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        new Solution().solve(scanner, writer);
        writer.flush();
        writer.close();
    }
}

class Solution {
    public void solve(Scanner scanner, PrintWriter writer) {
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numActivities = scanner.nextInt();
            int lastC = 0, lastJ = 0;
            StringBuilder result = new StringBuilder();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < numActivities; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                activities.add(new Activity(startTime, endTime));
            }

            activities.sort(Comparator.comparingInt(a -> a.startTime));

            boolean impossible = false;
            for (Activity activity : activities) {
                if (activity.startTime >= lastC && (lastC <= lastJ || lastJ > activity.startTime)) {
                    lastC = activity.endTime;
                    result.append("C");
                } else if (activity.startTime >= lastJ) {
                    lastJ = activity.endTime;
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            writer.println(String.format("Case #%d: %s", testCase, result.toString()));
        }
    }

    static class Activity {
        int startTime;
        int endTime;

        Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}