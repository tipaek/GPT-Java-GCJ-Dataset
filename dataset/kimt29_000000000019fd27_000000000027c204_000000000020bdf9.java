import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[][] times = new int[n][2];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    times[j][k] = scanner.nextInt();
                }
            }
            
            String[] p = new String[n];
            int j = 0;
            int tmp = Integer.MAX_VALUE;
            int busy1 = Integer.MIN_VALUE;
            int busy2 = Integer.MIN_VALUE;
            String result = "";
            while (j < times.length) {
                int ind = findMinStart(times);
                if (busy1 < times[ind][0]) {
                    busy1 = times[ind][1];
                    p[ind] = "C";
                    times[ind][0] = Integer.MAX_VALUE;
                } else if (busy2 < times[ind][0]) {
                    busy2 = times[ind][1];
                    p[ind] = "J";
                    times[ind][0] = Integer.MAX_VALUE;
                } else {
                    result = "IMPOSSIBLE";
                    j = n;
                }
                j++;
                if (j < times.length) ind = findMinStart(times);
                if (j < times.length && times[ind][0] >= busy1) busy1 = Integer.MIN_VALUE;
                if (j < times.length && times[ind][0] >= busy2) busy2 = Integer.MIN_VALUE; 
            }
            
            if (!result.equals("IMPOSSIBLE")) {
                for (j = 0; j < p.length; j++) {
                    result += p[j];
                }
            }
            
            System.out.println("Case #" + i + ": " + result);
        }
    }
    
    //returns index of lowest start time
    public static int findMinStart(int[][] t) {
        int min = Integer.MAX_VALUE;
        int minInd = Integer.MAX_VALUE;
        for (int i = 0; i < t.length; i++) {
            if (t[i][0] < min) {
                min = t[i][0];
                minInd = i;
            }
        }
        return minInd;
    }
} 