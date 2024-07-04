import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();  // Number of test cases

        for (int t = 0; t < testCases; t++) {
            int numEvents = scanner.nextInt(); // Number of events
            char[] schedule = new char[numEvents];
            int[][] events = new int[numEvents][2]; // Array to store event timings

            for (int i = 0; i < numEvents; i++) {
                events[i][0] = scanner.nextInt();
                events[i][1] = scanner.nextInt();
            }

            boolean isOverlapping = false;
            int cStart = 0, cEnd = 0;
            int jStart = 0, jEnd = 0;

            for (int i = 0; i < numEvents; i++) {
                if (isOverlapping) break;

                if (i == 0) {
                    schedule[i] = 'C';
                    cStart = events[i][0];
                    cEnd = events[i][1];
                } else if (i == 1) {
                    if (events[i][0] >= events[i - 1][1]) {
                        schedule[i] = 'C';
                        cStart = events[i][0];
                        cEnd = events[i][1];
                    } else {
                        schedule[i] = 'J';
                        jStart = events[i][0];
                        jEnd = events[i][1];
                    }
                } else {
                    if (schedule[i - 1] == 'C') {
                        if (events[i][0] >= events[i - 1][1]) {
                            schedule[i] = 'C';
                            cStart = events[i][0];
                            cEnd = events[i][1];
                        } else if (events[i][0] >= jEnd || events[i][1] <= jStart) {
                            schedule[i] = 'J';
                            jStart = events[i][0];
                            jEnd = events[i][1];
                        } else {
                            isOverlapping = true;
                        }
                    } else {
                        if (events[i][0] >= events[i - 1][1]) {
                            schedule[i] = 'J';
                            jStart = events[i][0];
                            jEnd = events[i][1];
                        } else if (events[i][0] >= cEnd || events[i][1] <= cStart) {
                            schedule[i] = 'C';
                            cStart = events[i][0];
                            cEnd = events[i][1];
                        } else {
                            isOverlapping = true;
                        }
                    }
                }
            }

            if (isOverlapping) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (t + 1) + ": " + new String(schedule));
            }
        }

        scanner.close();
    }
}