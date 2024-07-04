import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader kbd = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(kbd.readLine());
        
        for (int i = 1; i <= times; i++) {
            int n = Integer.parseInt(kbd.readLine());
            boolean[] cTime = new boolean[1440];
            boolean[] jTime = new boolean[1440];
            StringBuilder output = new StringBuilder();
            boolean possible = true;
            
            for (int j = 0; j < n; j++) {
                String[] input = kbd.readLine().split(" ");
                int startIn = Integer.parseInt(input[0]);
                int endIn = Integer.parseInt(input[1]);
                
                boolean cCheck = isTimeSlotAvailable(cTime, startIn, endIn);
                boolean jCheck = isTimeSlotAvailable(jTime, startIn, endIn);
                
                if (cCheck) {
                    output.append("C");
                    fillTimeSlots(cTime, startIn, endIn);
                } else if (jCheck) {
                    output.append("J");
                    fillTimeSlots(jTime, startIn, endIn);
                } else {
                    output = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            
            System.out.println("Case #" + i + ": " + output);
        }
        
        kbd.close();
    }
    
    private static boolean isTimeSlotAvailable(boolean[] timeSlots, int start, int end) {
        for (int k = start; k < end; k++) {
            if (timeSlots[k]) {
                return false;
            }
        }
        return true;
    }
    
    private static void fillTimeSlots(boolean[] timeSlots, int start, int end) {
        Arrays.fill(timeSlots, start, end, true);
    }
}