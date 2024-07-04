import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner scanner = new Scanner(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCases = Integer.parseInt(scanner.next());
        for (int i = 1; i <= testCases; i++) {
            solver.solve(i, scanner, writer);
        }
        writer.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, Scanner scanner, PrintWriter writer) {
            int numActivities = scanner.nextInt();
            Activity[] activities = new Activity[numActivities];
            for (int i = 0; i < numActivities; i++) {
                activities[i] = new Activity(scanner.nextInt(), scanner.nextInt());
            }
            Arrays.sort(activities);
            char[] participants = {'C', 'J'};
            int[] lastEndTime = new int[2];
            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (Activity activity : activities) {
                boolean assigned = false;
                for (int j = 0; j < 2; j++) {
                    if (lastEndTime[j] <= activity.start) {
                        lastEndTime[j] = activity.end;
                        result.append(participants[j]);
                        assigned = true;
                        break;
                    }
                }
                if (!assigned) {
                    result = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            writer.println("Case #" + testNumber + ": " + result);
        }

        class Activity implements Comparable<Activity> {
            int start;
            int end;

            public Activity(int start, int end) {
                this.start = start;
                this.end = end;
            }

            @Override
            public int compareTo(Activity other) {
                return Integer.compare(this.start, other.start);
            }
        }
    }
}