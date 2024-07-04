import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            int maxIntersections = n * (n - 1) / 2;
            int[][] intersections = new int[maxIntersections][2];
            int[][] intersectionRanges = new int[maxIntersections][2];
            int intersectionCount = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int maxStart = Math.max(startTimes[i], startTimes[j]);
                    int minEnd = Math.min(endTimes[i], endTimes[j]);
                    if (minEnd - maxStart > 0) {
                        intersections[intersectionCount][0] = i;
                        intersections[intersectionCount][1] = j;
                        intersectionRanges[intersectionCount][0] = maxStart + 1;
                        intersectionRanges[intersectionCount][1] = minEnd;
                        intersectionCount++;
                    }
                }
            }

            int[] timeSlots = new int[1441];
            boolean possible = true;

            for (int i = 0; i < intersectionCount && possible; i++) {
                for (int t = intersectionRanges[i][0]; t <= intersectionRanges[i][1] && possible; t++) {
                    timeSlots[t]++;
                    if (timeSlots[t] == 2) {
                        possible = false;
                    }
                }
            }

            if (!possible) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", testCase);
            } else {
                char[] assignments = new char[n];
                assignments[0] = 'J';

                for (int i = 0; i < intersectionCount; i++) {
                    if (assignments[intersections[i][0]] == 'J') {
                        assignments[intersections[i][1]] = 'C';
                    } else if (assignments[intersections[i][0]] == 'C') {
                        assignments[intersections[i][1]] = 'J';
                    }
                }

                System.out.printf("Case #%d: ", testCase);
                for (int i = 0; i < n; i++) {
                    if (assignments[i] != 'C' && assignments[i] != 'J') {
                        assignments[i] = 'J';
                    }
                    System.out.print(assignments[i]);
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}