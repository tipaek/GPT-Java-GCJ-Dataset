import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine().trim());
        
        for (int caseId = 0; caseId < testCases; caseId++) {
            int tasks = Integer.parseInt(scanner.nextLine().trim());
            int[] startTimes = new int[tasks];
            int[] endTimes = new int[tasks];
            
            for (int taskId = 0; taskId < tasks; taskId++) {
                String[] times = scanner.nextLine().trim().split(" ");
                startTimes[taskId] = Integer.parseInt(times[0]);
                endTimes[taskId] = Integer.parseInt(times[1]);
            }
            
            ParentingPartnering parentingPartnering = new ParentingPartnering(caseId, startTimes, endTimes);
            String result = parentingPartnering.compute();
            System.out.println(result);
        }
        
        scanner.close();
    }
}

class ParentingPartnering {
    private int[] startTimes;
    private int[] endTimes;
    private int testId;
    
    public ParentingPartnering(int testId, int[] startTimes, int[] endTimes) {
        this.testId = testId;
        this.startTimes = startTimes;
        this.endTimes = endTimes;
    }
    
    public String compute() {
        int[][] endHash = new int[1441][11];
        for (int i = 0; i < 1441; i++) {
            for (int j = 0; j < 11; j++) {
                endHash[i][j] = -1;
            }
        }
        
        char[] assignments = new char[endTimes.length];
        int cameronFreeFrom = 0;
        int jamieFreeFrom = 0;
        
        for (int i = 0; i < endTimes.length; i++) {
            int j = 0;
            while (j < 11 && endHash[endTimes[i]][j] != -1) {
                j++;
            }
            if (j < 11) {
                endHash[endTimes[i]][j] = i;
            } else {
                return formatOutput("IMPOSSIBLE");
            }
        }
        
        for (int i = 0; i < 1441; i++) {
            for (int j = 0; j < 11; j++) {
                if (endHash[i][j] != -1) {
                    int index = endHash[i][j];
                    if (cameronFreeFrom <= startTimes[index]) {
                        assignments[index] = 'C';
                        cameronFreeFrom = endTimes[index];
                    } else if (jamieFreeFrom <= startTimes[index]) {
                        assignments[index] = 'J';
                        jamieFreeFrom = endTimes[index];
                    } else {
                        return formatOutput("IMPOSSIBLE");
                    }
                }
            }
        }
        
        return formatOutput(new String(assignments));
    }
    
    private String formatOutput(String schedule) {
        return "Case #" + (testId + 1) + ": " + schedule;
    }
}