import java.util.*;
import java.io.*;

public class Solution 
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine());
        for(int t=1; t<=tc; t++)
        {
            char[] data = in.readLine().toCharArray();
            int n = data.length;
            int prev = 0, curr = 0;
            String res = "";
            for(int i=0; i<n; i++) 
            {
                curr = Integer.parseInt(data[i]+"");
                while (curr>prev)
                {
                    res += "(";
                    prev++;
                }
                while (curr<prev)
                {
                    res += ")";
                    prev--;
                }
                res+=curr;
            }
            curr = 0;
            while (curr>prev)
            {
                res += "(";
                prev++;
            }
            while (curr<prev)
            {
                res += ")";
                prev--;
            }
            System.out.println("Case #"+t+": "+res);
        }
    }
}