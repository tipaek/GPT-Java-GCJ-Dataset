import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int i = 0; i < numberOfCases; i++) {
            int numberOfTasks = scanner.nextInt();
            int cEnd = 0, jEnd = 0;
            int[][] tasks = new int[numberOfTasks][3];
            StringBuilder result = new StringBuilder();
            boolean[] assignedToJ = new boolean[numberOfTasks];

            for (int j = 0; j < numberOfTasks; j++) {
                tasks[j][0] = scanner.nextInt();
                tasks[j][1] = scanner.nextInt();
                tasks[j][2] = j;
            }

            Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));

            boolean possible = true;
            for (int[] task : tasks) {
                int taskStart = task[0];
                int taskEnd = task[1];
                int originalIndex = task[2];

                if (cEnd <= taskStart) {
                    cEnd = taskEnd;
                    assignedToJ[originalIndex] = false; // Assigned to C
                } else if (jEnd <= taskStart) {
                    jEnd = taskEnd;
                    assignedToJ[originalIndex] = true; // Assigned to J
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                for (boolean isAssignedToJ : assignedToJ) {
                    result.append(isAssignedToJ ? 'J' : 'C');
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}