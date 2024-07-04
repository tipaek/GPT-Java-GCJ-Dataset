import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int t0 = 1; t0<=t; t0++)
        {
            int n = Integer.parseInt(br.readLine());
            int a[][] = new int[n][n];
            long ans = 0l;
            int r =0, c = 0;
            for(int i = 0;i<n;i++)
            {
                String s[] = br.readLine().trim().split(" ");
                for(int j = 0;j<n;j++)
                    a[i][j] = Integer.parseInt(s[j]);
            }
            for(int i=0;i<n;i++)
                ans += a[i][i];
            for(int i = 0;i<n;i++)
            {
                int ar[] = new int[n];
                for(int j = 0;j<n;j++)
                    ar[a[i][j] - 1]++;
                for(int j = 0;j<n;j++)
                    if(ar[j]==0)
                    {
                        r++;
                        break;
                    }
            }
            for(int i = 0;i<n;i++)
            {
                int ar[] = new int[n];
                for(int j = 0;j<n;j++)
                    ar[a[j][i] - 1]++;
                for(int j = 0;j<n;j++)
                    if(ar[j]==0)
                    {
                        c++;
                        break;
                    }
            }
            bw.write("Case #"+t0+": "+ans+" "+r+" "+c+"\n");
        }
        bw.flush();
    }
}