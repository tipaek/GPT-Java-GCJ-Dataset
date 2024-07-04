import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            
            if (n == 2) {
                System.out.println("Case #" + (i + 1) + ": CJ");
            } else {
                int[][] time = new int[n][3];
                for (int j = 0; j < n; j++) {
                    time[j][0] = scan.nextInt();
                    time[j][1] = scan.nextInt();
                    time[j][2] = j + 1;
                }
                solve(time, n, i + 1);
            }
        }
    }
    
    private static void sortbyColumn(int[][] arr, int col) {
        Arrays.sort(arr, Comparator.comparingInt(entry -> entry[col]));
    }
    
    private static void solve(int[][] time, int n, int caseNumber) {
        int cEnd = 0;
        int jEnd = 0;
        
        sortbyColumn(time, 0);
        
        cEnd = time[0][1];
        StringBuilder result = new StringBuilder("C");
        
        for (int i = 1; i < n; i++) {
            if (time[i][0] >= cEnd) {
                result.append("C");
                cEnd = time[i][1];
            } else if (time[i][0] >= jEnd) {
                result.append("J");
                jEnd = time[i][1];
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            }
        }
        
        System.out.println("Case #" + caseNumber + ": " + result);
    }
}