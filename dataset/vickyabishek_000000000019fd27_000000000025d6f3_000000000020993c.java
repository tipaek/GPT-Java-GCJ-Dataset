import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int tc = 1; tc <= t; ++tc) {

            int n = in.nextInt();

            int[][] arr = new int[n][n];
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    arr[i][j] = in.nextInt();
                }
            }

            int trace = (getTrace(arr, n));
            int cRows = getCommonRows(arr, n);
            int cCols = getCommonCols(arr, n);

            System.out.println("Case #" + tc + ": " + (trace) + " " + (cRows) + " " + cCols);
        }
    }

    public static int getTrace( int[][] arr, int n ) {
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += arr[i][i];
        }
        return sum;
    }

    public static int getCommonRows( int[][] arr, int n) {
        int sum = 0;
        HashMap<Integer, Integer> hashy= new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                if( hashy.containsKey(arr[i][j]) ) {
                    ++sum;
                    break;
                } else {
                    hashy.put(arr[i][j],1);
                }
            }
            hashy = new HashMap<>();

        }
        return sum;
    }

    public static int getCommonCols( int[][] arr, int n) {
        int sum = 0;
        HashMap<Integer, Integer> hashy= new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                if( hashy.containsKey(arr[j][i]) ) {
                    ++sum;
                    break;
                } else {
                    hashy.put(arr[j][i],1);
                }
            }
            hashy = new HashMap<>();
        }
        return sum;
    }
}