import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numActivities = Integer.parseInt(scanner.nextLine());
            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];
            
            for (int i = 0; i < numActivities; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            scanner.nextLine(); // Consume the remaining newline
            
            ArrayList<String> cSchedule = new ArrayList<>();
            ArrayList<String> jSchedule = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < numActivities; i++) {
                boolean canAssignToC = true;
                boolean canAssignToJ = true;
                
                for (String time : cSchedule) {
                    int cStart = Integer.parseInt(time.split(" ")[0]);
                    int cEnd = Integer.parseInt(time.split(" ")[1]);
                    if ((cStart <= startTimes[i] && cEnd > startTimes[i]) || 
                        (cStart < endTimes[i] && cEnd >= endTimes[i]) || 
                        (cStart <= startTimes[i] && cEnd >= endTimes[i]) || 
                        (cStart >= startTimes[i] && cEnd <= endTimes[i])) {
                        canAssignToC = false;
                        break;
                    }
                }
                
                for (String time : jSchedule) {
                    int jStart = Integer.parseInt(time.split(" ")[0]);
                    int jEnd = Integer.parseInt(time.split(" ")[1]);
                    if ((jStart <= startTimes[i] && jEnd > startTimes[i]) || 
                        (jStart < endTimes[i] && jEnd >= endTimes[i]) || 
                        (jStart <= startTimes[i] && jEnd >= endTimes[i]) || 
                        (jStart >= startTimes[i] && jEnd <= endTimes[i])) {
                        canAssignToJ = false;
                        break;
                    }
                }
                
                String timeSlot = startTimes[i] + " " + endTimes[i];
                if (canAssignToC && !result.toString().equals("IMPOSSIBLE")) {
                    cSchedule.add(0, timeSlot);
                    result.append("C");
                } else if (canAssignToJ && !result.toString().equals("IMPOSSIBLE")) {
                    jSchedule.add(0, timeSlot);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + testCase + ": " + result);
        }
        scanner.close();
    }
}