import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int t0 = 1; t0 <= t; t0++)
        {
            String s1[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int d = Integer.parseInt(s1[1]);
            String s2[] = br.readLine().trim().split(" ");
            long a[] = new long[n];
            for(int i = 0; i < n; i++)
                a[i] = Long.parseLong(s2[i]);
            Arrays.sort(a);
            int cnt = 1;
            int max = 1;
            for(int i = 1; i < n; i++)
            {
                if(a[i] == a[i-1])
                    cnt++;
                else
                    cnt = 1;
                max = Math.max(cnt,max);
            }
            if(max >= d)
            {
                bw.write("Case #"+t0+": "+0+"\n");
                continue;
            }
            else if(d == 2)
            {
                bw.write("Case #"+t0+": "+1+"\n");
                continue;
            }
            boolean f = false;
            for(int i = 0; i < n; i++)
                if(Arrays.binarySearch(a,a[i]*2) > 0)
                    f = true;
            if(f)
                bw.write("Case #"+t0+": "+1+"\n");
            else
                bw.write("Case #"+t0+": "+2+"\n");
        }
	    bw.flush();
    }
    
}