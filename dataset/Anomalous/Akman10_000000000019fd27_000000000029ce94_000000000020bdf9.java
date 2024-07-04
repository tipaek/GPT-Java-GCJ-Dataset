import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases
        
        for (int ii = 1; ii <= t; ++ii) {
            int n = in.nextInt(); // Number of intervals
            boolean isImpossible = false;
            int[] arr = new int[100000];
            int[] start = new int[n];
            int[] end = new int[n];
            
            for (int j = 0; j < n; j++) {
                start[j] = in.nextInt();
                end[j] = in.nextInt();
                
                for (int k = start[j]; k < end[j]; k++) {
                    arr[k]++;
                    if (arr[k] > 2) {
                        isImpossible = true;
                    }
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + ii + ": IMPOSSIBLE");
            } else {
                int[] assignment = new int[n];
                assignment[0] = 0;
                
                for (int i = 1; i < n; i++) {
                    for (int j = i - 1; j >= 0; j--) {
                        if ((start[i] <= start[j] && end[i] > start[j]) ||
                            (start[i] < end[j] && end[i] >= end[j]) ||
                            (start[i] >= start[j] && end[i] <= end[j])) {
                            assignment[i] = 1 - assignment[j];
                            break;
                        }
                    }
                }
                
                System.out.print("Case #" + ii + ": ");
                for (int i = 0; i < assignment.length; i++) {
                    System.out.print(assignment[i] == 1 ? 'C' : 'J');
                }
                System.out.println();
            }
        }
    }
}