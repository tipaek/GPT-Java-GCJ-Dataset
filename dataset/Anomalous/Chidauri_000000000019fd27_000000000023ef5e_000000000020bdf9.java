import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int q = 0; q < t; q++) {
            int n = in.nextInt();
            Activity[] activities = new Activity[n];

            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities[i] = new Activity(start, end, i);
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

            boolean isPossible = true;
            int cameronEnd = 0;
            int jamieEnd = 0;
            char[] result = new char[n];

            for (Activity activity : activities) {
                if (activity.start >= cameronEnd) {
                    cameronEnd = activity.end;
                    result[activity.index] = 'C';
                } else if (activity.start >= jamieEnd) {
                    jamieEnd = activity.end;
                    result[activity.index] = 'J';
                } else {
                    isPossible = false;
                    break;
                }
            }

            System.out.print("Case #" + (q + 1) + ": ");
            if (isPossible) {
                for (char c : result) {
                    System.out.print(c);
                }
            } else {
                System.out.print("IMPOSSIBLE");
            }
            System.out.println();
        }
    }

    static class Activity {
        int start;
        int end;
        int index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}