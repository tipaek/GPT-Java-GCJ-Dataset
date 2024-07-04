import java.util.*;
import java.io.*;
class java
{
    public static void main(String [] args) throws IOException
    {
        BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(input.readLine());
        for(int k=1;k<=t;k++)
        {
            int n=Integer.parseInt(input.readLine());
            int [][] a=new int[n][n];
            HashSet<Integer>row=new HashSet<Integer>();
            HashSet<Integer>col=new HashSet<Integer>();
            int r=0,c=0;
            for(int i=0;i<n;i++)
            {
                row.clear();
                for(int j=0;j<n;j++)
                {
                    a[i][j]=Integer.parseInt(input.readLine());
                    row.add(a[i][j]);
                }
                if(row.size()<n)
                {
                    r=r+1;
                }
            }
            int s=0;
            for(int i=0;i<n;i++)
            {
                s=a[i][i]+s;
            }
            System.out.println(r+" "+s);
        }
    }
}