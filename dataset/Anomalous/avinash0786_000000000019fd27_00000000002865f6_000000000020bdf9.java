import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int numEvents = scanner.nextInt();
            int[][] events = new int[numEvents][2];

            for (int i = 0; i < numEvents; i++) {
                events[i][0] = scanner.nextInt();
                events[i][1] = scanner.nextInt();
            }

            String result = allocateSchedules(events);
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }

    private static String allocateSchedules(int[][] events) {
        char[] allocation = new char[events.length];
        int cEnd = 0, jEnd = 0;

        for (int i = 0; i < events.length; i++) {
            if (i == 0) {
                allocation[i] = 'C';
                cEnd = events[i][1];
            } else if (i == 1) {
                if (events[i][0] >= events[i - 1][1]) {
                    allocation[i] = 'C';
                    cEnd = events[i][1];
                } else {
                    allocation[i] = 'J';
                    jEnd = events[i][1];
                }
            } else {
                if (allocation[i - 1] == 'C') {
                    if (events[i][0] >= events[i - 1][1]) {
                        allocation[i] = 'C';
                        cEnd = events[i][1];
                    } else if (events[i][0] >= jEnd || events[i][1] <= events[0][0]) {
                        allocation[i] = 'J';
                        jEnd = events[i][1];
                    } else {
                        return "IMPOSSIBLE";
                    }
                } else {
                    if (events[i][0] >= events[i - 1][1]) {
                        allocation[i] = 'J';
                        jEnd = events[i][1];
                    } else if (events[i][0] >= cEnd || events[i][1] <= events[0][0]) {
                        allocation[i] = 'C';
                        cEnd = events[i][1];
                    } else {
                        return "IMPOSSIBLE";
                    }
                }
            }
        }

        return new String(allocation);
    }
}