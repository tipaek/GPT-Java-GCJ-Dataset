import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for(int i = 0 ; i < t; i++){
            int n = Integer.parseInt(in.nextLine());
            int[][] mat = getMat(in, n);
            int trace = getTrace(mat);
            int[] rows = new int[n];
            int[] cols = new int[n];
            for(int j = 0; j < n; j++){
                for(int k =0; k< n; k++){
                    rows[j] += mat[j][k];
                    cols[k] += mat[j][k];
                }
            }
            int sum = getSum(n);
            System.out.println("Case #" + i + ": " + trace + " "+ getDup(rows,sum) +" " + getDup(cols, sum));
        }
    }

    public static int getDup(int[] arr, int sum){
        int res = 0;
        for(int i = 0; i <arr.length; i++){
            res += arr[i] == sum ? 0 : 1;
        }
        return res;
    }

    public static int getSum(int n){
        return n*(n+1)/2;
    }

    public static int getTrace(int[][] mat){
        int res = 0;
        for(int i = 0; i <mat.length ; i++){
            res += mat[i][i];
        }
        return res;
    }

    public static int[][] getMat(Scanner in, int n){
        int[][] mat = new int[n][n];
        for(int i =0 ; i<n; i++){
            String[] s = in.nextLine().split(" ");
            for(int j = 0; j <n; j++){
                mat[i][j] = Integer.parseInt(s[j]);
            }
        }
        return mat;
    }

}


    