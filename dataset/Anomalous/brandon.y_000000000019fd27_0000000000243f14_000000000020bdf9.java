import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases
        
        for (int i = 1; i <= t; ++i) {
            int[][] masterSched = new int[1440][2]; // Schedule array for Cameron and Jamie
            boolean impossible = false;
            StringBuilder answer = new StringBuilder();
            int w = in.nextInt(); // Number of activities

            int[][] activitiesList = new int[w][2]; // List of activities with start and end times
            for (int j = 0; j < w; j++) {
                activitiesList[j][0] = in.nextInt();
                activitiesList[j][1] = in.nextInt();
            }

            // Sort activities by start time
            Arrays.sort(activitiesList, Comparator.comparingInt(a -> a[0]));

            // Process each activity
            for (int[] activity : activitiesList) {
                int startTime = activity[0];
                int endTime = activity[1];
                boolean cameronAvailable = true;
                boolean jamieAvailable = true;

                // Check Cameron's availability
                for (int k = startTime; k < endTime && cameronAvailable; k++) {
                    if (masterSched[k][0] == 1) {
                        cameronAvailable = false;
                    }
                }

                if (cameronAvailable) {
                    // Cameron is available, mark his schedule
                    for (int k = startTime; k < endTime; k++) {
                        masterSched[k][0] = 1;
                    }
                    answer.append("C");
                } else {
                    // Check Jamie's availability
                    for (int k = startTime; k < endTime && jamieAvailable; k++) {
                        if (masterSched[k][1] == 1) {
                            jamieAvailable = false;
                        }
                    }

                    if (jamieAvailable) {
                        // Jamie is available, mark her schedule
                        for (int k = startTime; k < endTime; k++) {
                            masterSched[k][1] = 1;
                        }
                        answer.append("J");
                    } else {
                        // Neither Cameron nor Jamie is available
                        impossible = true;
                        break;
                    }
                }
            }

            if (impossible) {
                answer = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + i + ": " + answer);
        }
    }
}