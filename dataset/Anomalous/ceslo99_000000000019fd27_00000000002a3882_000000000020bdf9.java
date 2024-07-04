import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            int[][] schedule = new int[2][n];
            for (int j = 0; j < n; j++) {
                schedule[0][j] = scanner.nextInt();
                schedule[1][j] = scanner.nextInt();
            }
            assignTasks(schedule, i);
        }
    }

    public static void assignTasks(int[][] schedule, int caseNum) {
        int[][] jamieTasks = new int[2][schedule[0].length];
        int[][] cameronTasks = new int[2][schedule[0].length];
        int jamieCount = 0, cameronCount = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < schedule[0].length; i++) {
            boolean canAssignToJamie = true, canAssignToCameron = true;

            for (int j = 0; j < jamieCount; j++) {
                if ((schedule[0][i] < jamieTasks[1][j] && schedule[1][i] > jamieTasks[0][j])) {
                    canAssignToJamie = false;
                    break;
                }
            }

            if (canAssignToJamie) {
                jamieTasks[0][jamieCount] = schedule[0][i];
                jamieTasks[1][jamieCount] = schedule[1][i];
                jamieCount++;
                result.append("J");
            } else {
                for (int j = 0; j < cameronCount; j++) {
                    if ((schedule[0][i] < cameronTasks[1][j] && schedule[1][i] > cameronTasks[0][j])) {
                        canAssignToCameron = false;
                        break;
                    }
                }

                if (canAssignToCameron) {
                    cameronTasks[0][cameronCount] = schedule[0][i];
                    cameronTasks[1][cameronCount] = schedule[1][i];
                    cameronCount++;
                    result.append("C");
                } else {
                    System.out.println("Case #" + (caseNum + 1) + ": IMPOSSIBLE");
                    return;
                }
            }
        }

        System.out.println("Case #" + (caseNum + 1) + ": " + result.toString());
    }
}