import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numberOfTasks = scanner.nextInt();
            int[][] tasks = new int[numberOfTasks][3];

            for (int i = 0; i < numberOfTasks; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
                tasks[i][2] = i;
            }

            int[][] sortedTasks = sortTasksByStartTime(tasks);
            printResult(testCase, sortedTasks);
        }
    }

    private static int[][] sortTasksByStartTime(int[][] tasks) {
        int numberOfTasks = tasks.length;
        int[][] sortedTasks = new int[numberOfTasks][3];

        for (int i = 0; i < numberOfTasks; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numberOfTasks; j++) {
                if (tasks[j][0] < tasks[minIndex][0]) {
                    minIndex = j;
                }
            }
            int[] temp = tasks[i];
            tasks[i] = tasks[minIndex];
            tasks[minIndex] = temp;
            sortedTasks[i] = tasks[i];
        }

        return sortedTasks;
    }

    private static void printResult(int testCase, int[][] tasks) {
        StringBuilder result = new StringBuilder();
        int cFinishTime = 0;
        int jFinishTime = 0;
        String[] assignedPerson = new String[tasks.length];

        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i][0] >= cFinishTime) {
                assignedPerson[i] = "C";
                cFinishTime = tasks[i][1];
            } else if (tasks[i][0] >= jFinishTime) {
                assignedPerson[i] = "J";
                jFinishTime = tasks[i][1];
            } else {
                result.append("Case #").append(testCase).append(": IMPOSSIBLE");
                System.out.println(result.toString());
                return;
            }
        }

        for (int i = 0; i < tasks.length; i++) {
            for (int j = 0; j < tasks.length; j++) {
                if (tasks[j][2] == i) {
                    result.append(assignedPerson[j]);
                    break;
                }
            }
        }

        System.out.println("Case #" + testCase + ": " + result.toString());
    }
}