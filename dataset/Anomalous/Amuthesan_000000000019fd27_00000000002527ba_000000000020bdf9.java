import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int activitiesCount = scanner.nextInt();
            int[][] cameronSchedule = new int[activitiesCount][2];
            int[][] jamieSchedule = new int[activitiesCount][2];
            StringBuilder resultSchedule = new StringBuilder();
            
            for (int j = 0; j < activitiesCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                if (isTimeSlotAvailable(cameronSchedule, start, end)) {
                    resultSchedule.append('C');
                    cameronSchedule[j][0] = start;
                    cameronSchedule[j][1] = end;
                } else if (isTimeSlotAvailable(jamieSchedule, start, end)) {
                    resultSchedule.append('J');
                    jamieSchedule[j][0] = start;
                    jamieSchedule[j][1] = end;
                } else {
                    resultSchedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            
            System.out.println("Case #" + i + ": " + resultSchedule);
        }
    }

    private static boolean isTimeSlotAvailable(int[][] schedule, int startTime, int endTime) {
        for (int[] timeSlot : schedule) {
            if (startTime < timeSlot[1] && endTime > timeSlot[0]) {
                return false;
            }
        }
        return true;
    }
}