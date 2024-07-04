import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            solve(startTimes, endTimes, testCase);
        }
    }

    static class Event {
        int start;
        int end;
        int id;

        Event(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }
    }

    public static void solve(int[] startTimes, int[] endTimes, int testCaseNumber) {
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < startTimes.length; i++) {
            events.add(new Event(startTimes[i], endTimes[i], i));
        }

        events.sort(Comparator.comparingInt(e -> e.start));

        int cEndTime = -1;
        int jEndTime = -1;
        StringBuilder solution = new StringBuilder();
        int[] assignments = new int[startTimes.length];

        for (Event event : events) {
            if (event.start >= jEndTime) {
                assignments[event.id] = 1; // Assign to J
                jEndTime = event.end;
            } else if (event.start >= cEndTime) {
                assignments[event.id] = 2; // Assign to C
                cEndTime = event.end;
            } else {
                solution.append("IMPOSSIBLE");
                break;
            }
        }

        if (solution.length() == 0) {
            for (int assignment : assignments) {
                solution.append(assignment == 1 ? "J" : "C");
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + solution);
    }
}