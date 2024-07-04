import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Activity {
    public int start, end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Activity [start=" + start + ", end=" + end + "]";
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            List<String> results = new ArrayList<>();
            int testCases = scanner.nextInt();
            
            if (testCases < 1 || testCases > 100) {
                return;
            }

            for (int t = 1; t <= testCases; t++) {
                int numActivities = scanner.nextInt();
                if (numActivities < 2 || numActivities > 10) {
                    results.add("Case #" + t + ": IMPOSSIBLE");
                    continue;
                }

                List<Activity> activities = new ArrayList<>();
                boolean isPossible = true;
                for (int i = 0; i < numActivities; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    if (start < 0 || start > 1440 || end < 0 || end > 1440) {
                        isPossible = false;
                        break;
                    }
                    activities.add(new Activity(start, end));
                }

                if (!isPossible) {
                    results.add("Case #" + t + ": IMPOSSIBLE");
                    continue;
                }

                StringBuilder schedule = new StringBuilder();
                int c_end = 0, j_end = 0;

                for (Activity activity : activities) {
                    if (activity.start >= c_end) {
                        c_end = activity.end;
                        schedule.append('C');
                    } else if (activity.start >= j_end) {
                        j_end = activity.end;
                        schedule.append('J');
                    } else {
                        schedule = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }

                results.add("Case #" + t + ": " + schedule.toString());
            }

            for (String result : results) {
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}