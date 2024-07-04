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
                    time[j][2] = j;
                }
                solve(time, n, i + 1);
            }
        }
    }
    
    private static void sortbyColumn(int[][] arr, int col) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(final int[] entry1, final int[] entry2) {
                return Integer.compare(entry1[col], entry2[col]);
            }
        });
    }
    
    private static void solve(int[][] time, int n, int t) {
        int c_end = 0, j_end = 0;
        sortbyColumn(time, 0);
        
        c_end = time[0][1];
        StringBuilder s = new StringBuilder("C");
        
        for (int i = 1; i < n; i++) {
            if (time[i][0] >= c_end) {
                s.append("C");
                c_end = time[i][1];
            } else if (time[i][0] >= j_end) {
                s.append("J");
                j_end = time[i][1];
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
                return;
            }
        }
        
        System.out.print("Case #" + t + ": ");
        System.out.println(s.toString());
    }
}