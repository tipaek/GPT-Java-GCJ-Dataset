import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            
            for (int i = 1; i <= testCases; i++) {
                int activitiesCount = scanner.nextInt();
                StringBuilder schedule = new StringBuilder();
                
                Set<Activity> cameronActivities = new TreeSet<>();
                Set<Activity> jamieActivities = new TreeSet<>();
                
                for (int j = 0; j < activitiesCount; j++) {
                    Activity activity = new Activity(scanner.nextInt(), scanner.nextInt());
                    
                    if (cameronActivities.add(activity)) {
                        schedule.append('C');
                    } else if (jamieActivities.add(activity)) {
                        schedule.append('J');
                    }
                }
                
                if (schedule.length() != activitiesCount) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + i + ": " + schedule.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Activity implements Comparable<Activity> {
        private final int start;
        private final int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public int compareTo(Activity other) {
            if ((start >= other.getStart() && start < other.getEnd()) ||
                (end > other.getStart() && end <= other.getEnd()) ||
                (start >= other.getStart() && end <= other.getEnd()) ||
                (start <= other.getStart() && end >= other.getEnd())) {
                return 0;
            }
            return Integer.compare(start, other.start);
        }
    }
}