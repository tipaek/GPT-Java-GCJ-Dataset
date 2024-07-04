import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Solution {


    static int[][] matrix;
    static boolean solved;
    public static void dfs(int n, int k){
        matrix = new int[n][n];
        solved = false;
        solve(0,0,n,0,k);
       
    }

    public static void place(int x, int y, int n, int sum, int k){
        //System.out.println(k);
       if(x == n-1 && y == n-1){
        if(sum == k){
            solved = true;
        }
        return;
       }else {
           if(y == n-1) solve(x+1,0,n,sum,k);
           else solve(x,y+1,n,sum,k);
       }
    }

    public static void solve(int x, int y,int n,int sum, int k){
        if(matrix[x][y] == 0){
            for(int i = 1; i <= n; i++){
                if(isValid(x,y,i,n)){
                    if(x == y && (sum + i > k)) continue;
                    matrix[x][y] = i;
                    if(x == y) sum += i;
                    place(x, y, n, sum, k);
                    if(solved) return;
                    if(x == y) sum -= i;
                    matrix[x][y] = 0;
                }
            }
        }
    }

    public static boolean isValid(int x, int y, int a, int n){
        for(int i = 0; i < n; i++){
            if(matrix[x][i] == a || matrix[i][y] == a){
                return false;
         }        
     }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  
        for(int i = 1; i <= t; i++){
            int n = in.nextInt();
            int k = in.nextInt();
            dfs(n, k);
            if(solved){
                System.out.println("Case #" + i + ": " + "POSSIBLE");
                for(int d = 0; d < n; d++){
                    for(int e = 0; e < n; e++){
                        System.out.print(matrix[d][e] + " ");
                    }
                    System.out.println();
                }
            }else {
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            }
        }
    }
}