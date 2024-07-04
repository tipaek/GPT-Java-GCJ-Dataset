import java.util.Scanner;

public class Solution {
    static void arrangeSchedule(int[][] tasks, int caseNumber) {
        int[][] cameronSchedule = new int[tasks.length][2];
        int[][] jamieSchedule = new int[tasks.length][2];
        int cameronCount = 0, jamieCount = 0;
        StringBuilder output = new StringBuilder();

        for (int[] task : tasks) {
            boolean overlapsWithCameron = false;
            boolean overlapsWithJamie = false;

            for (int i = 0; i < cameronCount; i++) {
                if (isOverlapping(task[0], task[1], cameronSchedule[i][0], cameronSchedule[i][1])) {
                    overlapsWithCameron = true;
                    break;
                }
            }

            if (overlapsWithCameron) {
                for (int i = 0; i < jamieCount; i++) {
                    if (isOverlapping(task[0], task[1], jamieSchedule[i][0], jamieSchedule[i][1])) {
                        overlapsWithJamie = true;
                        break;
                    }
                }
            }

            if (overlapsWithCameron && overlapsWithJamie) {
                output = new StringBuilder("IMPOSSIBLE");
                break;
            } else if (!overlapsWithCameron) {
                output.append("C");
                cameronSchedule[cameronCount++] = task;
            } else {
                output.append("J");
                jamieSchedule[jamieCount++] = task;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + output);
    }

    static boolean isOverlapping(int start1, int end1, int start2, int end2) {
        return Math.max(end1, end2) - Math.min(start1, start2) < (end1 - start1) + (end2 - start2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int numberOfTasks = scanner.nextInt();
            int[][] tasks = new int[numberOfTasks][2];

            for (int i = 0; i < numberOfTasks; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
            }

            arrangeSchedule(tasks, caseNumber);
        }

        scanner.close();
    }
}