import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseAmount = scanner.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        scanner.nextLine();
        a: for (int caseNumber = 1; caseNumber <= caseAmount; caseNumber++) {
            int activityCount = scanner.nextInt();
            List<Activity> activityList = new ArrayList<>();
            for (int i = 0; i < activityCount; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                Activity activity = new Activity(i, startTime, endTime);
                activityList.add(activity);
            }
            Collections.sort(activityList);
            int endTimeC = -1;
            int endTimeJ = -1;
            String out = "";
            for (Activity activity : activityList) {
                if (endTimeC <= activity.getStartTime()) {
                    endTimeC = activity.getEndTime();
                    activity.setDoneBy("C");
                } else if (endTimeJ <= activity.getStartTime()) {
                    endTimeJ = activity.getEndTime();
                    activity.setDoneBy("J");
                } else {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                    continue a;
                }
            }
            Collections.sort(activityList, new IDComparator());
            for (Activity activity : activityList) {
                out += activity.getDoneBy();
            }
            System.out.println("Case #" + caseNumber + ": " + out);
        }

    }

    private static class Activity implements Comparable<Activity> {
        private int id;
        private int startTime;
        private int endTime;
        private String doneBy;

        public Activity(int id, int startTime, int endTime) {
            this.id = id;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getId() {
            return id;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public String getDoneBy() {
            return doneBy;
        }

        public void setDoneBy(String doneBy) {
            this.doneBy = doneBy;
        }

        @Override
        public int compareTo(Activity o) {
            return this.getStartTime() - o.getStartTime();
        }
    }

    private static class IDComparator implements Comparator<Activity> {
        @Override
        public int compare(Activity o1, Activity o2) {
            return o1.getId() - o2.getId();
        }
    }
}
