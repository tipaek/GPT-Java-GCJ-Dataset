import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int activityCount = scanner.nextInt();
            int[] startTimes = new int[activityCount];
            int[] endTimes = new int[activityCount];

            for (int i = 0; i < activityCount; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            int maxIntersections = activityCount * (activityCount - 1) / 2;
            int[][] intersections = new int[maxIntersections][2];
            int[][] intersectionRanges = new int[maxIntersections][2];

            int intersectionCounter = 0;

            for (int i = 0; i < activityCount; i++) {
                for (int j = i + 1; j < activityCount; j++) {
                    int maxStart = Math.max(startTimes[i], startTimes[j]);
                    int minEnd = Math.min(endTimes[i], endTimes[j]);

                    if (minEnd > maxStart) {
                        intersections[intersectionCounter][0] = i;
                        intersections[intersectionCounter][1] = j;
                        intersectionRanges[intersectionCounter][0] = maxStart + 1;
                        intersectionRanges[intersectionCounter][1] = minEnd;
                        intersectionCounter++;
                    }
                }
            }

            int[] timeSlots = new int[1441];
            boolean isPossible = true;

            for (int i = 0; i < intersectionCounter && isPossible; i++) {
                for (int t = intersectionRanges[i][0]; t <= intersectionRanges[i][1] && isPossible; t++) {
                    timeSlots[t]++;
                    if (timeSlots[t] > 1) {
                        isPossible = false;
                    }
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
            } else {
                char[] assignments = new char[activityCount];
                assignments[0] = 'J';

                for (int i = 0; i < intersectionCounter; i++) {
                    if (assignments[intersections[i][0]] == 'J') {
                        assignments[intersections[i][1]] = 'C';
                    } else if (assignments[intersections[i][0]] == 'C') {
                        assignments[intersections[i][1]] = 'J';
                    }
                }

                System.out.print("Case #" + (testCase + 1) + ": ");
                for (int i = 0; i < activityCount; i++) {
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