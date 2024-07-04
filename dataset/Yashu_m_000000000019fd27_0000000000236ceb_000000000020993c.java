import java.io.*;
import java.util.*;
import java.util.Arrays;
class Main
{
        
    public static void main(String[] args)
    {
    Scanner sc= new Scanner(System.in);
    int t=sc.nextInt();
    int r1=1;
    while(r1<=t)
    {
        int n=sc.nextInt();
        int[][] a= new int[n][n];
        int  k=0,r=0,c=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                a[i][j]=sc.nextInt();
                if(i==j)
                k=k+a[i][j];
                
            }
            
            
        }
        for(int i=0;i<n;i++)
        {int[] q=new int[n];
            for(int j=0;j<n;j++)
            {
                q[j]=a[i][j];
            }
            Arrays.sort(q);
            for(int u=0;u<n-1;u++)
            {
                if(q[u]==q[u+1])
                {
                    r++;
                    break;
                    
                }
            }
        }
        for(int j=0;j<n;j++)
        {int[] q= new int[n];
            for(int i=0;i<n;i++)
            {
                q[i]=a[i][j];
            }
            Arrays.sort(q);
            for(int u=0;u<n-1;u++)
            {
                if(q[u]==q[u+1])
                {
                    c++;
                    break;
                }
            }
        }
           
        System.out.println("Case #"+r1+": "+k+" "+r+" "+c);
        r1++;
    }
    }
}