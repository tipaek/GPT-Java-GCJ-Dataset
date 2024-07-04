import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 1; i <= testCases; ++i) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] inputs = new String[n];
            for (int j = 0; j < n; j++) {
                inputs[j] = scanner.nextLine();
            }
            String result = new Solution().findSchedule(inputs);
            if (result.contains("IMPOSSIBLE")) {
                result = "IMPOSSIBLE";
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
    
    private String findSchedule(String[] inputs) {
        List<int[]> cSchedule = new ArrayList<>();
        List<int[]> jSchedule = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();
        
        for (String input : inputs) {
            String[] timeSlots = input.split(" ");
            int start = Integer.parseInt(timeSlots[0]);
            int end = Integer.parseInt(timeSlots[1]);
            int[] currentSlot = {start, end};
            
            boolean conflictWithC = hasConflict(cSchedule, currentSlot);
            boolean conflictWithJ = hasConflict(jSchedule, currentSlot);
            
            if (!conflictWithC) {
                cSchedule.add(currentSlot);
                schedule.append("C");
            } else if (!conflictWithJ) {
                jSchedule.add(currentSlot);
                schedule.append("J");
            } else {
                schedule.append("IMPOSSIBLE");
                break;
            }
        }
        return schedule.toString();
    }
    
    private boolean hasConflict(List<int[]> schedule, int[] currentSlot) {
        for (int[] slot : schedule) {
            if ((currentSlot[0] < slot[1] && currentSlot[1] > slot[0])) {
                return true;
            }
        }
        return false;
    }
}