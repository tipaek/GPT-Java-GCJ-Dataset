import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][3];

            for (int i = 0; i < numActivities; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
            }

            insertionSort(activities);

            boolean[] isAssigned = new boolean[2];
            int[] endTimes = new int[2];
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;

            for (int i = 0; i < numActivities; i++) {
                if (activities[i][0] >= endTimes[0]) {
                    isAssigned[0] = false;
                }
                if (activities[i][0] >= endTimes[1]) {
                    isAssigned[1] = false;
                }

                if (!isAssigned[0]) {
                    endTimes[0] = activities[i][1];
                    schedule.append("C");
                    isAssigned[0] = true;
                } else if (!isAssigned[1]) {
                    endTimes[1] = activities[i][1];
                    schedule.append("J");
                    isAssigned[1] = true;
                } else {
                    if (endTimes[0] < activities[i][0]) {
                        endTimes[0] = activities[i][1];
                        schedule.append("C");
                    } else if (endTimes[1] < activities[i][0]) {
                        endTimes[1] = activities[i][1];
                        schedule.append("J");
                    } else {
                        System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    }
                }
            }

            if (!isImpossible) {
                System.out.print("Case #" + (t + 1) + ": ");
                char[] result = new char[numActivities];
                for (int i = 0; i < numActivities; i++) {
                    result[activities[i][2]] = schedule.charAt(i);
                }
                System.out.println(new String(result));
            }
        }
    }

    public static void insertionSort(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            int[] key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j][0] > key[0]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}