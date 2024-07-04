import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int[] cameronSchedule = new int[1500];
            int[] jamieSchedule = new int[1500];
            int numberOfActivities = scanner.nextInt();
            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();
            
            for (int activityIndex = 0; activityIndex < numberOfActivities; activityIndex++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                
                if (isImpossible) {
                    continue;
                }
                
                boolean cameronAvailable = true;
                for (int time = startTime; time < endTime; time++) {
                    if (cameronSchedule[time] == 1) {
                        cameronAvailable = false;
                        break;
                    }
                }
                
                if (cameronAvailable) {
                    for (int time = startTime; time < endTime; time++) {
                        cameronSchedule[time] = 1;
                    }
                    result.append("C");
                } else {
                    boolean jamieAvailable = true;
                    for (int time = startTime; time < endTime; time++) {
                        if (jamieSchedule[time] == 1) {
                            result.setLength(0);
                            result.append("IMPOSSIBLE");
                            isImpossible = true;
                            break;
                        }
                    }
                    
                    if (!isImpossible) {
                        for (int time = startTime; time < endTime; time++) {
                            jamieSchedule[time] = 1;
                        }
                        result.append("J");
                    }
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }
}