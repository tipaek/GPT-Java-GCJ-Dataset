import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0){
            t--;
            int x=0;
            int n=sc.nextInt();
            int tr=0;
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
            for(int j=0;j<n;j++)
             {
                 a[i][j]=sc.nextInt();
                 if(i==j)
                  tr+=a[i][j];
             }
            }
            int flag=0,r=0;
            for(int i=0;i<n-1;i++)
             {
                 flag=0;
                 for(int j=0;j<n-1;j++)
                 {
                     if(a[i][j]==a[i][j+1])
                     flag=1;
                 }
                 if(flag==1)
                 r++;
             }
             flag=0;
             int c=0;
             for(int i=0;i<n-1;i++)
             {
                 flag=0;
                 for(int j=0;j<n-1;j++)
                 {
                     if(a[j][i]==a[j][i+1])
                     flag=1;
                 }
                 if(flag==1)
                 c++;
             }
             x++;
    System.out.println("Case #"+x+": "+tr+" "+r+" "+c );

        }
    }
}