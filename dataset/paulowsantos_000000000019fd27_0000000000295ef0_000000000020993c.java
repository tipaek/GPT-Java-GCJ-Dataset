import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int calcTrace(int[][] arr, int len) {
        int result = 0;
        
        for (int i = 0; i < len; i++){
            result += arr[i][i];
        }
        
        return result;
    }
    
    static int calcRows(int[][] arr, int len) {
        int result = 0;
        
        for (int i = 0; i < len; i++){
            
            HashSet<Integer> h = new HashSet<Integer>();
            boolean isRepeated = false;
            
            for (int j = 0; j < len; j++){
                if (h.contains(arr[i][j])) {
                    isRepeated = true;
                } else {
                    h.add(arr[i][j]);
                }
            }
            if (isRepeated){
                result++;
            }
        }
        
        return result;
    }
    
    static int calcCols(int[][] arr, int len) {
        int result = 0;
        
        for (int i = 0; i < len; i++){
            
            HashSet<Integer> h = new HashSet<Integer>();
            boolean isRepeated = false;
            
            for (int j = 0; j < len; j++){
                if (h.contains(arr[j][i])) {
                    isRepeated = true;
                } else {
                    h.add(arr[j][i]);
                }
            }
            if (isRepeated){
                result++;
            }
        }
        
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
        
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            int[][] arr = new int[n][n];
            
            for (int k = 0; k < n; k++){
                String[] arrItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                
                for (int j = 0; j < n; j++) {
                    int arrItem = Integer.parseInt(arrItems[j]);
                    arr[k][j] = arrItem;
                }
                
            }

            int trace = calcTrace(arr, n);
            int rows = calcRows(arr, n);
            int cols = calcCols(arr, n);

            System.out.println(
                "Case #" +
                String.valueOf(i + 1) +
                ": " +
                String.valueOf(trace) +
                " " +
                String.valueOf(rows) +
                " " +
                String.valueOf(cols)
            );
            
        }

        scanner.close();
    }
}