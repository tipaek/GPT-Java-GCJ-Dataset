import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] b = new int[n];
            int[][] activities = new int[n][2];

            for (int j = 0; j < n; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
                b[j] = j + 1;
            }

            // Sort activities by start time
            sortActivitiesByStartTime(activities, b);

            char[] result = assignActivities(activities);

            if (result == null) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                // Restore original order
                restoreOriginalOrder(result, b);
                System.out.println("Case #" + (i + 1) + ": " + new String(result));
            }
        }
    }

    private static void sortActivitiesByStartTime(int[][] activities, int[] b) {
        for (int j = 0; j < activities.length - 1; j++) {
            for (int k = j + 1; k < activities.length; k++) {
                if (activities[j][0] > activities[k][0]) {
                    swap(activities, j, k);
                    swap(b, j, k);
                }
            }
        }
    }

    private static void swap(int[][] array, int i, int j) {
        int[] temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static char[] assignActivities(int[][] activities) {
        char[] assigned = new char[activities.length];
        int C_end = -1, J_end = -1;

        for (int k = 0; k < activities.length; k++) {
            if (activities[k][0] >= C_end) {
                assigned[k] = 'C';
                C_end = activities[k][1];
            } else if (activities[k][0] >= J_end) {
                assigned[k] = 'J';
                J_end = activities[k][1];
            } else {
                return null;
            }
        }

        return assigned;
    }

    private static void restoreOriginalOrder(char[] result, int[] b) {
        for (int j = 0; j < b.length - 1; j++) {
            for (int k = j + 1; k < b.length; k++) {
                if (b[j] > b[k]) {
                    swap(b, j, k);
                    swap(result, j, k);
                }
            }
        }
    }

    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}