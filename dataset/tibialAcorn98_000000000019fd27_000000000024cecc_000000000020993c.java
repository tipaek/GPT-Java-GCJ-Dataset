import java.io.*;
import java.lang.*;
import java.util.*;

  public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int  t= in.nextInt();
        for(int k=0; k<t; k++){
            int n=in.nextInt();
            int[][] arr=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=in.nextInt();
                }
            }
            System.out.println("Case #"+(k+1)+": "+solve(arr));
        }
        
    }
    
    public static String solve(int[][]arr) {
        int n=arr.length;
        String ans="";
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i][i];
        }
        //calc row
        int[] num;
        int[] row=new int[n];
        int[] col=new int[n];
        
        for(int i=0;i<n;i++){
            num=new int[n+1];
            for(int j=0;j<n;j++){
                if(num[arr[i][j]]!=0){
                    row[i]=1;
                }
                num[arr[i][j]]=1;
               }
        }
        
         for(int i=0;i<n;i++){
            num=new int[n+1];
            for(int j=0;j<n;j++){
                if(num[arr[j][i]]!=0){
                    col[i]=1;
                }
                num[arr[j][i]]=1;
               }
        }
        
        //find sum of row/col
        int rsum=0;
        int csum=0;
        for(int i=0;i<n;i++){
            rsum+=row[i];
            csum+=col[i];
        }
        
      return ""+sum+" "+rsum+" "+csum; 
    }
    
    
}






