import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        
        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            int numIntervals = scanner.nextInt();
            int[][] intervals = new int[numIntervals][2];
            int[] originalIndices = new int[numIntervals];
            
            for (int i = 0; i < numIntervals; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                originalIndices[i] = i;
            }
            
            // Sort intervals by start time using bubble sort
            boolean sorted;
            int length = numIntervals;
            do {
                sorted = true;
                for (int i = 0; i < length - 1; i++) {
                    if (intervals[i][0] > intervals[i + 1][0]) {
                        // Swap intervals
                        int[] tempInterval = intervals[i];
                        intervals[i] = intervals[i + 1];
                        intervals[i + 1] = tempInterval;
                        
                        // Swap original indices
                        int tempIndex = originalIndices[i];
                        originalIndices[i] = originalIndices[i + 1];
                        originalIndices[i + 1] = tempIndex;
                        
                        sorted = false;
                    }
                }
                length--;
            } while (!sorted && length > 1);
            
            boolean isImpossible = false;
            int endC = 0, endJ = 0; // End times for C and J
            char[] result = new char[numIntervals];
            
            for (int i = 0; i < numIntervals; i++) {
                if (intervals[i][0] >= endC) {
                    endC = intervals[i][1];
                    result[originalIndices[i]] = 'C';
                } else if (intervals[i][0] >= endJ) {
                    endJ = intervals[i][1];
                    result[originalIndices[i]] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + (caseIndex + 1) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (caseIndex + 1) + ": ");
                for (char c : result) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
    }
}