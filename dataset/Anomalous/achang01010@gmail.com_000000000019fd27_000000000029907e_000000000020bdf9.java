import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt(); 
        
        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            boolean isPossible = true;
            StringBuilder schedule = new StringBuilder();
            boolean[] scheduleC = new boolean[1440];
            boolean[] scheduleJ = new boolean[1440];
            
            int numEvents = sc.nextInt();
            for (int eventIndex = 0; eventIndex < numEvents; eventIndex++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                
                boolean canAssignC = true;
                boolean canAssignJ = true;
                
                for (int time = start; time < end; time++) {
                    if (scheduleC[time]) {
                        canAssignC = false;
                        break;
                    }
                }
                
                if (canAssignC) {
                    schedule.append("C");
                    for (int time = start; time < end; time++) {
                        scheduleC[time] = true;
                    }
                } else {
                    for (int time = start; time < end; time++) {
                        if (scheduleJ[time]) {
                            canAssignJ = false;
                            break;
                        }
                    }
                    
                    if (canAssignJ) {
                        schedule.append("J");
                        for (int time = start; time < end; time++) {
                            scheduleJ[time] = true;
                        }
                    } else {
                        isPossible = false;
                    }
                }
            }
            
            if (!isPossible) {
                System.out.println("Case #" + (caseIndex + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (caseIndex + 1) + ": " + schedule.toString());
            }
        }
        
        sc.close();
    }
}