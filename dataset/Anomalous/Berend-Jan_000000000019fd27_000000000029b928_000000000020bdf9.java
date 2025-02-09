import java.io.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = in.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int N = in.nextInt();
            int[][] events = new int[N][3];
            int endTimeC = 0;
            int endTimeJ = 0;

            for (int i = 0; i < N; i++) {
                events[i][0] = in.nextInt();
                events[i][1] = in.nextInt();
            }

            boolean possible = true;
            for (int i = 0; i < N; i++) {
                int earliestEventIndex = -1;
                int earliestStartTime = Integer.MAX_VALUE;

                for (int j = 0; j < N; j++) {
                    if (events[j][2] == 0 && events[j][0] < earliestStartTime) {
                        earliestEventIndex = j;
                        earliestStartTime = events[j][0];
                    }
                }

                if (earliestEventIndex == -1) {
                    break; // No more events to process
                }

                if (endTimeC <= endTimeJ) {
                    if (endTimeC > events[earliestEventIndex][0]) {
                        possible = false;
                        break;
                    }
                    endTimeC = events[earliestEventIndex][1];
                    events[earliestEventIndex][2] = 1;
                } else {
                    if (endTimeJ > events[earliestEventIndex][0]) {
                        possible = false;
                        break;
                    }
                    endTimeJ = events[earliestEventIndex][1];
                    events[earliestEventIndex][2] = 2;
                }
            }

            if (!possible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    result.append(events[i][2] == 1 ? "C" : "J");
                }
                System.out.println("Case #" + testCase + ": " + result.toString());
            }
        }
    }
}