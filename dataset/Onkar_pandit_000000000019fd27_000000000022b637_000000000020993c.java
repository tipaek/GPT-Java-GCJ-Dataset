import java.util.*;

public class Solution {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int h=1;h<=t;h++) {
            int n = sc.nextInt();
            int [][] arr = new int[n][n];
            for (int i =0;i<n;i++) {
                for (int j =0;j<n;j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int trace = getTrace(arr, n);
            int rows = getRepeatedRows(arr, n);
            int cols = getRepeatedCols(arr, n);
            System.out.println("Case #"+h+": "+trace+" "+rows+" "+cols);
        }
    }
    
    public static int getTrace(int [][] arr, int n) {
        int sum =0;
        for (int i=0;i<n;i++) {
            sum+=arr[i][i];
        }
        return sum;
    }
    
    public static int getRepeatedRows(int [][] arr, int n) {
        int count =0;
        for (int i =0;i<n;i++) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int j=0;j<n;j++) {
                if (set.contains(arr[i][j])) {
                    count++;
                    break;
                }
                set.add(arr[i][j]);
            }
        }
        return count;
    }
    
    public static int getRepeatedCols(int [][] arr, int n) {
        int count =0;
        for (int i =0;i<n;i++) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int j=0;j<n;j++) {
                if (set.contains(arr[j][i])) {
                    count++;
                    break;
                }
                set.add(arr[j][i]);
            }
        }
        return count;
    }
}