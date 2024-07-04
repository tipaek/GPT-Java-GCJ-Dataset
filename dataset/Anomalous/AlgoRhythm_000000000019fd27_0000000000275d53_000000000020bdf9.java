import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[] jamieSchedule = new int[1440];
            int[] cameronSchedule = new int[1440];
            Arrays.fill(jamieSchedule, 0);
            Arrays.fill(cameronSchedule, 0);
            
            StringBuilder result = new StringBuilder();
            boolean isPossible = true;
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                if (!isPossible) continue;
                
                boolean canAssignJamie = true;
                for (int j = start; j < end && canAssignJamie; j++) {
                    if (jamieSchedule[j] == 1) {
                        canAssignJamie = false;
                    }
                }
                
                if (canAssignJamie) {
                    Arrays.fill(jamieSchedule, start, end, 1);
                    result.append("J");
                } else {
                    boolean canAssignCameron = true;
                    for (int j = start; j < end && canAssignCameron; j++) {
                        if (cameronSchedule[j] == 1) {
                            canAssignCameron = false;
                        }
                    }
                    
                    if (canAssignCameron) {
                        Arrays.fill(cameronSchedule, start, end, 1);
                        result.append("C");
                    } else {
                        isPossible = false;
                        result = new StringBuilder("IMPOSSIBLE");
                    }
                }
            }
            
            System.out.println("Case #" + (t + 1) + ": " + result.toString());
        }
        
        scanner.close();
    }
}