import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    static Scanner scan = new Scanner(System.in);
    public static void main(String args[]) throws IOException {
        int t = scan.nextInt();
        for(int tc = 1;tc<=t;++tc) {
            int n = scan.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0;
            for(int i=0;i<n;++i) {
                for(int j=0;j<n;++j) {
                    arr[i][j] = scan.nextInt();
                    trace += (i==j ? arr[i][j] : 0);
                }
            }
            int rr = 0;
            int cr = 0;
            for(int i=0;i<n;++i) {
                rr += (doesRepeat(i, arr, n, false) ? 1 : 0);
                cr += (doesRepeat(i, arr, n, true) ? 1 : 0);
            }
            
            System.out.println(String.format("Case #%d: %d %d %d", tc, trace, rr, cr));
        }
        
    }
    
    private static boolean doesRepeat(int ind, int[][] arr, int n, boolean column) {
        Set<Integer> hs = new HashSet<>();
        for(int i=0;i<n;++i) {
            int val = column ? arr[i][ind] : arr[ind][i];
            if(hs.contains(val)) return true;
            else hs.add(val);
        }
        return false;
    }
}