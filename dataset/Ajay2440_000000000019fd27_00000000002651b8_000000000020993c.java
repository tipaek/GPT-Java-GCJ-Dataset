import java.util.*;
 public class Solution{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int p=in.nextInt();
         for(int t=1;t<=p;t++)
        {
            int n=in.nextInt();
            int[][] a=new int[n][n];
            int dia=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=in.nextInt();
                    if(i==j)
                    dia+=a[i][j];
                }
            }
           int rmax=0,cmax=0;
           int r=0;
        while( r<n)
             {
               int k=a[r][0];
               int flag=0;
               for(int i=1;i<n;i++)
               {
                 if(k==a[r][i])
                 {
                     flag=1;
                     break;
                     
                 }
               }
               if(flag==1)
               {
                   rmax++;
               }
               r++;
             
             }
             int c=0;
              while( c<n)
             {
               int k=a[0][c];
               int flag=0;
               for(int i=1;i<n;i++)
               {
                 if(k==a[i][c])
                 {
                     flag=1;
                     break;
                     
                 }
               }
               if(flag==1)
               {
                   cmax++;
               }
               c++;
             
             }
               
            System.out.println("Case #"+t+": "+dia+" "+rmax+" "+cmax);
        
        
    }
}
}