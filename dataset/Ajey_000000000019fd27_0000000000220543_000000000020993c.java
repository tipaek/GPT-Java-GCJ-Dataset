import java.util.Scanner;

/**
 *
 * @author Yadav's
 */
public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int t1 = 1;t1<=t;t1++){
            int n = in.nextInt();
            int sum = 0, col = 0, row = 0;
            int[][] arr = new int[n][n];
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    arr[i][j] = in.nextInt();
                    if(i==j)sum+=arr[i][i];
                }
            }
            for(int k = 0;k<n;k++){
                outer: for(int i = 0;i<n-1;i++){
                    for(int j = i+1;j<n;j++){
                        if(arr[k][i] == arr[k][j]){
                            row++;break outer;
                        }
                    }
                } 
            }
            for(int k = 0;k<n;k++){
                outer: for(int i = 0;i<n-1;i++){
                    for(int j = i+1;j<n;j++){
                        if(arr[i][k] == arr[j][k]){
                            col++;break outer;
                        }
                    }
                } 
            }
            System.out.println("Case #"+t1+": "+sum+" "+row+" "+col);
        }
    }
}
