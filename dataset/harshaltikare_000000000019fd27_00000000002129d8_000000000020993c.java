import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();//test cases
        for(int z=0;z<t;z++){
            //main code
            int n=sc.nextInt();//matrix size
            int[][] arr=new int[n][n];
            
            //array input
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            //trace
            int sum=0;
            for(int i=0;i<n;i++){
                sum=sum+arr[i][i];
            }
            System.out.print("Case #"+t+": "+sum+" ");
            
            //rnc
            int rrep=0;
            for(int i=0;i<n;i++){
                int flag=1;
                for(int j=0;j<n-1;j++){
                    for(int k=j+1;k<n;k++){
                        if(arr[i][j]==arr[i][k]){
                            flag=flag+1;
                        }
                    }
                }
                if(flag>1){
                    rrep=rrep+1;
                }
            }
            System.out.print(rrep+" ");
            int crep=0;
            for(int i=0;i<n;i++){
                int flag=1;
                for(int j=0;j<n-1;j++){
                    for(int k=j+1;k<n;k++){
                        if(arr[j][i]==arr[k][i]){
                            flag=flag+1;
                        }
                    }
                }
                if(flag>1){
                    crep=crep+1;
                }
            }
            System.out.print(crep+"\n");
            
        }
    }
}