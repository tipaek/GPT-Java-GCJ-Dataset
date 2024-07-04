import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(input.readLine());
        for(int tc = 1; tc <= t; tc++)
        {
            int n = Integer.parseInt(input.readLine());
            String pre = "";
            String post = "";
            StringBuilder middle = new StringBuilder("");
            boolean works = true;
            for(int i = 0; i < n; i++)
            {
                String s = input.readLine();
                int j;
                int k;
                for(j = 0; j < s.length(); j++)
                {
                    if(s.charAt(j)=='*') break;
                    if(j==pre.length()) pre += s.charAt(j);
                    else if(pre.charAt(j)!=s.charAt(j))
                    {
                        works = false;
                        break;
                    }
                }
                for(k = s.length()-1; k >= 0; k--)
                {
                    int oh = (s.length()-1-k);
                    if(s.charAt(k)=='*') break;
                    if(oh==post.length()) post += s.charAt(k);
                    else if(post.charAt(oh)!=s.charAt(k))
                    {
                        works = false;
                        break;
                    }
                }
                for(int l = j; l <= k; l++) if(s.charAt(l)!='*') middle.append(s.charAt(l));
            }
            StringBuilder rev = new StringBuilder(post);
            out.print("Case #" + tc + ": ");
            if(works)
            {
                out.print(pre);
                out.print(middle);
                out.println(rev.reverse());
            }
            else out.println("*");
        }
        out.flush();
        out.close();
    }
}