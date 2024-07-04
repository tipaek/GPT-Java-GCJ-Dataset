import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++){
           int n=sc.nextInt();
           int a[][]=new int[n][n];
           int trace=0;
           int r=0,c=0;
           for(int j=0;j<n;j++){
               for(int k=0;k<n;k++){
               a[j][k]=sc.nextInt();
               if(j==k)
                   trace+=a[j][k];
                   
               }
           }
           for(int j=0;j<n;j++){
              int f[]=new int[n+1];
              for(int k=0;k<n;k++){
                f[a[k][j]]++;
                if(f[a[k][j]]>1){
                    c++;
                    break;
                }
              }
           }
           for(int j=0;j<n;j++){
              int f[]=new int[n+1];
              for(int k=0;k<n;k++){
                f[a[j][k]]++;
                if(f[a[j][k]]>1){
                    r++;
                    break;
                }
              }
           }
           System.out.println("Case #"+i+": "+trace+" "+r+" "+c);
        }
    }
}