import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int m = 1; m <= t; m++) {
            int n = sc.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            int[] indices = new int[n];
            char[] result = new char[n];
            Arrays.fill(result, '0');
            
            for (int j = 0; j < n; j++) {
                start[j] = sc.nextInt();
                end[j] = sc.nextInt();
                indices[j] = j;
            }
            
            // Sort the intervals by start time using bubble sort
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - 1 - i; j++) {
                    if (start[j] > start[j + 1]) {
                        swap(start, j, j + 1);
                        swap(end, j, j + 1);
                        swap(indices, j, j + 1);
                    }
                }
            }
            
            char[] assignments = new char[n];
            int cEnd = end[0];
            int jEnd = end[1];
            assignments[0] = 'C';
            assignments[1] = 'J';
            
            boolean possible = true;
            for (int k = 2; k < n; k++) {
                if (cEnd <= start[k]) {
                    cEnd = end[k];
                    assignments[k] = 'C';
                } else if (jEnd <= start[k]) {
                    jEnd = end[k];
                    assignments[k] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                for (int i = 0; i < n; i++) {
                    result[indices[i]] = assignments[i];
                }
                System.out.println("Case #" + m + ": " + new String(result));
            } else {
                System.out.println("Case #" + m + ": IMPOSSIBLE");
            }
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}