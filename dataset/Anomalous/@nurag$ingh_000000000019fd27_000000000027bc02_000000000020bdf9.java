import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int rr = 0; rr < t; rr++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            int[] sortedStartTimes = new int[n];
            int[] sortedEndTimes = new int[n];
            int[] assignments = new int[n];

            // Bubble sort to sort based on start times
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1 - i; j++) {
                    if (startTimes[j] > startTimes[j + 1]) {
                        int temp = startTimes[j + 1];
                        startTimes[j + 1] = startTimes[j];
                        startTimes[j] = temp;

                        temp = endTimes[j + 1];
                        endTimes[j + 1] = endTimes[j];
                        endTimes[j] = temp;
                    }
                }
            }

            sortedStartTimes[0] = startTimes[0];
            sortedEndTimes[0] = endTimes[0];
            assignments[0] = 10; // Assign 'C'
            int k = 1;
            boolean isImpossible = false;

            for (int i = 1; i < n; i++) {
                ArrayList<Integer> availableAssignments = new ArrayList<>(Arrays.asList(10, 11)); // 10 -> 'C', 11 -> 'J'
                for (int j = 0; j < k; j++) {
                    if ((startTimes[i] < sortedEndTimes[j] && startTimes[i] >= sortedStartTimes[j]) ||
                        (endTimes[i] <= sortedEndTimes[j] && endTimes[i] > sortedStartTimes[j]) ||
                        (startTimes[i] >= sortedStartTimes[j] && endTimes[i] <= sortedEndTimes[j]) ||
                        (startTimes[i] <= sortedStartTimes[j] && endTimes[i] >= sortedEndTimes[j])) {

                        int currentAssignment = assignments[j];
                        if (!availableAssignments.contains(currentAssignment)) {
                            isImpossible = true;
                            break;
                        } else {
                            availableAssignments.remove((Integer) currentAssignment);
                        }
                    }
                }
                if (isImpossible || availableAssignments.isEmpty()) {
                    isImpossible = true;
                    break;
                }
                sortedStartTimes[k] = startTimes[i];
                sortedEndTimes[k] = endTimes[i];
                assignments[k] = availableAssignments.get(0);
                k++;
            }

            if (isImpossible) {
                System.out.println("Case #" + (rr + 1) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (rr + 1) + ": ");
                for (int i = 0; i < k; i++) {
                    if (assignments[i] == 10) {
                        System.out.print("C");
                    } else {
                        System.out.print("J");
                    }
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}