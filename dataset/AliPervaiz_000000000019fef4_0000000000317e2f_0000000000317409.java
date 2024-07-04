import java.util.*;
import java.io.*;

public class Solution 
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int TC = Integer.parseInt(input.readLine());
        for(int t = 1; t <= TC; t++)
        {
            out.print("Case #" + t + ": ");
            StringTokenizer st = new StringTokenizer(input.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            boolean works = false;
            for(int i = 0; i < s.length(); i++)
            {
                if(s.charAt(i)=='N') y++;
                else if(s.charAt(i)=='E') x++;
                else if(s.charAt(i)=='S') y--;
                else x--;
                if(Math.abs(x)+Math.abs(y)<=i+1)
                {
                    works = true;
                    out.println(i+1);
                    break;
                }
            }
            if(!works) out.println("IMPOSSIBLE");
        }
        out.flush();
        out.close();
    }
}