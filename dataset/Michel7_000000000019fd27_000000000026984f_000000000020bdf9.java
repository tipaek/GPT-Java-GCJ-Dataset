import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k = 1; k <= t; ++k) {
            int row = in.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities.add(new Activity(start, end));
            }

            List<Activity> sortedActivities = new ArrayList<>(activities);
            sortedActivities.sort(new ActivityComparator());

            Activity currentC = sortedActivities.get(0);
            currentC.setOwner("C");
            Activity currentJ = null;
            boolean isImpossible = false;
            for (int i = 1; i < row; i++) {
                Activity next = sortedActivities.get(i);
                if (currentC.end <= next.start) {
                    currentC = next;
                    currentC.setOwner("C");
                } else if (currentJ != null) {
                    if (currentJ.end <= next.start) {
                        currentJ = next;
                        currentJ.setOwner("J");
                    } else {
                        isImpossible = true;
                        break;
                    }
                } else {
                    currentJ = next;
                    currentJ.setOwner("J");
                }
            }

            String output = isImpossible ? "IMPOSSIBLE" : activities.stream()
                    .map(Activity::getOwner).reduce("", (a, b) -> a + b);
            System.out.println("Case #" + k + ": " + output);
        }
    }

    private static class Activity implements Comparable {
        private final int start;
        private final int end;
        private String owner;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Object o) {
            return Integer.compare(this.start, ((Activity) o).start);
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getOwner() {
            return owner;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    private static class ActivityComparator implements Comparator<Activity> {

        @Override
        public int compare(Activity o1, Activity o2) {
            return o1.compareTo(o2);
        }
    }
} 