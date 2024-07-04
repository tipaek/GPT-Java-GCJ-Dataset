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
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);
            String s = s1[2].trim();
            int m = s.length();
            int i = 0;
            if(x == 0 && y== 0)
            {
                bw.write("Case #"+t0+": "+(0)+"\n");
                continue;
            }
            for(i = 0; i < m; i++)
            {
                if(s.charAt(i) == 'W')
                    x--;
                if(s.charAt(i) == 'E')
                    x++;
                if(s.charAt(i) == 'N')
                    y++;
                if(s.charAt(i) == 'S')
                    y--;
                if(fun(x,y) <= i+1)
                    break;
            }
            if(i != m)
                bw.write("Case #"+t0+": "+(i+1)+"\n");
            else
                bw.write("Case #"+t0+": "+"IMPOSSIBLE"+"\n");
        }
	    bw.flush();
    }
    
    static int fun(int x, int y)
    {
        return Math.abs(x) + Math.abs(y);
    }
}