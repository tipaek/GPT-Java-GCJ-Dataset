import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseNumber = scanner.nextInt();

        for (int i = 0; i < testCaseNumber; i++) {
            int totalTask = scanner.nextInt();
            int[][] matrix = new int[totalTask][2];

            for (int j = 0; j < totalTask; j++) {
                matrix[j][0] = scanner.nextInt();
                matrix[j][1] = scanner.nextInt();
            }

            System.out.println(getSchedule(matrix, totalTask, i + 1));
        }

        scanner.close();
    }

    public static String getSchedule(int[][] schedule, int totalTask, int caseNumber) {
        StringBuilder result = new StringBuilder("Case #" + caseNumber + ": ");
        StringBuilder taskString = new StringBuilder();

        int[] cameron = new int[totalTask];
        int[] jamie = new int[totalTask];
        int cameronTaskCount = 0;
        int jamieTaskCount = 0;

        for (int i = 0; i < totalTask; i++) {
            if (cameronTaskCount == 0) {
                cameron[cameronTaskCount++] = i;
                taskString.append("C");
            } else if (jamieTaskCount == 0) {
                jamie[jamieTaskCount++] = i;
                taskString.append("J");
            } else {
                int secondTaskStart = schedule[i][0];
                int secondTaskEnd = schedule[i][1];

                boolean canFitCameron = true;
                for (int j = 0; j < cameronTaskCount; j++) {
                    if (isOverLap(schedule[cameron[j]][0], schedule[cameron[j]][1], secondTaskStart, secondTaskEnd)) {
                        canFitCameron = false;
                        break;
                    }
                }

                if (canFitCameron) {
                    cameron[cameronTaskCount++] = i;
                    taskString.append("C");
                } else {
                    boolean canFitJamie = true;
                    for (int j = 0; j < jamieTaskCount; j++) {
                        if (isOverLap(schedule[jamie[j]][0], schedule[jamie[j]][1], secondTaskStart, secondTaskEnd)) {
                            canFitJamie = false;
                            break;
                        }
                    }

                    if (canFitJamie) {
                        jamie[jamieTaskCount++] = i;
                        taskString.append("J");
                    } else {
                        taskString = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
            }
        }

        result.append(taskString);
        return result.toString();
    }

    public static boolean isOverLap(int firstTaskStart, int firstTaskEnd, int secondTaskStart, int secondTaskEnd) {
        return (secondTaskStart < firstTaskEnd && secondTaskStart >= firstTaskStart);
    }
}