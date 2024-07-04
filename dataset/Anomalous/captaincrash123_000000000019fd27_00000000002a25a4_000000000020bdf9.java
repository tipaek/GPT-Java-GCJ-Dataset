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
            
            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            
            int possiblePairs = n * (n - 1) / 2;
            int[][] intersections = new int[possiblePairs][2];
            int[][] intersectionRanges = new int[possiblePairs][2];
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
            boolean isPossible = true;
            
            for (int i = 0; i < intersectionCount && isPossible; i++) {
                for (int j = intersectionRanges[i][0]; j <= intersectionRanges[i][1] && isPossible; j++) {
                    timeSlots[j]++;
                    if (timeSlots[j] == 2) {
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
                
                for (int i = 0; i < intersectionCount; i++) {
                    if (assignments[intersections[i][0]] == 'J') {
                        assignments[intersections[i][1]] = 'C';
                    } else if (assignments[intersections[i][0]] == 'C') {
                        assignments[intersections[i][1]] = 'J';
                    }
                }
                
                System.out.print("Case #" + (testCase + 1) + ": ");
                for (int i = 0; i < n; i++) {
                    if (assignments[i] == ' ') {
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