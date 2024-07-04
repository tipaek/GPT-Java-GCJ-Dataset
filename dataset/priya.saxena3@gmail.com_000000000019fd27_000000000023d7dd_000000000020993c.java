import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] arr = createArr(n,in);
            solve(arr,n,i);
        }
    }

    private static void solve(int[][] arr, int n ,int caseNo) {
        int[] temp = new int[n];
        int trace = 0 ; int rowSum = 0 ; int colSum = 0 ;
        int sum =( n * (n+1)) / 2;
        for (int i = 0 ; i < n ; i++){
            int s = 0 ;
            for (int j = 0 ; j < n ; j++){
                if(i == j)
                    trace += arr[i][j];
                temp[j] += arr[i][j];
                s += arr[i][j];
            }
            if(s != sum)
                rowSum++;
        }
        for(int i = 0 ; i < n ; i++){
            if(temp[i] != sum)
                colSum++;
        }
        System.out.println("Case #" + caseNo + ": " + trace + " " + rowSum + " " + colSum);
    }

    private static int[][] createArr(int n, Scanner in) {
        int arr[][] = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = in.nextInt();
        return arr;
    }
}