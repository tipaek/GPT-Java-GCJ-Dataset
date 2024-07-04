import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Solution {

    public static void main(String[] args) throws java.io.IOException{
	// write your code here
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int j=1;j<=t;j++)
        {
            String[] str=br.readLine().split(" ");
            int x=Integer.parseInt(str[0]);
            int y=Integer.parseInt(str[1]);
            String S=str[2];
            int len=S.length();
            int cur_dist=Math.abs(x)+Math.abs(y);
            int ans=0;
            for(int i=0;i<len;i++)
            {
                char ch=S.charAt(i);
                if(ch=='N')
                    y++;
                if(ch=='S')
                    y--;
                if(ch=='W')
                    x--;
                if(ch=='E')
                    x++;
                cur_dist=Math.abs(x)+Math.abs(y);
                if(cur_dist<=i+1) {
                    ans = i+1;
                    break;
                }
            }
            if(ans!=0)
            System.out.println("Case #"+j+": "+ans);
            else
                System.out.println("Case #"+j+": IMPOSSIBLE");
        }
    }
}
