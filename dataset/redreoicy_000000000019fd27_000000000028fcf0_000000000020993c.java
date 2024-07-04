import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int t = stdin.nextInt();
        for (int k = 0; k < t; k++) {
            //working code here
            int n = stdin.nextInt();
            int[][] arr = new int[n][n];
            for(int i = 0; i<n;i++){
                for(int j = 0; j<n;j++){
                    arr[i][j] = stdin.nextInt();
                }
            }
            
            int[] a100 = new int[101];
            int repeatedr = 0;
            
            for(int i = 0;i<n;i++){
                for(int j = 0; j<n; j++){
                    a100[arr[i][j]]++;
                }
                for(int count : a100){
                    if(count > 1){
                        repeatedr++;
                        break;
                    }
                }
                for(int l = 0; l<101;l++){
                    a100[l] = 0;
                }
            }
            
            int repeatedc = 0;
            for(int j = 0;j<n;j++){
                for(int i = 0; i<n; i++){
                    a100[arr[i][j]]++;
                }
                for(int count : a100){
                    if(count > 1){
                        repeatedc++;
                        break;
                    }
                }
                for(int l = 0; l<101;l++){
                    a100[l] = 0;
                }
            }
            
            int sum = 0;
            for(int i = 0; i<n;i++){
                sum += arr[i][i];
            }
            
            
            System.out.printf("Case #%d: %d %d %d\n", k+1, sum, repeatedr, repeatedc);
        }

    }
    
}
