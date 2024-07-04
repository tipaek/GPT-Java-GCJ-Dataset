import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();

        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            int numTasks = input.nextInt();
            int[][] tasks = new int[numTasks][4];

            for (int taskIndex = 0; taskIndex < numTasks; taskIndex++) {
                tasks[taskIndex][0] = input.nextInt();
                tasks[taskIndex][1] = input.nextInt();
                tasks[taskIndex][2] = taskIndex;
                tasks[taskIndex][3] = -2;
            }

            Arrays.sort(tasks, new Comparator<int[]>() {
                @Override
                public int compare(int[] task1, int[] task2) {
                    return Integer.compare(task1[0], task2[0]);
                }
            });

            int cEndTime = 0;
            int jEndTime = 0;

            for (int[] task : tasks) {
                if (task[0] >= cEndTime) {
                    cEndTime = task[1];
                    task[3] = 1; // Assign to C
                } else if (task[0] >= jEndTime) {
                    jEndTime = task[1];
                    task[3] = 0; // Assign to J
                } else {
                    task[3] = -1; // Impossible
                }
            }

            Arrays.sort(tasks, new Comparator<int[]>() {
                @Override
                public int compare(int[] task1, int[] task2) {
                    return Integer.compare(task1[2], task2[2]);
                }
            });

            StringBuilder result = new StringBuilder();
            for (int[] task : tasks) {
                if (task[3] == -1) {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                } else if (task[3] == 1) {
                    result.append("C");
                } else if (task[3] == 0) {
                    result.append("J");
                }
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + result);
        }

        input.close();
    }
}