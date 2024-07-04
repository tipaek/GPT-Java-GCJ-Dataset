import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            for (int j = 0; j < n; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
            }

            List<int[]> intersections = new ArrayList<>();
            List<int[]> intersectionRanges = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int maxStart = Math.max(startTimes[j], startTimes[k]);
                    int minEnd = Math.min(endTimes[j], endTimes[k]);
                    if (minEnd > maxStart) {
                        intersections.add(new int[] { j, k });
                        intersectionRanges.add(new int[] { maxStart + 1, minEnd });
                    }
                }
            }

            int[] timeSlots = new int[1441];
            boolean isPossible = true;

            for (int i = 0; i < intersections.size() && isPossible; i++) {
                int[] range = intersectionRanges.get(i);
                for (int time = range[0]; time <= range[1] && isPossible; time++) {
                    timeSlots[time]++;
                    if (timeSlots[time] == 2) {
                        isPossible = false;
                    }
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                char[] assignments = new char[n];
                Arrays.fill(assignments, ' ');
                assignments[0] = 'J';

                for (int[] intersection : intersections) {
                    int first = intersection[0];
                    int second = intersection[1];
                    if (assignments[first] == 'J') {
                        assignments[second] = 'C';
                    } else if (assignments[first] == 'C') {
                        assignments[second] = 'J';
                    }
                }

                for (int j = 0; j < n; j++) {
                    if (assignments[j] == ' ') {
                        assignments[j] = 'J';
                    }
                }

                System.out.print("Case #" + caseNumber + ": ");
                for (char assignment : assignments) {
                    System.out.print(assignment);
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}