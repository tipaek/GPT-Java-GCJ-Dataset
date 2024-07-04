import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int activitiesCount = scanner.nextInt();
            int[] startTimes = new int[activitiesCount];
            int[] endTimes = new int[activitiesCount];
            
            for (int activityIndex = 0; activityIndex < activitiesCount; activityIndex++) {
                startTimes[activityIndex] = scanner.nextInt();
                endTimes[activityIndex] = scanner.nextInt();
            }
            
            int maxIntersections = (activitiesCount * (activitiesCount - 1)) / 2;
            int[][] intersectingPairs = new int[maxIntersections][2];
            int[][] intersectingRanges = new int[maxIntersections][2];
            int intersectionCount = 0;

            for (int i = 0; i < activitiesCount; i++) {
                for (int j = i + 1; j < activitiesCount; j++) {
                    int intersectionStart = Math.max(startTimes[i], startTimes[j]);
                    int intersectionEnd = Math.min(endTimes[i], endTimes[j]);
                    if (intersectionEnd > intersectionStart) {
                        intersectingPairs[intersectionCount][0] = i;
                        intersectingPairs[intersectionCount][1] = j;
                        intersectingRanges[intersectionCount][0] = intersectionStart;
                        intersectingRanges[intersectionCount][1] = intersectionEnd;
                        intersectionCount++;
                    }
                }
            }

            int[] timeSlots = new int[1441];
            boolean isPossible = true;

            for (int i = 0; i < intersectionCount && isPossible; i++) {
                for (int time = intersectingRanges[i][0]; time <= intersectingRanges[i][1] && isPossible; time++) {
                    timeSlots[time]++;
                    if (timeSlots[time] == 2) {
                        boolean isSafe = false;
                        for (int j = 0; j < activitiesCount && !isSafe; j++) {
                            if (time == startTimes[j]) {
                                isSafe = true;
                            }
                        }
                        if (!isSafe) {
                            isPossible = false;
                        }
                    }
                }
            }

            if (!isPossible) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", caseIndex + 1);
            } else {
                char[] assignments = new char[activitiesCount];
                assignments[0] = 'J';
                
                for (int i = 0; i < intersectionCount; i++) {
                    if (assignments[intersectingPairs[i][0]] == 'J') {
                        assignments[intersectingPairs[i][1]] = 'C';
                    } else if (assignments[intersectingPairs[i][0]] == 'C') {
                        assignments[intersectingPairs[i][1]] = 'J';
                    }
                }

                System.out.printf("Case #%d: ", caseIndex + 1);
                for (int i = 0; i < activitiesCount; i++) {
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