import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCase = scanner.nextInt();
        int n;
        int start, end;
        Activity[] activities;
        int cEndTime, jEndTime;
        StringBuilder assignment;

        for (int caseNum = 1; caseNum <= numCase; caseNum++) {
            n = scanner.nextInt();
            activities = new Activity[n];

            // input activity dets.
            for (int i = 0; i < n; i++) {
                start = scanner.nextInt();
                end = scanner.nextInt();
                activities[i] = new Activity(start, end);
            }

            // init state
            Arrays.sort(activities);
            cEndTime = 0;
            jEndTime = 0;
            assignment = new StringBuilder();

            for (Activity activity : activities) {
                if (activity.start >= cEndTime) {
                    cEndTime = activity.end;
                    assignment.append("C");
                } else if (activity.start >= jEndTime) {
                    jEndTime = activity.end;
                    assignment.append("J");
                } else {
                    assignment.setLength(0);
                    assignment.append("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNum + ": " + assignment.toString());
        }
    }
}

class Activity implements Comparable<Activity>{
    public final int start;
    public final int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Activity other) {
        return this.start - other.start;
    }
}