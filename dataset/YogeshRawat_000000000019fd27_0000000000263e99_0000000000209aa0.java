import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.valueOf(sc.nextLine().trim());
        for( int i =1; i <= testCases; i++) {
            String[] str = sc.nextLine().split(" ");
            int n = Integer.valueOf(str[0]);
            int k = Integer.valueOf(str[1]);
            int[][] mat = new int[n][n];
            constructMatrix(n, mat);
            int sum =0;
            int sum1=0;
            for( int j =0; j < n; j++ ) {
                sum += mat[j][j];
            }
            int l =0;
            for( int j =n-1; j >= 0; j-- ) {
                sum1 += mat[l][j];
                l++;
            }
/*
            for( int[] row : mat) {
                System.out.println(Arrays.toString(row));
            }*/
            if( sum == k || sum1 == k) {
                System.out.println("Case #" + i + ": "+ "POSSIBLE");
            }else {
                System.out.println("Case #" + i + ": "+ "IMPOSSIBLE");
            }
        }
    }
    static void fillRemaining(int i, int j, int n, int[][] mat) {
        int x = 2;
        for (int k = i + 1; k < n; k++)
            mat[k][j] = x++;
        for (int k = 0; k < i; k++)
            mat[k][j] = x++;
    }
    static void constructMatrix(int n, int[][] mat) {
        int right = n - 1, left = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                mat[i][right] = 1;
                fillRemaining(i, right, n, mat);
                right--;
            } else {
                mat[i][left] = 1;
                fillRemaining(i, left, n, mat);
                left++;
            }
        }
    }
}