import java.io.*;
import java.util.*;

public class Solution {

    static class Activity implements Comparable<Activity> {
        int start;
        int end;
        String assignTo;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
            this.assignTo = "";
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (other == null || getClass() != other.getClass()) return false;
            Activity activity = (Activity) other;
            return start == activity.start && end == activity.end;
        }

        @Override
        public int compareTo(Activity other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = getScanner();
        int T = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(scanner.nextLine());
            Activity[] activities = new Activity[N];
            Activity[] output = new Activity[N];

            for (int j = 0; j < N; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[j] = new Activity(start, end);
                output[j] = activities[j];
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }

            Arrays.sort(activities);
            Activity C = null;
            Activity J = null;
            boolean possible = true;

            for (Activity activity : activities) {
                if (!overlap(C, activity)) {
                    activity.assignTo = "C";
                    C = activity;
                } else if (!overlap(J, activity)) {
                    activity.assignTo = "J";
                    J = activity;
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (i + 1) + ": ");
                for (Activity activity : output) {
                    System.out.print(activity.assignTo);
                }
                System.out.println();
            }
        }
    }

    static boolean overlap(Activity a, Activity b) {
        if (a == null || b == null) return false;
        return a.end > b.start && b.end > a.start;
    }

    static Scanner getScanner() throws Exception {
        return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // return new Scanner(new File("input.txt"));
    }
}