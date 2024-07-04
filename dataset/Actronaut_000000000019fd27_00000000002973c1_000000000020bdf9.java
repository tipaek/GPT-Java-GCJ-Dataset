/**
 *  Alex Tresselt
 *  Google Code Jam
 *  Qualification Round - Parenting Partnering Returns
 *  4/4/20
 */

import java.util.*;
import java.io.*;

class Solution {


    public static void main(String[] args) {

        // Standard input from the FAQ
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Get number of cases
        int numCases = in.nextInt();

        // For each case:
        for (int i = 1; i <= numCases; i++) {

            // Get number of activities
            int numActivities = in.nextInt();

            // Keep track of the parents's activities.
            // int[cameron task end time, jamie task end time]
            int[] parents = new int[]{-1,-1};

            // Set up Priority Queue
            PriorityQueue<int[]> pq = new PriorityQueue<>(numActivities, (a,b) -> a[0] - b[0]);

            // Set up return String
            StringBuilder schedule = new StringBuilder();

            // Keep track if no schedule possible
            boolean impossible = false;

            // Add each activity to the Priority Queue, which will sort the activities by start time (earliest first).
            for (int j = 0; j < numActivities; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                // activity[start time, end time, order, assigned parent]
                int[] activity = new int[]{start, end, j, -1};
                pq.add(activity);
            }

            // Priority Queue to keep track of input order for output.
            PriorityQueue<int[]> pqOut = new PriorityQueue<>(numActivities, (a,b) -> a[2] - b[2]);
            
            // Assign each activity in the list.
            while (!pq.isEmpty()) {
                int[] current = pq.poll();

                // if the current activity's start time is after the end of the parent's activity,
                // assign them the activity.
                if (parents[0] <= current[0]) { // Check Cameron's availability
                    parents[0] = current[1];
                    current[3] = 0;
                    pqOut.add(current);
                } else if (parents[1] <= current[0]) { // Check Jamie's availability
                    parents[1] = current[1];
                    current[3] = 1;
                    pqOut.add(current);
                } else { // If no parents available, schedule is impossible.
                    impossible = true;
                    break;
                }

        }
            if (impossible) {
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            } else {
                while (!pqOut.isEmpty()) {
                    int[] a = pqOut.poll();
                    if (a[3] == 0) {
                        schedule.append("C");
                    } else {
                        schedule.append("J");
                    }
                }
                System.out.println("Case #" + i + ": " + schedule);
            }
        }
    }
}