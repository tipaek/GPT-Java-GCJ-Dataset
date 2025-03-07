import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution
{
    int t;
    int x;
    int y;
    void input()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());
        StringTokenizer st =null;
        for(int i=1;i<=t;i++ ) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            display(i);
        }

    }
    public void display(int tc)
    {
        String s="";
        int n1=x*y;
        int n=(x-1)*(y-1);
        System.out.println("Case #"+tc+": "+n);
        int i=1;
        int b=x-1;
        int k=0;
        while(i<=n)
        {
                for(int j=1;j<=y-1;j++)
                {
                    int a=n1-j-b-(k*(y));
                    s=s+a+" "+b+"\n";
                    i++;
                }
                k++;
                b=b-1;
        }
        System.out.println(s);
    }
    public static void main(String args[])throws  IOException
    {
        Solution ob = new Solution();
        ob.input();
    }
}
