import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalTests = scan.nextInt();
        for(int test = 0; test<totalTests; test++){
            int n = scan.nextInt();
            int trace = 0, r = 0, c = 0;
            int[][] arr = new int[n][n];
            boolean[] boolRow = new boolean[n];
            boolean[] boolColumn = new boolean[n];
            
            // take input
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    arr[i][j] = scan.nextInt();
                    if(i == j) trace += arr[i][j];
                }
            }
            
            for(int i=0; i<n; i++) {
                resetBoolArr(boolRow, n);
                resetBoolArr(boolColumn, n);
                for(int j=0; j<n; j++) {
                    if(boolRow[arr[i][j]-1] == true) {
                        r++;
                        break;
                    }
                    boolRow[arr[i][j]-1] = true;
                }
                
                for(int j=0; j<n; j++) {
                    if(boolColumn[arr[j][i]-1] == true) {
                        c++;
                        break;
                    }
                    boolColumn[arr[j][i]-1] = true;
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", test+1, trace, r, c);
            
        }
    }
    
    private static void resetBoolArr(boolean[] arr, int n) {
        for(int i=0; i<n; i++) arr[i] = false;
    }
    
}