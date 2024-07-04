import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int eventsCount = scanner.nextInt();
            int[][] events = new int[eventsCount][2];
            char[] allocation = new char[eventsCount];

            for (int i = 0; i < eventsCount; i++) {
                events[i][0] = scanner.nextInt();
                events[i][1] = scanner.nextInt();
            }

            boolean isOverlapping = false;
            int cEnd = 0, jEnd = 0;

            for (int i = 0; i < eventsCount; i++) {
                if (i == 0) {
                    allocation[i] = 'C';
                    cEnd = events[i][1];
                } else {
                    if (allocation[i - 1] == 'C') {
                        if (events[i][0] >= cEnd) {
                            allocation[i] = 'C';
                            cEnd = events[i][1];
                        } else if (events[i][0] >= jEnd) {
                            allocation[i] = 'J';
                            jEnd = events[i][1];
                        } else {
                            isOverlapping = true;
                            break;
                        }
                    } else {
                        if (events[i][0] >= jEnd) {
                            allocation[i] = 'J';
                            jEnd = events[i][1];
                        } else if (events[i][0] >= cEnd) {
                            allocation[i] = 'C';
                            cEnd = events[i][1];
                        } else {
                            isOverlapping = true;
                            break;
                        }
                    }
                }
            }

            String result = isOverlapping ? "IMPOSSIBLE" : new String(allocation);
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }
}