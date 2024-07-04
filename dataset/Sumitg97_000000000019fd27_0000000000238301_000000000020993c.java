import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int  n = sc.nextInt();
            int i = 0,j = 0, trace = 0, row = 0, column = 0;
            int arr[][] = new int[n][n];
            for(i = 0; i < n ; i++) {
                for(j = 0; j < n ; j++) {
                    arr[i][j] = sc.nextInt();
                    if(i == j) {
                        trace = trace + arr[i][j];
                    }
                }
            }
            for(i = 0;i < n; i++) {
                HashSet<Integer> rowHashSet = new HashSet<Integer>();
                for(j = 0; j < n; j++) { 
                    if(rowHashSet.contains(arr[i][j])) {
                        row++;
                        break;
                    }
                    rowHashSet.add(arr[i][j]);    
                }
            }
            for(i = 0;i < n; i++) {
                HashSet<Integer> columnHashSet = new HashSet<Integer>();
                for(j = 0; j < n; j++) { 
                    if(columnHashSet.contains(arr[j][i])) {
                        column++;
                        break;
                    }
                    columnHashSet.add(arr[j][i]);    
                }
            }
            System.out.println(trace + " " + row + " " + column);
        }
   }
}
