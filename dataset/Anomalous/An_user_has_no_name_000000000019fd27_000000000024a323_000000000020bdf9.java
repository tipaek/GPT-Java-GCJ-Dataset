import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            boolean[] cameronSchedule = new boolean[1441];
            boolean[] jamieSchedule = new boolean[1441];
            boolean isPossible = true;
            StringBuilder result = new StringBuilder();
            
            int n = in.nextInt();
            int start = in.nextInt();
            int end = in.nextInt();
            
            // Initial assignment for the first task
            for (int j = start; j <= end; j++) {
                cameronSchedule[j] = true;
            }
            result.append("C");
            
            for (int j = 2; j <= n; j++) {
                boolean canAssignToCameron = true;
                boolean canAssignToJamie = true;
                
                start = in.nextInt();
                end = in.nextInt();
                
                if (isPossible) {
                    // Check if the task can be assigned to Jamie
                    for (int k = start; k < end; k++) {
                        if (jamieSchedule[k]) {
                            canAssignToCameron = false;
                            break;
                        }
                    }
                    
                    if (canAssignToCameron) {
                        for (int k = start; k <= end; k++) {
                            jamieSchedule[k] = true;
                        }
                        result.append("J");
                    } else {
                        // Check if the task can be assigned to Cameron
                        for (int k = start; k < end; k++) {
                            if (cameronSchedule[k]) {
                                canAssignToJamie = false;
                                break;
                            }
                        }
                        
                        if (canAssignToJamie) {
                            for (int k = start; k <= end; k++) {
                                cameronSchedule[k] = true;
                            }
                            result.append("C");
                        }
                    }
                    
                    if (!canAssignToCameron && !canAssignToJamie) {
                        result.setLength(0);
                        result.append("IMPOSSIBLE");
                        isPossible = false;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}