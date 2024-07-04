
import java.util.*;
import java.io.*;
public class Solution {


    public static void solve(int t, int arr[][]){
         int diag = 0;
         List<Set<Integer>> seenCol = new ArrayList<>();
         List<Set<Integer>> seenRow = new ArrayList<>();
         Set<Integer> dupCol = new HashSet<>();
         Set<Integer> dupRow = new HashSet<>();
         for (int i = 0; i < arr.length; i++){
             seenCol.add(new HashSet<>());
             seenRow.add(new HashSet<>());

         }
         for (int i = 0; i < arr.length; i++){
             diag += arr[i][i];
             for (int j = 0; j < arr.length; j++){
                 if (seenCol.get(i).contains(arr[i][j])){
                     dupCol.add(i);
                 }
                 seenCol.get(i).add(arr[i][j]);
                 if (seenRow.get(j).contains(arr[i][j]) ){
                     dupRow.add(j);
                 }
                 seenRow.get(j).add(arr[i][j]);
             }
         }


        System.out.println("Case #" + t + ": " + diag + " " + dupCol.size() + " " + dupRow.size());

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int arr[][] = new int[n][n];
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++){
                    arr[j][k] = in.nextInt();
                }
            }
            solve(t, arr);

        }
    }
}




