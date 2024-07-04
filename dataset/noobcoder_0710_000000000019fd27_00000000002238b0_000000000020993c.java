import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String args[])throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int t=Integer.parseInt(br.readLine());
        for(int x=0;x<t;x++)
        {
            int n=Integer.parseInt(br.readLine());
            int arr[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                String str[]=br.readLine().split(" ");
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=Integer.parseInt(str[j]);
                }
            }
            int sum=0,rc=0,cc=0;
            for(int i=0;i<n;i++)
            sum+=arr[i][i];
            for(int i=0;i<n;i++)
            {
                boolean vis[]=new boolean[n+1];
                for(int j=0;j<n;j++)
                {
                    if(vis[arr[i][j]])
                    {
                        rc++;
                        break;
                    }
                    vis[arr[i][j]]=true;
                }
            }
            for(int i=0;i<n;i++)
            {
                boolean vis[]=new boolean[n+1];
                for(int j=0;j<n;j++)
                {
                    if(vis[arr[j][i]])
                    {
                        cc++;
                        break;
                    }
                    vis[arr[j][i]]=true;
                }
            }
            pw.println("Case #"+(x+1)+": "+sum+" "+rc+" "+cc);
        }
        pw.flush();
        pw.close();
    }
}