import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        System.out.println();

        for (int i = 0; i < testCaseCount; i++) {
            int eventCount = scanner.nextInt();
            char[] allocation = new char[eventCount];
            int[][] events = new int[eventCount][2];

            for (int j = 0; j < eventCount; j++) {
                events[j][0] = scanner.nextInt();
                events[j][1] = scanner.nextInt();
            }

            boolean overlapping = false;
            int cEnd = 0, jEnd = 0;

            for (int j = 0; j < eventCount; j++) {
                if (j == 0) {
                    allocation[j] = 'C';
                    cEnd = events[j][1];
                } else if (j == 1) {
                    if (events[j][0] >= events[j - 1][1]) {
                        allocation[j] = 'C';
                        cEnd = events[j][1];
                    } else {
                        allocation[j] = 'J';
                        jEnd = events[j][1];
                    }
                } else {
                    if (allocation[j - 1] == 'C') {
                        if (events[j][0] >= events[j - 1][1]) {
                            allocation[j] = 'C';
                            cEnd = events[j][1];
                        } else if (events[j][0] >= jEnd) {
                            allocation[j] = 'J';
                            jEnd = events[j][1];
                        } else {
                            overlapping = true;
                            break;
                        }
                    } else {
                        if (events[j][0] >= events[j - 1][1]) {
                            allocation[j] = 'J';
                            jEnd = events[j][1];
                        } else if (events[j][0] >= cEnd) {
                            allocation[j] = 'C';
                            cEnd = events[j][1];
                        } else {
                            overlapping = true;
                            break;
                        }
                    }
                }
            }

            if (!overlapping) {
                System.out.println("Case #" + (i + 1) + ": " + new String(allocation));
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}