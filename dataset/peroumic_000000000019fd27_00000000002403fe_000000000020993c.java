import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int q = 0; q < t; q++) {
            int n = in.nextInt();
            int[][]arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                arr[i] = new int[n];
                for (int j = 0; j < n; j++) {
                    arr[i][j] = in.nextInt();
                }
            }
            Result result = getResult(arr);
            System.out.println("Case #"+(q+1)+": "+result.k +" "+result.r +" "+result.c);
        }
    }

    private static Result getResult(int[][] arr) {
        Result r = new Result();
        for (int i = 0; i < arr.length; i++) {
            r.k += arr[i][i];
            Set<Integer> c = new HashSet<>();
            Set<Integer> rows = new HashSet<>();
            for (int j = 0; j < arr.length; j++) {
                c.add(arr[j][i]);
                rows.add(arr[i][j]);
            }
            if(c.size() != arr.length){
                r.c++;
            }
            if(rows.size() != arr.length){
                r.r++;
            }
        }
        return r;
    }

    static class Result{
        public int k;//trace
        public int r;//repeat R
        public int c;//repeat c
    }
}
