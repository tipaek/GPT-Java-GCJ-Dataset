import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numberInstances = Integer.parseInt(br.readLine());
            
            for (int i = 1; i <= numberInstances; ++i) {
                boolean failed = false;
                String[] arguments = br.readLine().split(" ");
                int numberActivities = Integer.parseInt(arguments[0]);
                Activity[] activities = new Activity[numberActivities];
                char[] responsibility = new char[numberActivities];
                
                for (int j = 0; j < numberActivities; j++) {
                    String[] activityDetails = br.readLine().split(" ");
                    int start = Integer.parseInt(activityDetails[0]);
                    int end = Integer.parseInt(activityDetails[1]);
                    activities[j] = new Activity(start, end, j);
                }
                
                Arrays.sort(activities);
                int jamieBusyUntil = 0;
                int cameronBusyUntil = 0;
                
                for (Activity activity : activities) {
                    if (activity.start >= jamieBusyUntil) {
                        jamieBusyUntil = activity.end;
                        responsibility[activity.index] = 'J';
                    } else if (activity.start >= cameronBusyUntil) {
                        cameronBusyUntil = activity.end;
                        responsibility[activity.index] = 'C';
                    } else {
                        failed = true;
                        break;
                    }
                }
                
                if (failed) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + i + ": " + new String(responsibility));
                }
            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    static class Activity implements Comparable<Activity> {
        int start;
        int end;
        int index;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Activity other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }

        @Override
        public String toString() {
            return "(" + index + ", " + start + ", " + end + ")";
        }
    }
}