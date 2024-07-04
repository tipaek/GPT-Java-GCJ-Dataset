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
            int rowsDup = 0;
            int colsDup = 0;
            for(int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    rows[mat[j][k]-1] += 1;
                    cols[mat[k][j]-1] += 1;
                }
                rowsDup += getDup(rows);
                colsDup += getDup(cols);
                rows = new int[n];
                cols = new int[n];
            }
            System.out.println("Case #" + (i+1) + ": " + trace + " "+ rowsDup +" " + colsDup);
        }
    }

    public static int getDup(int[] arr){
        for(int i = 0; i <arr.length; i++){
            if(arr[i] != 1){
                return 1;
            }
        }
        return 0;
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


    