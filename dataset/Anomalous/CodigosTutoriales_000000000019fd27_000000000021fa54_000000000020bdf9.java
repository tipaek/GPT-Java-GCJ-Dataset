import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int numberOfActivities = scanner.nextInt();
            Activity[] activities = new Activity[numberOfActivities];
            char[] assignment = new char[numberOfActivities];
            boolean possible = true;

            for (int i = 0; i < numberOfActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end, i);
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.startMinute));

            int endC = 0, endJ = 0;
            for (Activity activity : activities) {
                if (activity.startMinute >= endC) {
                    assignment[activity.index] = 'C';
                    endC = activity.endMinute;
                } else if (activity.startMinute >= endJ) {
                    assignment[activity.index] = 'J';
                    endJ = activity.endMinute;
                } else {
                    possible = false;
                    break;
                }
            }

            System.out.print("Case #" + t + ": ");
            if (possible) {
                System.out.println(new String(assignment));
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    static class Activity {
        int startMinute;
        int endMinute;
        int index;

        Activity(int start, int end, int index) {
            this.startMinute = start;
            this.endMinute = end;
            this.index = index;
        }
    }
}