import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfTestCases = scanner.nextInt();
        
        for (int testCaseIndex = 0; testCaseIndex < numberOfTestCases; testCaseIndex++) {
            int caseNumber = testCaseIndex + 1;
            StringBuilder result = new StringBuilder();

            int numberOfTasks = scanner.nextInt();
            int[][] tasks = new int[numberOfTasks][2];
            
            for (int taskIndex = 0; taskIndex < numberOfTasks; taskIndex++) {
                tasks[taskIndex][0] = scanner.nextInt();
                tasks[taskIndex][1] = scanner.nextInt();
            }

            int endTimeC = 0;
            int endTimeJ = 0;

            for (int taskIndex = 0; taskIndex < numberOfTasks; taskIndex++) {
                if (tasks[taskIndex][0] >= endTimeC) {
                    endTimeC = tasks[taskIndex][1];
                    result.append("C");
                } else if (tasks[taskIndex][0] >= endTimeJ) {
                    endTimeJ = tasks[taskIndex][1];
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }

        scanner.close();
    }
}