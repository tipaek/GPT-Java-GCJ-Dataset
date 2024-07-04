import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++) {
            solution.processCase(i + 1, in);
        }
    }

    private void processCase(int t, Scanner in) {
        int n = in.nextInt();
        List<Activity> activities = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            activities.add(new Activity(in.nextInt(), in.nextInt(), i));
        }

        System.out.println("Case #" + t + ": " + calculateResult(activities, n));
    }

    private String calculateResult(List<Activity> activities, int n) {
        char[] arr = new char[n];
        activities.sort(Comparator.comparingInt((Activity activity) -> activity.start));
        int cEnd = 0, jEnd = 0;
        for (Activity activity : activities) {
            if(activity.start < cEnd && activity.start < jEnd) {
                return "IMPOSSIBLE";
            }
            if(activity.start >= cEnd) {
                activity.setAssignee('C');
                cEnd = activity.end;
            } else {
                activity.setAssignee('J');
                jEnd = activity.end;
            }

            arr[activity.originalIndex] = activity.assignee;
        }
        return new String(arr);
    }

    private static class Activity {
        final int start;
        final int end;
        final int originalIndex;
        char assignee;

        public Activity(int start, int end, int originalIndex) {
            this.start = start;
            this.end = end;
            this.originalIndex = originalIndex;
        }

        public void setAssignee(char assignee) {
            this.assignee = assignee;
        }
    }
}