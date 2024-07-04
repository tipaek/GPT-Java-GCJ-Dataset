import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int tc = 1; tc <= T; tc++)
        {
            out.print("Case #"+tc+": ");
            StringTokenizer st = new StringTokenizer(input.readLine());
            long L = Long.parseLong(st.nextToken());
            long R = Long.parseLong(st.nextToken());
            int times = 0;
            while(times+1<=L||times+1<=R)
            {
                int n = ++times;
                if(L>=R) L-=n;
                else R-=n;
            }
            out.println(times + " " + L + " " + R);
        }
        out.close();
    }
}