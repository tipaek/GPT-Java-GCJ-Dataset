import java.io.*;
import java.util.*;
class Solution {

    public static void main(String args[]) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int[][] arr = new int[n][n];
            int numRows = 0;
            int numCols = 0;
            for (int j = 0; j < n; j++) {
                HashSet<Integer> h = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    int v = scan.nextInt();
                    h.add(v);
                    arr[j][k] = v;
                }
                if (h.size() < n) {
                    numRows++;
                }
            }
            for (int j = 0; j < arr.length; j++) {
                HashSet<Integer> h = new HashSet<>();
                for (int k = 0; k < arr.length; k++) {
                    h.add(arr[k][j]);
                }
                if(h.size()<n){
                numCols++;
                }
            }
            int traceSum = 0;
            for (int j = 0; j < arr.length; j++) {
                traceSum += arr[j][j];
            }
            System.out.println("Case #" + (i + 1) + ": " + traceSum + " " + numRows + " " + numCols);
        }
    }

}