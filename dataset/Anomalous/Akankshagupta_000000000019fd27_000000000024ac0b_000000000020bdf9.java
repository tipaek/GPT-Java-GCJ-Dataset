import java.util.Scanner;
import java.lang.StringBuilder;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());

        if (cases <= 0) {
            return;
        }

        for (int caseNumber = 0; caseNumber < cases; caseNumber++) {
            int noOfActivities = Integer.parseInt(scanner.nextLine());
            if (noOfActivities <= 0) {
                continue;
            }

            int[] startTimes = new int[noOfActivities];
            int[] endTimes = new int[noOfActivities];
            int[] indices = new int[noOfActivities];

            for (int activity = 0; activity < noOfActivities; activity++) {
                String[] startAndEndTime = scanner.nextLine().split(" ");
                startTimes[activity] = Integer.parseInt(startAndEndTime[0]);
                endTimes[activity] = Integer.parseInt(startAndEndTime[1]);
                indices[activity] = activity;
            }

            sortActivitiesByEndTime(endTimes, startTimes, indices);

            int cameronEndTime = -1, jamieEndTime = -1;
            char[] assignment = new char[noOfActivities];
            boolean possible = true;

            for (int i = 0; i < noOfActivities; i++) {
                if (cameronEndTime == -1 || startTimes[i] >= endTimes[cameronEndTime]) {
                    assignment[indices[i]] = 'C';
                    cameronEndTime = i;
                } else if (jamieEndTime == -1 || startTimes[i] >= endTimes[jamieEndTime]) {
                    assignment[indices[i]] = 'J';
                    jamieEndTime = i;
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + (caseNumber + 1) + ": " + new String(assignment));
            } else {
                System.out.println("Case #" + (caseNumber + 1) + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }

    private static void sortActivitiesByEndTime(int[] endTimes, int[] startTimes, int[] indices) {
        int n = endTimes.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (endTimes[j] > endTimes[j + 1]) {
                    swap(endTimes, j, j + 1);
                    swap(startTimes, j, j + 1);
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