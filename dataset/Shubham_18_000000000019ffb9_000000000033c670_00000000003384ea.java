import java.io.*;
import java.util.*;

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
            long l = Long.parseLong(s1[0]);
            long r = Long.parseLong(s1[1]);
            long tmp, tmp1, tmp2, ans, tmp3, tmp4;
            if(l > r)
            {
                tmp = l - r;
                tmp = ((long)Math.sqrt(8*tmp +1) -1) / 2;
                tmp1 = (tmp*(tmp+1))/2;
                l = l - tmp1;
            }
            else
            {
                tmp = r - l;
                tmp = ((long)Math.sqrt(8*tmp +1) -1) / 2;
                tmp1 = (tmp*(tmp+1))/2;
                r = r - tmp1;
            }
            // ans = tmp;
            // bw.write(l+" "+r+" "+tmp+"\n");
            if(l < r)
            {
                tmp1 =  ((long)Math.sqrt(4*r + tmp*tmp) - tmp) / 2;
                tmp3 = (tmp+1) + (tmp1 - 1)*2;
                tmp1 = tmp1 * (tmp + tmp1);
                r = r - tmp1;
                tmp++;
                tmp2 =  ((long)Math.sqrt(4*l + tmp*tmp) - tmp) / 2;
                tmp4 = (tmp+1) + (tmp2 - 1)*2;
                tmp2 = tmp2 * (tmp + tmp2);
                l = l - tmp2;
            }
            else
            {
                tmp1 =  ((long)Math.sqrt(4*l + tmp*tmp) - tmp) / 2;
                tmp3 = (tmp+1) + (tmp1 - 1)*2;
                tmp1 = tmp1 * (tmp + tmp1);
                l = l - tmp1;
                tmp++;
                tmp2 =  ((long)Math.sqrt(4*r + tmp*tmp) - tmp) / 2;
                tmp4 = (tmp+1) + (tmp2 - 1)*2;
                tmp2 = tmp2 * (tmp + tmp2);
                r = r - tmp2;
            }
            ans = Math.max(tmp3, tmp4);
            bw.write("Case #"+t0+": ");
            bw.write(ans+" "+l+" "+r+"\n");
        }
        bw.flush();
    }
}