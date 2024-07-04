import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 0; testCase < testCases; testCase++) {
            int numIntervals = scanner.nextInt();
            int[] startTimes = new int[numIntervals];
            int[] endTimes = new int[numIntervals];
            
            for (int i = 0; i < numIntervals; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            
            int maxIntersections = (numIntervals * (numIntervals - 1)) / 2;
            maxIntersections = maxIntersections == 0 ? 1 : maxIntersections;
            int[][] intersections = new int[maxIntersections][2];
            int[][] intersectionRanges = new int[maxIntersections][2];
            
            int intersectionCount = 0;
            
            for (int i = 0; i < numIntervals; i++) {
                for (int j = i + 1; j < numIntervals; j++) {
                    int overlapStart = Math.max(startTimes[i], startTimes[j]) + 1;
                    int overlapEnd = Math.min(endTimes[i], endTimes[j]);
                    
                    if (overlapEnd - overlapStart >= 0) {
                        intersections[intersectionCount][0] = i;
                        intersections[intersectionCount][1] = j;
                        intersectionRanges[intersectionCount][0] = overlapStart;
                        intersectionRanges[intersectionCount][1] = overlapEnd;
                        intersectionCount++;
                    }
                }
            }
            
            int[] timeSlots = new int[1441];
            boolean isPossible = true;
            
            for (int i = 0; i < intersectionCount && isPossible; i++) {
                for (int t = intersectionRanges[i][0]; t <= intersectionRanges[i][1] && isPossible; t++) {
                    timeSlots[t]++;
                    if (timeSlots[t] == 2) {
                        isPossible = false;
                    }
                }
            }
            
            if (!isPossible) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", testCase + 1);
            } else {
                char[] assignments = new char[numIntervals];
                Arrays.fill(assignments, 'U'); // 'U' for unassigned
                
                assignments[0] = 'J';
                
                for (int i = 0; i < intersectionCount; i++) {
                    int first = intersections[i][0];
                    int second = intersections[i][1];
                    
                    if (assignments[first] == 'J') {
                        assignments[second] = 'C';
                    } else if (assignments[first] == 'C') {
                        assignments[second] = 'J';
                    }
                }
                
                System.out.printf("Case #%d: ", testCase + 1);
                for (int i = 0; i < numIntervals; i++) {
                    if (assignments[i] == 'U') {
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