import java.io.*;
import java.util.*;

public class Solution {

    public String solve(int[][] times){
        int[][] original = times.clone();
        java.util.Arrays.sort(times, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (a[0] == b[0])? Integer.compare(a[1], b[1]): Integer.compare(a[0],b[0]);
            }
        });
        String schedule = "";
        ArrayList<int[]> jTimes = new ArrayList<>();
        ArrayList<int[]> cTimes = new ArrayList<>();
        int cBusyUntil = -1;
        int jBusyUntil = -1;
        for (int[] time : times){
            if(cBusyUntil<=time[0]){
                cBusyUntil = time[1];
                cTimes.add(time);
            }
            else if(jBusyUntil<=time[0]){
                jBusyUntil = time[1];
                jTimes.add(time);
            }
            else{
                return "IMPOSSIBLE";
            }
        }
        for(int[] time: original){
            int cIndex = cTimes.indexOf(time);
            int jIndex = jTimes.indexOf(time);
            if(cIndex>-1){
                schedule+="C";
                cTimes.remove(cIndex);
            }
            else if(jIndex>-1){
                schedule+="J";
                jTimes.remove(jIndex);
            }
            else{
                System.out.println("Uh Oh");
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
            String solved = app.solve(matrix);
            System.out.println("Case #" + i + ": " + solved);
        }
    }


}