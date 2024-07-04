import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int eventsCount = scanner.nextInt();
            int[][] events = new int[eventsCount][2];
            char[] schedule = new char[eventsCount];

            for (int j = 0; j < eventsCount; j++) {
                events[j][0] = scanner.nextInt();
                events[j][1] = scanner.nextInt();
            }

            boolean isPossible = true;
            int cEnd = 0, jEnd = 0;

            for (int j = 0; j < eventsCount; j++) {
                if (events[j][0] >= cEnd) {
                    schedule[j] = 'C';
                    cEnd = events[j][1];
                } else if (events[j][0] >= jEnd) {
                    schedule[j] = 'J';
                    jEnd = events[j][1];
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + testCase + ": " + new String(schedule));
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }
}