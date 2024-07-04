import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int t = 0; t < testCases; t++) {
                int activityCount = scanner.nextInt();
                List<Activity> activities = new ArrayList<>();
                for (int a = 0; a < activityCount; a++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    activities.add(new Activity(a, start, end));
                }
                activities.sort(Comparator.comparingInt(Activity::getStart));
                int cameronEnd = -1;
                int jamieEnd = -1;
                boolean isImpossible = false;
                for (int time = 0, idx = 0; time <= 24 * 60; time++) {
                    if (idx >= activities.size()) break;
                    Activity currentActivity = activities.get(idx);
                    if (currentActivity.getStart() > time) continue;
                    if (time >= cameronEnd) cameronEnd = -1;
                    if (time >= jamieEnd) jamieEnd = -1;
                    if (cameronEnd == -1) {
                        cameronEnd = currentActivity.getEnd();
                        currentActivity.setOwner("C");
                        idx++;
                        time--;
                    } else if (jamieEnd == -1) {
                        jamieEnd = currentActivity.getEnd();
                        currentActivity.setOwner("J");
                        idx++;
                        time--;
                    } else {
                        isImpossible = true;
                        break;
                    }
                }
                System.out.println(String.format("Case #%d: %s", t + 1, isImpossible ? "IMPOSSIBLE" : getOwners(activities)));
            }
        }
    }

    private static String getOwners(List<Activity> activities) {
        return activities.stream()
                .sorted(Comparator.comparingInt(Activity::getIndex))
                .map(Activity::getOwner)
                .collect(Collectors.joining());
    }

    private static class Activity {
        private final int index;
        private final int start;
        private final int end;
        private String owner;

        public Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        public int getIndex() {
            return index;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}