import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            int[] order = new int[24 * 60 + 1];
            boolean possible = true;
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                order[intervals[i][0]] = i;
            }
            
            if (possible) {
                char[] assignments = new char[n];
                for (int i = 0; i < n; i++) {
                    assignments[i] = ' ';
                }
                
                sortIntervals(intervals, 0, n - 1);
                
                int cameronEnd = intervals[0][1];
                int jamieEnd = -1;
                assignments[order[intervals[0][0]]] = 'C';
                
                for (int i = 1; i < n; i++) {
                    if (intervals[i][0] >= cameronEnd) {
                        cameronEnd = -1;
                    }
                    if (intervals[i][0] >= jamieEnd) {
                        jamieEnd = -1;
                    }
                    
                    if (cameronEnd == -1) {
                        cameronEnd = intervals[i][1];
                        assignments[order[intervals[i][0]]] = 'C';
                    } else if (jamieEnd == -1) {
                        jamieEnd = intervals[i][1];
                        assignments[order[intervals[i][0]]] = 'J';
                    } else {
                        System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
                        possible = false;
                        break;
                    }
                }
                
                if (possible) {
                    StringBuilder result = new StringBuilder();
                    for (char assignment : assignments) {
                        result.append(assignment);
                    }
                    System.out.println("Case #" + (t + 1) + ": " + result.toString());
                }
            }
        }
        
        scanner.close();
    }
    
    private static void mergeIntervals(int[][] intervals, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        
        int[][] leftArray = new int[n1][2];
        int[][] rightArray = new int[n2][2];
        
        for (int i = 0; i < n1; i++) {
            leftArray[i][0] = intervals[left + i][0];
            leftArray[i][1] = intervals[left + i][1];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j][0] = intervals[middle + 1 + j][0];
            rightArray[j][1] = intervals[middle + 1 + j][1];
        }
        
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i][0] <= rightArray[j][0]) {
                intervals[k][0] = leftArray[i][0];
                intervals[k][1] = leftArray[i][1];
                i++;
            } else {
                intervals[k][0] = rightArray[j][0];
                intervals[k][1] = rightArray[j][1];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            intervals[k][0] = leftArray[i][0];
            intervals[k][1] = leftArray[i][1];
            i++;
            k++;
        }
        
        while (j < n2) {
            intervals[k][0] = rightArray[j][0];
            intervals[k][1] = rightArray[j][1];
            j++;
            k++;
        }
    }
    
    private static void sortIntervals(int[][] intervals, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sortIntervals(intervals, left, middle);
            sortIntervals(intervals, middle + 1, right);
            mergeIntervals(intervals, left, middle, right);
        }
    }
}