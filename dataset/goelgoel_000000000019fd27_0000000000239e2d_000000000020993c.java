import java.io.*;
import java.util.*;
class Solution{
    public static void main(String args[])throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int k=1;
        while(t-->0){
            int n=sc.nextInt();
            int mat[][]=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    mat[i][j]=sc.nextInt();
                }
            }
            int sum=0;
            for(int i=0;i<n;i++)
            sum+=mat[i][i];
            int a[]=new int[n+1];
            int rc=0;
            for(int i=0;i<n;i++){
                a=new int[n+1];
                for(int j=0;j<n;j++){
                    if(a[mat[i][j]]==1){
                        rc++;
                        break;
                    }
                   a[mat[i][j]]=1;
                }
            }
             int cc=0;
            for(int i=0;i<n;i++){
                a=new int[n+1];
                for(int j=0;j<n;j++){
                    if(a[mat[j][i]]==1){
                        cc++;
                        break;
                    }
                   a[mat[j][i]]=1;
                }
            }
    System.out.println("Case #"+k+": "+sum+" "+rc+" "+cc);
       k++; }
    }
}