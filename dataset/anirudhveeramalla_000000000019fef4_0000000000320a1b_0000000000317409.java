import java.io.*;
import java.util.*;
// import java.math.*;

class Solution
{
    static BufferedReader br;
    static BufferedWriter bw;
    static void solve() throws Exception
    {
        String input[] = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        String str = input[2];
        if(x == 0 && y==0)
        {
            bw.write("0");
            bw.newLine();
            return;
        }
        boolean flag = true;
        int length = 0;
        int ans = Integer.MAX_VALUE;
        for(char ch : str.toCharArray())
        {
            length++;
            if(ch == 'N')
            y++;
            else if(ch == 'S')
            y--;
            else if(ch == 'E')
            x++;
            else
            x--;
            int mytime = Math.abs(x)+Math.abs(y);
            if(mytime<=length)
            {
                ans  = Math.min(ans,length);
                flag = false;
            }
        }
        if(flag)
        {
            bw.write("IMPOSSIBLE");
        }
        else
            bw.write(Integer.toString(ans));
        bw.newLine();
    }
    public static void main(String[] args)throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {
            bw.write("Case #"+(i+1)+": ");
            solve();
        }
        br.close();
        bw.close();
    }
}