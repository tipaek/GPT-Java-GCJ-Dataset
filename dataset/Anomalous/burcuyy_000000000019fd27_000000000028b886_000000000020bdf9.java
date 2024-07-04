import java.io.*;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activitiesCount = scanner.nextInt();
            int[] startTimes = new int[activitiesCount];
            int[] endTimes = new int[activitiesCount];
            StringBuilder schedule = new StringBuilder();
            
            for (int i = 0; i < activitiesCount; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
                
                boolean cameronAvailable = true;
                boolean jamieAvailable = true;
                
                if (!schedule.toString().equals("IMPOSSIBLE")) {
                    for (int j = 0; j < i; j++) {
                        if (schedule.charAt(j) == 'C') {
                            if (cameronAvailable && overlap(startTimes[i], endTimes[i], startTimes[j], endTimes[j])) {
                                cameronAvailable = false;
                            }
                        } else {
                            if (jamieAvailable && overlap(startTimes[i], endTimes[i], startTimes[j], endTimes[j])) {
                                jamieAvailable = false;
                            }
                        }
                    }
                    
                    if (cameronAvailable) {
                        schedule.append('C');
                    } else if (jamieAvailable) {
                        schedule.append('J');
                    } else {
                        schedule.setLength(0); // Clear the schedule
                        schedule.append("IMPOSSIBLE");
                        break;
                    }
                }
            }
            System.out.println("Case #" + caseNumber + ": " + schedule.toString());
        }
    }

    private static boolean overlap(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && end1 > start2);
    }
}