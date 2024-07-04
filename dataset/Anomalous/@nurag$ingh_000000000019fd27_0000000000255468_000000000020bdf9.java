import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            int[] assignedStartTimes = new int[n];
            int[] assignedEndTimes = new int[n];
            int[] assignments = new int[n];
            assignedStartTimes[0] = startTimes[0];
            assignedEndTimes[0] = endTimes[0];
            assignments[0] = 10;

            int k = 1;
            boolean isImpossible = false;

            for (int i = 1; i < n; i++) {
                Set<Integer> availableAssignments = new HashSet<>(Arrays.asList(10, 11));

                for (int j = 0; j < k; j++) {
                    if ((startTimes[i] < assignedEndTimes[j] && startTimes[i] > assignedStartTimes[j]) ||
                        (endTimes[i] < assignedEndTimes[j] && endTimes[i] > assignedStartTimes[j]) ||
                        (startTimes[i] > assignedStartTimes[j] && endTimes[i] < assignedEndTimes[j]) ||
                        (startTimes[i] < assignedStartTimes[j] && endTimes[i] > assignedEndTimes[j])) {

                        availableAssignments.remove(assignments[j]);
                    }
                }

                if (availableAssignments.isEmpty()) {
                    isImpossible = true;
                    break;
                }

                assignedStartTimes[k] = startTimes[i];
                assignedEndTimes[k] = endTimes[i];
                assignments[k] = availableAssignments.iterator().next();
                k++;
            }

            if (isImpossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (t + 1) + ": ");
                for (int i = 0; i < k; i++) {
                    System.out.print(assignments[i] == 10 ? "C" : "J");
                }
                System.out.println();
            }
        }
    }
}