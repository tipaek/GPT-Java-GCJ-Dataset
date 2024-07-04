import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner inp = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = inp.nextInt(); // number of test cases
        
        for (int i = 0; i < t; i++) {
            int N = inp.nextInt(); // number of events
            int[][] events = new int[N][2]; // array to store start and end times of events
            char[] schedule = new char[N]; // array to store the schedule ('C' or 'J')
            boolean overlapping = false;
            
            for (int j = 0; j < N; j++) {
                events[j][0] = inp.nextInt(); // start time
                events[j][1] = inp.nextInt(); // end time
            }
            
            int c_end = 0, j_end = 0; // end times for Cameron and Jamie
            
            for (int j = 0; j < N; j++) {
                if (events[j][0] >= c_end) {
                    schedule[j] = 'C';
                    c_end = events[j][1];
                } else if (events[j][0] >= j_end) {
                    schedule[j] = 'J';
                    j_end = events[j][1];
                } else {
                    overlapping = true;
                    break;
                }
            }
            
            if (overlapping) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (i + 1) + ": ");
                System.out.println(new String(schedule));
            }
        }
    }
}