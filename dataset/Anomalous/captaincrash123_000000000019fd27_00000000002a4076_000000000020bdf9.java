import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
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
                        intersectionRanges[intersectionCount][0] = maxStart;
                        intersectionRanges[intersectionCount][1] = minEnd;
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
                        boolean validStart = false;
                        boolean validEnd = false;
                        for (int j = 0; j < n; j++) {
                            if (t == startTimes[j]) validStart = true;
                            if (t == endTimes[j]) validEnd = true;
                        }
                        if (!validStart || !validEnd) isPossible = false;
                    } else if (timeSlots[t] > 2) {
                        isPossible = false;
                    }
                }
            }
            
            System.out.print("Case #" + (t + 1) + ": ");
            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                char[] assignments = new char[n];
                Arrays.fill(assignments, 'J');
                
                for (int i = 0; i < intersectionCount; i++) {
                    if (assignments[intersections[i][0]] == 'J') {
                        assignments[intersections[i][1]] = 'C';
                    } else {
                        assignments[intersections[i][1]] = 'J';
                    }
                }
                
                for (char assignment : assignments) {
                    System.out.print(assignment);
                }
                System.out.println();
            }
        }
        
        scanner.close();
    }
}