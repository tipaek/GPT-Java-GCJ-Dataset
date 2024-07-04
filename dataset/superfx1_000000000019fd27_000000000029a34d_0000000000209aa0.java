
import java.util.*;
import java.io.*;
public class Solution {
    public static boolean solved=false;
    
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T=input.nextInt();
        for(int t=1;t<=T;t++){
            int n=input.nextInt();
            int k=input.nextInt();
            int[][] matrix=new int[n][n];
            if(!solver(matrix,t,k,n))
                System.out.println("Case #"+t+": IMPOSSIBLE");
            }
        }
    
    public static void solve(int row,int col,int sum, int[][] arr,int t, int n,int k){
    if(solved||sum>k)
        return;
    if(row==n-1 && col==n && sum==k){
            solved=true;
            System.out.println("Case #"+t+": POSSIBLE");
            for(int i = 0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println("");
                
            }
            return;
        }
    if (col==n){
       row++;
       col=0;
    }
    if(row>=n)
        return;
    loop : for(int i=1;i<=n;i++){
        for(int j =0;j<col;j++){
        if(arr[row][j]==i)
            continue loop;
        }
        for(int j =0;j<row;j++){
        if(arr[j][col]==i)
            continue loop;
        }
        if(row==col){
        sum+=i;
        }
        arr[row][col]=i;
        solve(row,col+1,sum,arr,t,n,k);
        arr[row][col]=0;
        if(row==col){
        sum-=i;
        }
        
    }
    }
    
    public static boolean solver(int[][] arr,int t,int k,int n){
        solve(0,0,0,arr,t,n,k);
        return solved;
    }

}
