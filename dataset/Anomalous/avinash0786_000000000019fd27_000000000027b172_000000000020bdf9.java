import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int numEvents = scanner.nextInt();
            int[][] events = new int[numEvents][2];
            char[] allocation = new char[numEvents];
            
            for (int j = 0; j < numEvents; j++) {
                events[j][0] = scanner.nextInt();
                events[j][1] = scanner.nextInt();
            }
            
            boolean isPossible = allocateSchedules(events, allocation);
            
            if (isPossible) {
                System.out.println("Case #" + (i + 1) + ": " + new String(allocation));
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
    
    private static boolean allocateSchedules(int[][] events, char[] allocation) {
        int cEnd = 0, jEnd = 0;
        
        for (int i = 0; i < events.length; i++) {
            if (i == 0 || events[i][0] >= cEnd) {
                allocation[i] = 'C';
                cEnd = events[i][1];
            } else if (events[i][0] >= jEnd) {
                allocation[i] = 'J';
                jEnd = events[i][1];
            } else {
                return false;
            }
        }
        
        return true;
    }
}