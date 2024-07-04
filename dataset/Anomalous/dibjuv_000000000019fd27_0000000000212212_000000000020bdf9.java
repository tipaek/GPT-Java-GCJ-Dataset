import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int numActivities = scanner.nextInt();
            int[][] events = new int[numActivities * 2][3];
            
            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                events[2 * i][0] = start;
                events[2 * i][1] = i;
                events[2 * i][2] = 1; // Start event
                
                events[2 * i + 1][0] = end;
                events[2 * i + 1][1] = i;
                events[2 * i + 1][2] = -1; // End event
            }
            
            Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
            
            int[] available = {-1, -1}; // -1 means available
            boolean isPossible = true;
            char[] assignments = new char[numActivities];
            
            for (int[] event : events) {
                int time = event[0];
                int index = event[1];
                int type = event[2];
                
                if (type == 1) { // Start event
                    if (available[0] == -1) {
                        available[0] = index;
                        assignments[index] = 'C';
                    } else if (available[1] == -1) {
                        available[1] = index;
                        assignments[index] = 'J';
                    } else {
                        isPossible = false;
                        break;
                    }
                } else { // End event
                    if (available[0] == index) {
                        available[0] = -1;
                    } else {
                        available[1] = -1;
                    }
                }
            }
            
            if (isPossible) {
                System.out.println("Case #" + t + ": " + new String(assignments));
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}