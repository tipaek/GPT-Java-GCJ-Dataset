import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        int testCaseNumber;
        Scanner scanner = new Scanner(System.in);
        testCaseNumber = scanner.nextInt();
        
        for (int i = 0; i <testCaseNumber; i++) {
            int totalTask = scanner.nextInt();
            
            int[][] matrix = new int [totalTask][2];
            
            for (int j = 0; j < totalTask; j++) {
                for (int k = 0; k < 2; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }
            
            System.out.println(getSchedule(matrix, totalTask, i + 1));  
        }
        
        scanner.close();
    }
    
    public static String getSchedule(int [][] schedule, int totalTask, int caseNumber) {
        String result = "Case #" + caseNumber  + ": ";
        
        int [] cameron = new int[totalTask];
        int [] jamie = new int[totalTask];
        int cameronTaskCount = 0;
        int jamieTaskCount = 0;
        String taskString = "";
              
        
        for (int i = 0; i < totalTask; i++) {
            if (cameronTaskCount == 0) {
                cameron[0] = i;
                taskString = taskString + "C";
                cameronTaskCount = 1;
            } else if (jamieTaskCount == 0) {
                jamie[0] = i;
                taskString = taskString + "J";
                jamieTaskCount = 1;
            } else {
                int secondTaskStart = schedule[i][0];
                int secondTaskEnd = schedule[i][1];
                
                // check we can assign that to cameron or not
                boolean canFit = true;
                for (int j = 0; j<cameronTaskCount; j++) {
                    int firstTaskStart = schedule[cameron[j]][0];
                    int firstTaskEnd = schedule[cameron[j]][1];
                    if (isOverLap(firstTaskStart, firstTaskEnd, secondTaskStart, secondTaskEnd)) {
                        canFit = false;
                        break;
                    }
                }
                
                if (canFit) {
                    cameron[cameronTaskCount] = i;
                    cameronTaskCount++;
                    taskString = taskString + "C";
                } else {
                    canFit = true;
                   for (int j = 0; j<jamieTaskCount; j++) {
                    int firstTaskStart = schedule[jamie[j]][0];
                    int firstTaskEnd = schedule[jamie[j]][1];
                    if (isOverLap(firstTaskStart, firstTaskEnd, secondTaskStart, secondTaskEnd)) {
                        canFit = false;
                        break;
                     }
                    } 
                   
                   if (canFit) {
                       jamie[jamieTaskCount] = i;
                       jamieTaskCount++;
                       taskString = taskString + "J";
                   } else {
                       taskString = "IMPOSSIBLE";
                       break;
                   }
                }
                
                
                        
                
                
            }
            
            
            
            
        }
        
        
        result = result + taskString;
        
        
        
        return result;
    }
    
    public static boolean isOverLap(int firsTaskStart, int firstTaskEnd, int secondTaskStart, int secondTaskEnd) {
        return ((secondTaskStart >= firsTaskStart) && (secondTaskStart < firstTaskEnd));
    }
}
