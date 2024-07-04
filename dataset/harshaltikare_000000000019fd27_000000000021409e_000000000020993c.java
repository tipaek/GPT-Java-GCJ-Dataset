import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();//test cases
        if(t<1 && t>100){
            System.exit(0);
        }
        for(int z=0;z<t;z++){
            //main code
            int n=sc.nextInt();//matrix size
            if(n<2 && n>100){
                System.exit(0);
            }
            int[][] arr=new int[n][n];
            
            //array input
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=sc.nextInt();
                    if(arr[i][j]<1 && arr[i][j]>n){
                        System.exit(0);
                    }
                }
            }
            //trace
            int sum=0;
            for(int i=0;i<n;i++){
                sum=sum+arr[i][i];
            }
            System.out.print("Case #"+z+": "+sum+" ");
            
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