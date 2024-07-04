import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            String result = processTestCase(scanner);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String processTestCase(Scanner scanner) {
        int numSchedules = scanner.nextInt();
        scanner.nextLine();
        
        PriorityQueue<int[]> intervals = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        );

        for (int i = 0; i < numSchedules; i++) {
            String[] parts = scanner.nextLine().split(" ");
            int start = Integer.parseInt(parts[0]);
            int end = Integer.parseInt(parts[1]);
            intervals.offer(new int[] { start, end, i });
        }

        int cameronEnd = 0;
        int jamieEnd = 0;
        char[] schedule = new char[numSchedules];

        while (!intervals.isEmpty()) {
            int[] current = intervals.poll();
            int start = current[0];
            int end = current[1];
            int index = current[2];

            if (cameronEnd <= start) {
                schedule[index] = 'C';
                cameronEnd = end;
            } else if (jamieEnd <= start) {
                schedule[index] = 'J';
                jamieEnd = end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(schedule);
    }
}