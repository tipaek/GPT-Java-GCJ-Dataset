
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i1 = 1; i1 <= t; ++i1) {
            int n = in.nextInt();
            int[][] arr = new int[n][n];
            int k=0,r=0,c=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j]=in.nextInt();
                }
            }
            

            for (int i = 0; i < n; i++) {
                Set<Integer> setR = new HashSet<>();
                Set<Integer> setC = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    setR.add(arr[i][j]);
                    setC.add(arr[j][i]);
                }
                if(setR.size()!=n)r++;
                if(setC.size()!=n)c++;
                k+=arr[i][i];
            }
            System.out.println("Case #" + i1 + ": " + (k) + " " + (r) + " " + c);
        }
    }
}