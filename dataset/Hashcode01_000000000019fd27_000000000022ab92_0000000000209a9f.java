import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args)throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int T = Integer.parseInt(br.readLine());
        int t = T;
        while(t-- > 0)
        {
            String N = br.readLine();
            N = N+"0";
            String res = "";
            int ob = 0, cb = 0;
            int len = N.length();
            int prev = 0;
            for(int i=0;i<len;i++)
            {
            	int a =  Integer.parseInt(N.substring(i,i+1));
            	int diff = a - prev;
                if(diff == 0)
                    res += a;
                else if(diff > 0)
                {
                    for(int j=0;j<diff;j++)
                        res += "(";
                    res += a;
                    ob += diff;
                }
                else
                {
                    for(int j=0;j<Math.abs(diff);j++)
                        res += ")";
                    cb += Math.abs(diff);
                    res += a;
                }
                prev = a;
            }
            
            System.out.println("Case #"+(T-t)+": "+res.substring(0,res.length()-1));
        }
        br.close();
        isr.close();
    }
}