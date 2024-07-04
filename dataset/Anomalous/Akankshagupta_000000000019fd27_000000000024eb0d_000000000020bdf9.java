import java.util.Scanner;
import java.lang.StringBuilder;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());

        if (cases <= 0) return;

        for (int caseNum = 0; caseNum < cases; caseNum++) {
            int numActivities = Integer.parseInt(scanner.nextLine());
            if (numActivities <= 0) continue;

            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];
            int[] indices = new int[numActivities];

            for (int activity = 0; activity < numActivities; activity++) {
                String[] times = scanner.nextLine().split(" ");
                startTimes[activity] = Integer.parseInt(times[0]);
                endTimes[activity] = Integer.parseInt(times[1]);
                indices[activity] = activity;
            }

            sortActivities(startTimes, endTimes, indices);

            int cameronEnd = -1, jamieEnd = -1;
            char[] schedule = new char[numActivities];
            boolean isPossible = true;

            for (int i = 0; i < numActivities; i++) {
                if (cameronEnd == -1 || startTimes[i] >= endTimes[cameronEnd]) {
                    schedule[indices[i]] = 'C';
                    cameronEnd = i;
                } else if (jamieEnd == -1 || startTimes[i] >= endTimes[jamieEnd]) {
                    schedule[indices[i]] = 'J';
                    jamieEnd = i;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + (caseNum + 1) + ": " + new String(schedule));
            } else {
                System.out.println("Case #" + (caseNum + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static void sortActivities(int[] startTimes, int[] endTimes, int[] indices) {
        int n = startTimes.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (startTimes[j] > startTimes[j + 1]) {
                    swap(startTimes, j, j + 1);
                    swap(endTimes, j, j + 1);
                    swap(indices, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}