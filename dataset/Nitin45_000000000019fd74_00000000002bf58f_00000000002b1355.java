import java.io.*;
import java.util.*;
import java.math.*;
import java.util.regex.*;
class Solution{

    public static void main(String args[])throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int p=0;p<T;p++){
            int r =sc.nextInt();
            int c =sc.nextInt();
            int arr[][]= new int[r][c];
            int sum=0;
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            if(r==1&&c==1){
                sum+=arr[0][0];
            }
            else if(r==1&&c!=1) {
                for(int k=1;k<=c;k++){
                for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                   sum+=arr[i][j];
                   if(arr[i][j]==k)
                   arr[i][j]=0;
                    
                }
                }
                }
            }
            else{
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                   
                }
                
            }
            }
            System.out.println("Case #"+(p+1)+": "+sum);
        }
    }
}