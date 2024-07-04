import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int activities = scanner.nextInt();
            Activity[] activityList = new Activity[activities];

            for (int j = 0; j < activities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activityList[j] = new Activity(start, end, j);
            }

            Arrays.sort(activityList, Comparator.comparingInt(a -> a.start));

            String[] result = new String[activities];
            int cEnd = 0, jEnd = 0;
            boolean impossible = false;

            for (Activity activity : activityList) {
                if (activity.start >= cEnd) {
                    result[activity.index] = "C";
                    cEnd = activity.end;
                } else if (activity.start >= jEnd) {
                    result[activity.index] = "J";
                    jEnd = activity.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + (impossible ? "IMPOSSIBLE" : String.join("", result)));
        }

        scanner.close();
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