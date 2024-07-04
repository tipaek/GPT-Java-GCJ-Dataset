package Codejam2020_AA;

import java.util.Scanner;

public class CodeJam2020_ParentingPartneringReturns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int activities = sc.nextInt();
            Activity[] activityArray = new Activity[activities];

            for (int j = 0; j < activities; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                activityArray[j] = new Activity(start, end, j);
            }

            Arrays.sort(activityArray, (a, b) -> a.start - b.start);

            int cEnd = 0, jEnd = 0;
            char[] result = new char[activities];
            boolean possible = true;

            for (Activity activity : activityArray) {
                if (activity.start >= cEnd) {
                    result[activity.index] = 'C';
                    cEnd = activity.end;
                } else if (activity.start >= jEnd) {
                    result[activity.index] = 'J';
                    jEnd = activity.end;
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + i + ": " + new String(result));
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }

    static class Activity {
        int start, end, index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}