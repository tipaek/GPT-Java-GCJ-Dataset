import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ParentingPartneringReturns {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int numActivities = scanner.nextInt();
            int[][] events = new int[2 * numActivities][3];
            
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
            
            Arrays.sort(events, new Comparator<int[]>() {
                @Override
                public int compare(int[] event1, int[] event2) {
                    if (event1[0] == event2[0]) {
                        return Integer.compare(event1[2], event2[2]);
                    }
                    return Integer.compare(event1[0], event2[0]);
                }
            });
            
            int[] available = new int[2];
            available[0] = -1; // Cameron
            available[1] = -1; // Jamie
            boolean possible = true;
            char[] assignments = new char[numActivities];
            
            for (int[] event : events) {
                int time = event[0];
                int activityIndex = event[1];
                int eventType = event[2];
                
                if (eventType == 1) { // Start event
                    if (available[0] == -1) {
                        available[0] = activityIndex;
                        assignments[activityIndex] = 'C';
                    } else if (available[1] == -1) {
                        available[1] = activityIndex;
                        assignments[activityIndex] = 'J';
                    } else {
                        possible = false;
                        break;
                    }
                } else { // End event
                    if (available[0] == activityIndex) {
                        available[0] = -1;
                    } else {
                        available[1] = -1;
                    }
                }
            }
            
            if (possible) {
                System.out.println("Case #" + t + ": " + new String(assignments));
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}