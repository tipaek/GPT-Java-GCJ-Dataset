import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= test; ++t) {
            int n = in.nextInt();
            int[][] arr = new int[n][n];
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                   arr[i][j] = in.nextInt(); 
                }
            }
            int countRows = 0;
            int countColumns = 0;
            int trace = 0;
            //computing trace
            for (int i=0; i<n; i++){
                trace += arr[i][i];
            }
            boolean[] used = new boolean[n];
            //counting rows
            for (int i =0; i<n; i++){
                for (int j=0; j<n; j++){
                    used[j] = false;
                }
                for (int j=0; j<n; j++){
                    if (used[arr[i][j]-1]){
                        countRows++;
                        break;
                    }
                    else{
                        used[arr[i][j]-1] = true;
                    }
                }
            }
            //counting rows
            for (int j =0; j<n; j++){
                for (int i=0; i<n; i++){
                    used[i] = false;
                }
                for (int i=0; i<n; i++){
                    if (used[arr[i][j]-1]){
                        countColumns++;
                        break;
                    }
                    else{
                        used[arr[i][j]-1] = true;
                    }
                }
            }
            System.out.println("Case #" + t + ": " + (trace) + " " + (countRows) + " " +(countColumns));
        }
    }
}