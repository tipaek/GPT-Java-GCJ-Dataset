import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            
            for (int j = 0; j < n; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
            }
            
            int totalPairs = (n * (n - 1)) / 2;
            int[][] intersections = new int[totalPairs][2];
            int[][] intersectionRanges = new int[totalPairs][2];
            int intersectionCount = 0;
            
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (Math.min(endTimes[j], endTimes[k]) - Math.max(startTimes[j], startTimes[k]) > 0) {
                        intersections[intersectionCount][0] = j;
                        intersections[intersectionCount][1] = k;
                        intersectionRanges[intersectionCount][0] = Math.max(startTimes[j], startTimes[k]);
                        intersectionRanges[intersectionCount][1] = Math.min(endTimes[j], endTimes[k]) - 1;
                        intersectionCount++;
                    }
                }
            }
            
            int[] timeSlots = new int[1441];
            boolean isPossible = true;
            
            for (int j = 0; j < intersectionCount && isPossible; j++) {
                for (int k = intersectionRanges[j][0]; k <= intersectionRanges[j][1] && isPossible; k++) {
                    timeSlots[k]++;
                    if (timeSlots[k] == 2) {
                        isPossible = false;
                    }
                }
            }
            
            if (!isPossible) {
                System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
            } else {
                char[] assignments = new char[n];
                Arrays.fill(assignments, ' ');
                assignments[0] = 'J';
                
                for (int j = 0; j < intersectionCount; j++) {
                    if (assignments[intersections[j][0]] == 'J') {
                        assignments[intersections[j][1]] = 'C';
                    } else if (assignments[intersections[j][0]] == 'C') {
                        assignments[intersections[j][1]] = 'J';
                    }
                }
                
                System.out.print("Case #" + (testCase + 1) + ": ");
                for (int j = 0; j < n; j++) {
                    if (assignments[j] == ' ') {
                        assignments[j] = 'J';
                    }
                    System.out.print(assignments[j]);
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}