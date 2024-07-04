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
        Map<Integer,Set<Integer>> colCountMap = new HashMap<>();
        int trace = 0 ;
        Set<Integer> col = new HashSet<>();
        Set<Integer> row = new HashSet<>();
        for (int i = 0 ; i < n ; i++){
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0 ; j < n ; j++){
                int t = arr[i][j];
                if(i == j)
                    trace += t;
                if (!rowSet.add(t))
                    row.add(i);
                Set<Integer> colSet = colCountMap.containsKey(j) ? colCountMap.get(j) : new HashSet<>();
                if(!colSet.add(t))
                    col.add(j);
                else
                    colCountMap.put(j,colSet);
            }
        }
        System.out.println("Case #" + caseNo + ": " + trace + " " + row.size() + " " + col.size());
    }

    private static int[][] createArr(int n, Scanner in) {
        int arr[][] = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = in.nextInt();
        return arr;
    }
}