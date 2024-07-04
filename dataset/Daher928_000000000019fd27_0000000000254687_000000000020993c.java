import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class Solution {

    static void vestigium(int[][] a, int N) {
        if (N<=0 || a.length==0 || a[0].length==0)
            return;
        
        int trace = calculateTrace(a, N);
        int r=0, c=0;
        
        HashSet<Integer> set = new HashSet<>();
        
        //Calculate r
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (set.contains(a[i][j])){
                    r++;
                    break;
                } else {
                    set.add(a[i][j]);
                }
            }
            
            set.clear();
        }
        
        //Calculate c
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (set.contains(a[j][i])){
                    c++;
                    break;
                } else {
                    set.add(a[j][i]);
                }
            }
            set.clear();
        }
        
        System.out.println(trace + " " + r + " " + c);
    }
    
    static int calculateTrace(int[][] a, int N){
        int sum=0;
        for (int i=0; i<N; i++){
            sum += a[i][i];
        }
        
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] arr = new int[n][n];
    
            for (int i = 0; i < n; i++) {
                String[] arrRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    
                for (int j = 0; j < n; j++) {
                    int arrItem = Integer.parseInt(arrRowItems[j]);
                    arr[i][j] = arrItem;
                }
            }
            int caseNum = tItr+1;
            System.out.print("Case #"+ caseNum + ": ");
            vestigium(arr, n);
        }

        scanner.close();
    }
}
