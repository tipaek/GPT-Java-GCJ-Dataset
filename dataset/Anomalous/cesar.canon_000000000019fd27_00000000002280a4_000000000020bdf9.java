import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            
            boolean[] cameronSchedule = new boolean[1441];
            boolean[] jamieSchedule = new boolean[1441];
            StringBuilder result = new StringBuilder();
            boolean isPossible = true;
            
            int activities = Integer.parseInt(reader.readLine());
            
            for (int activityIndex = 0; activityIndex < activities; activityIndex++) {
                String[] timeLimits = reader.readLine().split(" ");
                int start = Integer.parseInt(timeLimits[0]);
                int end = Integer.parseInt(timeLimits[1]);
                boolean cameronConflict = false;
                boolean jamieConflict = false;
                
                for (int time = start; time < end; time++) {
                    if (cameronSchedule[time]) {
                        cameronConflict = true;
                        break;
                    }
                }
                
                if (!cameronConflict) {
                    for (int time = start; time < end; time++) {
                        cameronSchedule[time] = true;
                    }
                    result.append("C");
                } else {
                    for (int time = start; time < end; time++) {
                        if (jamieSchedule[time]) {
                            jamieConflict = true;
                            break;
                        }
                    }
                    
                    if (!jamieConflict) {
                        for (int time = start; time < end; time++) {
                            jamieSchedule[time] = true;
                        }
                        result.append("J");
                    } else {
                        isPossible = false;
                        break;
                    }
                }
            }
            
            if (isPossible) {
                System.out.println("Case #" + (caseIndex + 1) + ": " + result.toString());
            } else {
                System.out.println("Case #" + (caseIndex + 1) + ": IMPOSSIBLE");
            }
        }
    }
}