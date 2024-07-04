import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


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
        for (int q =1 ;q<=t;q++) {
            int n = s.nextInt();
            int m = s.nextInt();
            int [][] arr = new int[n][m];
            for (int i=0;i<n;i++) {
                for(int j=0;j<m;j++) arr[i][j] = s.nextInt();
            }
            System.out.println("Case #" + q + ": " + calculate(arr,n,m));
        }
    }
    private static long calculate (int [][] arr , int n , int m) {
        boolean flag = true;
        long ans = 0;
        Set<Pair> set = new HashSet<>();
        while (flag) {
            ans += calc(arr,n,m);
            ArrayList<Pair> list = new ArrayList<>();
            int net = 0;
            for (int i=0;i<n;i++) {
                for (int j=0;j<m;j++) {
                    if (arr[i][j] == 0) continue;
                    Pair p = new Pair(i,j);
                    if (set.contains(p)) continue;
                    int count = 0;
                    int x = getBottom(arr,n,m,i,j);
                    if (x != 0) count++;
                    int y = getLeft(arr,n,m,i,j);
                    if (y!=0) count++;
                    int z = getRight(arr,n,m,i,j);
                    if (z!=0) count++;
                    int w = getTop(arr,n,m,i,j);
                    if (w!=0) count++;
                    if (count > 0) {
                        double avg = (x+y+z+w)/(count*1.0);
                        if (avg > arr[i][j]) {
                            list.add(p);
                            net++;
                        }
                    } else set.add(p);
                }
            }
            if (net > 0) {
                for (int i=0;i<list.size();i++) {
                    Pair p = list.get(i);
                    arr[p.a][p.b] = 0;
                }
            } else flag = false;
        }
        return ans;
    }
    private static int getLeft (int [][] arr , int n , int m , int i , int j) {
        for (int x = j-1;x>=0;x--) {
            if (arr[i][x] != 0) return arr[i][x];
        }
        return 0;
    }
    private static int getRight (int [][] arr , int n , int m , int i , int j) {
        for (int x = j+1;x<m;x++) {
            if (arr[i][x] != 0) return arr[i][x];
        }
        return 0;
    }
    private static int getTop (int [][] arr , int n , int m , int i , int j) {
        for (int x = i-1;x>=0;x--) {
            if (arr[x][j] != 0) return arr[x][j];
        }
        return 0;
    }
    private static int getBottom (int [][] arr , int n , int m , int i , int j) {
        for (int x = i+1;x<n;x++) {
            if (arr[x][j] != 0) return arr[x][j];
        }
        return 0;
    }
    private static long calc(int [][] arr , int n , int m) {
        long ans = 0;
        for (int i=0;i<n;i++) {
            for(int j=0;j<m;j++) ans += arr[i][j];
        }
        return ans;
    }
}
