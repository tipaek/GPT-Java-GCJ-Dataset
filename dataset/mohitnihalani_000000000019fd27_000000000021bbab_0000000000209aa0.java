import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {

    public static void sumSolve(int n, int[] nums){

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
    public static void solve(int n, int k, int a, boolean sum){
        int[] nums = new int[n];
        if(sum){
            for(int i = 0; i < n; i++) nums[i] = i+1;
            sumSolve(n, nums);
            return;
        }else {
            nums[0] = a;
            int l = 1;
            for(int i = 1; i < a; i++,l++){
                nums[l] = i;
            }

            for(int i = a+1; i <= n; i++,l++) nums[l] = i;

        }
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
            if(k % sum == 0) s = true;
            if(!s){
                for(int j = 1; j <= n; j++){
                    if(k % (j*n) == 0) {
                        a = j;
                    }
                }
            }
            if(a == -1 && !s || (n == 2 && s) || (n == 1 && k != 1)){
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            }else {
                System.out.println("Case #" + i + ": " + "POSSIBLE");
                solve(n,k,a,s);
            }

        }
    }
}