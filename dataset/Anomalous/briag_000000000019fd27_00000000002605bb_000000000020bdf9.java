import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, j));
            }

            activities.sort(Comparator.comparingInt(Activity::getStart));

            boolean isPossible = true;
            StringBuilder result = new StringBuilder();

            int cEnd = 0, jEnd = 0;

            for (Activity activity : activities) {
                int startTime = activity.getStart();
                int endTime = activity.getEnd();

                if (cEnd <= startTime) {
                    cEnd = endTime;
                    activity.setAssignment("C");
                } else if (jEnd <= startTime) {
                    jEnd = endTime;
                    activity.setAssignment("J");
                } else {
                    result.append("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                activities.sort(Comparator.comparingInt(Activity::getIndex));
                for (Activity activity : activities) {
                    result.append(activity.getAssignment());
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }

    static class Activity {
        private final int start;
        private final int end;
        private final int index;
        private String assignment;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getIndex() {
            return index;
        }

        public void setAssignment(String assignment) {
            this.assignment = assignment;
        }

        public String getAssignment() {
            return assignment;
        }
    }
}