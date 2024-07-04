import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int tc = 1; tc <= T; tc++)
        {
            out.print("Case #"+tc+": ");
            StringTokenizer st = new StringTokenizer(input.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if((x+y)%2==0) out.println("IMPOSSIBLE");
            else if(Math.abs(x)+Math.abs(y)==1)
            {
                if(x==1) out.println("E");
                if(x==-1) out.println("W");
                if(y==1) out.println("N");
                if(y==-1) out.println("S");
            }
            else
            {
                int sum = Math.abs(x)+Math.abs(y);
                int bits = 0;
                while((1<<bits)<sum) bits++;
                int total = (1<<bits) - 1;
                int diff = total-(x+y);
                diff>>=1;
                String ans = "";
                for(int i = 0; i < bits; i++)
                {
                    int v = 1<<i;
                    if((diff&v)!=0) v *= -1;
                    v/=Math.abs(v);
                    if(x%2!=0)
                    {
                        if(v<0) ans += "W";
                        else ans += "E";
                        x -= v;
                    }
                    else
                    {
                        if(v<0) ans += "S";
                        else ans += "N";
                        y -= v;
                    }
                    x/=2;
                    y/=2;
                }
                out.println(ans);
            }
        }
        out.flush();
        out.close();
    }
}