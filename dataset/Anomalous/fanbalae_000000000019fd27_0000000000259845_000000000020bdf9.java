import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] originalOrder = new int[n];
            char[] assignments = new char[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = sc.nextInt();
                endTimes[i] = sc.nextInt();
                originalOrder[i] = i;
            }

            // Sort activities by start time
            Integer[] indices = new Integer[n];
            for (int i = 0; i < n; i++) {
                indices[i] = i;
            }
            Arrays.sort(indices, Comparator.comparingInt(i -> startTimes[i]));

            int cEnd = 0, jEnd = 0;
            boolean possible = true;

            for (int i : indices) {
                if (startTimes[i] >= cEnd) {
                    assignments[i] = 'C';
                    cEnd = endTimes[i];
                } else if (startTimes[i] >= jEnd) {
                    assignments[i] = 'J';
                    jEnd = endTimes[i];
                } else {
                    possible = false;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (possible) {
                for (int i = 0; i < n; i++) {
                    result.append(assignments[originalOrder[i]]);
                }
            } else {
                result.append("IMPOSSIBLE");
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }
}