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
            assignments[0] = 10; // 'C' is represented by 10
            int k = 1;
            boolean possible = true;

            for (int i = 1; i < n; i++) {
                List<Integer> available = new ArrayList<>(Arrays.asList(10, 11));
                boolean conflict = false;

                for (int j = 0; j < k; j++) {
                    boolean overlaps = (startTimes[i] < assignedEndTimes[j] && startTimes[i] >= assignedStartTimes[j]) ||
                                       (endTimes[i] <= assignedEndTimes[j] && endTimes[i] > assignedStartTimes[j]) ||
                                       (startTimes[i] >= assignedStartTimes[j] && endTimes[i] <= assignedEndTimes[j]) ||
                                       (startTimes[i] <= assignedStartTimes[j] && endTimes[i] >= assignedEndTimes[j]);

                    if (overlaps) {
                        int assignedPerson = assignments[j];
                        if (!available.contains(assignedPerson)) {
                            conflict = true;
                            break;
                        } else {
                            available.remove((Integer) assignedPerson);
                        }
                    }
                }

                if (conflict || available.isEmpty()) {
                    possible = false;
                    break;
                }

                assignedStartTimes[k] = startTimes[i];
                assignedEndTimes[k] = endTimes[i];
                assignments[k] = available.get(0);
                k++;
            }

            System.out.print("Case #" + (t + 1) + ": ");
            if (!possible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int i = 0; i < k; i++) {
                    System.out.print(assignments[i] == 10 ? "C" : "J");
                }
                System.out.println();
            }
        }
    }
}