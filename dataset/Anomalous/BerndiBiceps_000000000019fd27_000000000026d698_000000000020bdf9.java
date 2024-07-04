import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activities = scanner.nextInt();
            int[][] intervals = new int[activities][2];

            for (int i = 0; i < activities; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            boolean[] assignedToCameron = new boolean[activities];
            Set<Integer> usedIndices = new HashSet<>();
            int lastCameron = -1;
            int lastJamie = -1;
            boolean isPossible = true;

            for (int i = 0; i < activities; i++) {
                int earliestStart = Integer.MAX_VALUE;
                int selectedIndex = -1;
                for (int j = 0; j < activities; j++) {
                    if (usedIndices.contains(j)) {
                        continue;
                    }
                    if (intervals[j][0] < earliestStart) {
                        earliestStart = intervals[j][0];
                        selectedIndex = j;
                    }
                }

                if (lastCameron == -1 || intervals[selectedIndex][0] >= intervals[lastCameron][1]) {
                    assignedToCameron[selectedIndex] = true;
                    lastCameron = selectedIndex;
                } else if (lastJamie == -1 || intervals[selectedIndex][0] >= intervals[lastJamie][1]) {
                    lastJamie = selectedIndex;
                } else {
                    isPossible = false;
                    break;
                }

                usedIndices.add(selectedIndex);
            }

            System.out.print("Case #" + testCase + ": ");
            if (isPossible) {
                for (int i = 0; i < activities; i++) {
                    System.out.print(assignedToCameron[i] ? 'C' : 'J');
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}