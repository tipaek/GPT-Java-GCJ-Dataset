import java.util.*;
 public class Solution{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int p=in.nextInt();
         for(int t=1;t<=p;t++)
        {
            int n=in.nextInt();
            int[][] a=new int[n][n];
            int dia=0,rmax=0,cmax=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=in.nextInt();
                    if(i==j)
                    dia+=a[i][j];
                }
            }
           
             int r=0,c=0;
            while(c<n)
            {
                int f=0;
                int k=a[r][c];
                for(int i=r+1;i<n;i++)
                {
                    if(k==a[i][c])
                    {
                        f=1;
                        break;
                    }
                }
                if(f==1)
                {
                    cmax++;
                    c++;
                    r=0;
                }
                else
                {
                    r++;
                    if(r+1==n)
                    {
                        c++;
                        r=0;
                    }
                   
                }
            }
            int r1=0,c1=0;
            while(r1<n)
            {
                int f=0;
                int k=a[r1][c1];
                for(int i=c1+1;i<n;i++)
                {
                    if(k==a[r1][i])
                    {
                        f=1;
                        break;
                    }
                }
                if(f==1)
                {
                    rmax++;
                    r1++;
                    c1=0;
                }
                else
                {
                    c1++;
                    if(c1+1==n)
                    {
                        r1++;
                        c1=0;
                    }
                   
                }
            }
           
            System.out.println("Case #"+t+": "+dia+" "+rmax+" "+cmax+" ");
        }
    }
 
}