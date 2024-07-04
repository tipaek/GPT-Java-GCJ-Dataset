import java.util.*;
import java.io.*;
public class Solution
{
    public static void main (String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int l=1;l<=t;l++)
        {
            int n=Integer.parseInt(br.readLine());
            int a[][]=new int[n][n];
            StringBuffer ans=new StringBuffer();
            for(int i=0;i<n;i++)
            {
                String s[]=br.readLine().split(" ");
                for(int j=0;j<n;j++)
                a[i][j]=Integer.parseInt(s[j]);
            }
            int sum=0;
            for(int i=0;i<n;i++)
            sum+=a[i][i];
            int rc=0,cc=0;
            TreeSet<Integer> ts=new TreeSet<>();
            for(int i=0;i<n;i++)
            {
                ts=new TreeSet<>();
                for(int j=0;j<n;j++)
                ts.add(a[i][j]);
                if(ts.size()<n)
                ++rc;
            }
            for(int i=0;i<n;i++)
            {
                ts=new TreeSet<>();
                for(int j=0;j<n;j++)
                ts.add(a[j][i]);
                if(ts.size()<n)
                ++cc;
            }
            ans.append(sum+" "+rc+" "+cc);
            System.out.println("Case #"+l+": "+ans);
        }
    }
}