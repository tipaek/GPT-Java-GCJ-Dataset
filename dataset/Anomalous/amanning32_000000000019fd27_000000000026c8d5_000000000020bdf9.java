import java.util.Scanner;

class Solution {

    private static String assignTasks(int[][] tasks) {
        StringBuilder result = new StringBuilder();
        
        boolean[] scheduleC = new boolean[24 * 60];
        boolean[] scheduleJ = new boolean[24 * 60];
        
        for (int[] task : tasks) {
            boolean canAssignC = true;
            boolean canAssignJ = true;
            
            for (int time = task[0]; time < task[1]; time++) {
                if (scheduleC[time]) canAssignC = false;
                if (scheduleJ[time]) canAssignJ = false;
            }
            
            if (canAssignC) {
                for (int time = task[0]; time < task[1]; time++) {
                    scheduleC[time] = true;
                }
                result.append("C");
            } else if (canAssignJ) {
                for (int time = task[0]; time < task[1]; time++) {
                    scheduleJ[time] = true;
                }
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.nextInt();
        
        for (int testCase = 1; testCase <= numTests; testCase++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][2];
            
            for (int i = 0; i < numActivities; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }
            
            String result = assignTasks(activities);
            System.out.println("Case #" + testCase + ": " + result);
        }
        
        scanner.close();
    }
}