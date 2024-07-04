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
            String s = br.readLine().trim();
            String ans = "";
            int c = 0;
            for(int i = 0; i < s.length(); i++)
            {
                int x = (int)s.charAt(i) - 48;
                if(c<x)
                {
                    while(c!=x)
                    {
                        ans += "(";
                        c++;
                    }
                }
                if(c>x)
                {
                    while(c!=x)
                    {
                        ans += ")";
                        c--;
                    }
                }
                ans += ""+x;
            }
            while(c!=0)
            {
                ans += ")";
                c--;
            }
            bw.write("Case #"+t0+": "+ans+"\n");
        }
        bw.flush();
    }
}