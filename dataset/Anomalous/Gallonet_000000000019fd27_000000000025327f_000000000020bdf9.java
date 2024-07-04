import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int activityCount = sc.nextInt();
            ArrayList<Activity> activities = new ArrayList<>();

            for (int i = 0; i < activityCount; i++) {
                activities.add(new Activity(sc.nextInt(), sc.nextInt(), i));
            }

            Collections.sort(activities);

            char[] assignments = new char[activityCount];
            int endCameron = 0, endJamie = 0;
            boolean possible = true;

            for (Activity activity : activities) {
                if (activity.start >= endCameron) {
                    assignments[activity.index] = 'C';
                    endCameron = activity.end;
                } else if (activity.start >= endJamie) {
                    assignments[activity.index] = 'J';
                    endJamie = activity.end;
                } else {
                    possible = false;
                    break;
                }
            }

            System.out.printf("Case #%d: ", t + 1);
            if (possible) {
                System.out.println(new String(assignments));
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }

        sc.close();
    }

    static class Activity implements Comparable<Activity> {
        int start, end, index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }

        @Override
        public String toString() {
            return "[" + start + " " + end + "]";
        }
    }
}