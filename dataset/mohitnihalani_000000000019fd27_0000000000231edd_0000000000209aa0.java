import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {

    static int[][] matrix;
    static boolean solved = false;
    public static void dfs(int n, int k){
        matrix = new int[n][n];
        solve(0,0,n,0,k);
       
    }

    public static void place(int x, int y, int n, int sum, int k){
        //System.out.println(k);
       if(x == n-1 && y == n-1){
        if(sum == k) solved = true;
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
    public static void sumSolve(int n){
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) nums[i] = i+1;
        for(int i = 1; i <= n; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 2; i <= n; i++){
            
            for(int j = 1; j <= n; j++){
                nums[j-1] = ((nums[j-1] == n) ? 1 : nums[j-1]+1);
                System.out.print(nums[j-1] + " ");
            }
            System.out.println();
        }
    }

    public static void diagonal(int n, int i, int j){
        int a = i;
        int b = j;
        int c = -1;
        int d = -1;
        
        for(int k = 1; k <= n; k++){
            if(k != a && k != b && c == -1){
                c = k;
            }
            if(k != a && k != b && c != k){
                d = k;
            }
            if(c != -1 && d != -1) break;
        }
        System.out.println(a + " " + b + " " + c + " " + d);
        System.out.println(b + " " + a + " " + d + " " + c);
        System.out.println(c + " " + d + " " + b + " " + a);
        System.out.println(d + " " + c + " " + a + " " + b);

    }
    public static void solve(int n, int k, int a, boolean sum){
        int[] nums = new int[n];
        nums[0] = a;
        int l = 1;
            for(int i = 1; i < a; i++,l++){
                nums[l] = i;
            }

            for(int i = a+1; i <= n; i++,l++) nums[l] = i;


        int m = n+1;
        for(int i = 1; i <= n; i++){
            int temp = m;
            while(temp <= n){
                System.out.print(nums[temp-1] + " "); 
                temp++;
            }

            for(int j = 1; j < m; j++){
                System.out.print(nums[j-1] + " ");
            }
            m--;
            System.out.println(); 
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  //

        for(int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            boolean s = false;
            int a = -1;
            int sum = (n*(n+1))/2;
            if(k == 0 || (n == 1 && k != 1) || k > n*n){
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
                continue;
            }else if(k % sum == 0){
                if(n == 2 && k == 3){
                    System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
                    continue; 
                }
                System.out.println("Case #" + i + ": " + "POSSIBLE");
                sumSolve(n);
                continue;
            }else {
                for(int j = 1; j <= n; j++){
                    if(k % (j*n) == 0) {
                        a = j;
                    }
                }
                if(a != -1){
                    System.out.println("Case #" + i + ": " + "POSSIBLE");
                    solve(n,k,a,s);
                    continue;
                }else if(a == -1 && n == 4){
                    boolean done = false;
                    
                    for(int l = 1; l <= n && !done; l++){
                        for(int m = l+1; m <= n && !done; m++){
                            if(2*(l+m) == k){
                                done = true;
                                System.out.println("Case #" + i + ": " + "POSSIBLE");
                                diagonal(n,l,m);
                            }
                        }
                    }
                    if(!done)System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
                }else {
                    if(n == 5){
                        dfs(n, k);
                    }
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
    }
}