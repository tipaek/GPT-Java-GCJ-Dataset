import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static class Pair {
        int a ;
        int b ;
        Pair(int a , int b) {
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int [][] a = pascal();
        for (int q =1 ;q<=t;q++) {
            long n = s.nextLong();
            boolean [][] dp = new boolean[a.length][];
            for (int i=0;i<n;i++) dp[i] = new boolean[a[i].length];
            ArrayList<Pair> list = new ArrayList<>();
            path(n,list,0,0,dp,a);
            System.out.println("Case #" + q + ":");
            for (int i=0;i<list.size();i++) {
                Pair p = list.get(i);
                System.out.println(p.a + " " + p.b);
            }
        }
    }
    private static boolean path (long n , ArrayList<Pair> list , int i , int j , boolean [][] dp , int [][] a) {
        if (n == 0) return true;
        if (n < 0) return false;
        if (i < 0 || j < 0) return false;
        if (a.length <= i || a[i].length <= j) return false;
        if (dp[i][j]) return false;
        dp[i][j] = true;
        Pair p = new Pair(i+1,j+1);
        list.add(p);
        if (path(n-a[i][j] ,list, i-1,j-1,dp,a)) {
            return true;
        }
        if (path(n-a[i][j] ,list, i-1,j,dp,a)) {
            return true;
        }
        if (path(n-a[i][j] ,list, i,j-1,dp,a)) {
            return true;
        }
        if (path(n-a[i][j] ,list, i,j+1,dp,a)) {
            return true;
        }
        if (path(n-a[i][j] ,list, i+1,j,dp,a)) {
            return true;
        }
        if (path(n-a[i][j] ,list, i+1,j+1,dp,a)) {
            return true;
        }
        list.remove(list.size()-1);
        return false;
    }
    private static int[][] pascal() {
        int [][] arr = new int [501][];
        for (int i=0;i<=500;i++) {
            arr[i] = new int[i+1];
            for (int j=0;j<=i;j++) {
                if (j == 0 || j == i) arr[i][j] = 1;
                else arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
        }
        return arr;
    }
}
