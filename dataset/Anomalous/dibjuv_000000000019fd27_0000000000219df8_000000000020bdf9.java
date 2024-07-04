/*
 * Created by cravuri on 4/3/20
 */

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int numEvents = scanner.nextInt();
            int[][] events = new int[2 * numEvents][3];
            
            for (int i = 0; i < numEvents; i++) {
                events[2 * i][0] = scanner.nextInt();
                events[2 * i][1] = i;
                events[2 * i][2] = 1;

                events[2 * i + 1][0] = scanner.nextInt();
                events[2 * i + 1][1] = i;
                events[2 * i + 1][2] = -1;
            }
            
            Arrays.sort(events, (event1, event2) -> {
                if (event1[0] == event2[0]) {
                    return Integer.compare(event1[2], event2[2]);
                }
                return Integer.compare(event1[0], event2[0]);
            });
            
            int[] available = {-1, -1};
            boolean possible = true;
            char[] assignments = new char[numEvents];
            
            for (int[] event : events) {
                if (event[2] == 1) { // Start of an event
                    if (available[0] == -1) {
                        available[0] = event[1];
                        assignments[event[1]] = 'C';
                    } else if (available[1] == -1) {
                        available[1] = event[1];
                        assignments[event[1]] = 'J';
                    } else {
                        possible = false;
                        break;
                    }
                } else { // End of an event
                    if (available[0] == event[1]) {
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
    }
}