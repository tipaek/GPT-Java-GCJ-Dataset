import java.util.*;
import java.io.*;
import java.awt.*;


public class Solution
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(f.readLine());

        for (int k=1; k<=t; k++)
        {
            StringTokenizer st = new StringTokenizer(f.readLine());
            long l = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());
            long i = 1;
            while(Math.max(l, r)>=i)
            {
                if (l>=r)
                {
                    l-=i;
                }
                else
                {
                    r-=i;
                }
                i++;
            }
            System.out.println("Case #" + k + ": " + (i-1) + " " + l + " " + r);
        }
    }


}