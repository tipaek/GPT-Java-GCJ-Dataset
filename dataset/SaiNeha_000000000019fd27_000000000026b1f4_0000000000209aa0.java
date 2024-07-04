import java.util.*;
import java.lang.*;
import java.io.*;
class  Solution{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int b=0;
        while(t-->0)
        {
            int f=0;
            b++;
            int n=sc.nextInt();
            int k=sc.nextInt();
            int a[][]=new int[n][n];
            for(int i=1;i<=n;i++)
            {
                int j=i;
                for(int c=0;c<n;c++)
                {
                    for(int y=0;y<n;y++)
                    {
                        if(c==0)
                        {
                            a[c][y]=j++;
                            if(j>n)
                            {
                               j=1;
                            }
                        }
                        else
                        {
                            if(y==0)
                            {
                                a[c][y]=a[c-1][n-1];
                            }
                            else
                            {
                                a[c][y]=a[c-1][y-1];
                            }
                        }
                    }
                }
                int sum=0;
                for(int d=0;d<n;d++)
                {
                    sum+=a[d][d];
                }
                if(sum==k)
                {
                    f=1;
                    break;
                }
            }
           if(f==0)
           {
               System.out.println("Case #"+b+": IMPOSSIBLE");
           }
           else
           {
               System.out.println("Case #"+b+": POSSIBLE");
               for (int u=0;u<n;u++ ) {
                    for (int q=0;q<n ;q++ ) {
                        System.out.print(a[u][q]+" ");
                    }
                    System.out.println();
                }
           }
        }
        
    }
}