import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][2];
            int[][] tempActivities = new int[activityCount][2];
            StringBuilder output = new StringBuilder();
            
            for (int i = 0; i < activityCount; i++) {
                for (int j = 0; j < 2; j++) {
                    activities[i][j] = scanner.nextInt();
                    tempActivities[i][j] = activities[i][j];
                }
            }
            
            String result = "";
            int overlapCount = 0;
            int lastChance = 0;
            
            for (int i = 0; i < activityCount; i++) {
                for (int j = 0; j < i; j++) {
                    if ((activities[i][0] >= tempActivities[j][0] && activities[i][0] < tempActivities[j][1]) ||
                        (activities[i][1] >= tempActivities[j][0] && activities[i][1] < tempActivities[j][1])) {
                        overlapCount++;
                        lastChance = j;
                    }
                }
                
                switch (overlapCount) {
                    case 0:
                        if (i == 0 || output.charAt(lastChance) == 'C') {
                            output.append('C');
                        } else {
                            output.append('J');
                        }
                        break;
                    case 1:
                        if (output.charAt(lastChance) == 'C') {
                            output.append('J');
                        } else {
                            output.append('C');
                        }
                        break;
                    default:
                        result = "IMPOSSIBLE";
                        break;
                }
                
                if ("IMPOSSIBLE".equals(result)) {
                    break;
                }
                
                overlapCount = 0;
            }
            
            System.out.println("Case #" + caseNumber + ": " + ("IMPOSSIBLE".equals(result) ? result : output.toString()));
        }
    }
}