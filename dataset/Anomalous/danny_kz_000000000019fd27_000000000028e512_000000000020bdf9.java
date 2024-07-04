import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numActivities = scanner.nextInt();
            Activity[] activities = new Activity[numActivities];
            for (int i = 0; i < numActivities; i++) {
                activities[i] = new Activity(scanner.nextInt(), scanner.nextInt());
            }
            
            String result = assignParents(activities);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static String assignParents(Activity[] activities) {
        StringBuilder result = new StringBuilder();
        boolean conflict = false;

        for (int i = 0; i < activities.length; i++) {
            if (i == 0) {
                result.append(nextParent("", true));
            } else {
                Activity previousActivity = activities[i - 1];
                if (!conflict) {
                    if (activities[i].start >= previousActivity.end) {
                        result.append(nextParent(result.toString(), true));
                    } else {
                        result.append(nextParent(result.toString(), false));
                        conflict = true;
                    }
                } else {
                    if (activities[i].start >= previousActivity.end) {
                        result.append(nextParent(result.toString(), true));
                        conflict = false;
                    } else if (i > 1 && activities[i].start >= activities[i - 2].end) {
                        result.append(nextParent(result.toString(), false));
                        conflict = true;
                    } else {
                        return "IMPOSSIBLE";
                    }
                }
            }
        }
        
        return result.toString();
    }

    private static String nextParent(String result, boolean same) {
        if (result.isEmpty()) {
            return "C";
        }
        char lastParent = result.charAt(result.length() - 1);
        return same ? String.valueOf(lastParent) : (lastParent == 'J' ? "C" : "J");
    }

    private static class Activity {
        int start;
        int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}