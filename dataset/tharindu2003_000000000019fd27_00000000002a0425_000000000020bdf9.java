import java.io.*;
import java.util.*;

public class Solution {

    public String solve(int[][] times){
        java.util.Arrays.sort(times, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (a[0] == b[0])? Integer.compare(a[1], b[1]): Integer.compare(a[0],b[0]);
            }
        });
        String schedule = "";
        int cBusyUntil = -1;
        int jBusyUntil = -1;
        for (int[] time : times){
            if(cBusyUntil<=time[0]){
                schedule+="C";
                cBusyUntil = time[1];
            }
            else if(jBusyUntil<=time[0]){
                schedule+="J";
                jBusyUntil = time[1];
            }
            else{
                return "IMPOSSIBLE";
            }
        }
        return schedule;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution app = new Solution();
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][2];
            for(int j=0; j<n; j++){
                for( int k=0; k<2; k++){
                    matrix[j][k] = in.nextInt();
                }
            }
            app.solve(matrix);
            String solved = app.solve(matrix);
            System.out.println("Case #" + i + ": " + solved);
        }
    }
}
