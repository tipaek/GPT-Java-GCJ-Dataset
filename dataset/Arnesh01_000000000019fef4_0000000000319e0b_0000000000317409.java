import java.io.*;
import java.util.*;
import java.lang.*;
public class Solution{
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuffer sb=new StringBuffer();
        for(int mm=1;mm<=T;mm++){
            String str[] =br.readLine().split(" ");
            int X=(int)Long.parseLong(str[0]);
            int Y=(int)Long.parseLong(str[1]);
            String path=str[2];
            int i;
            for(i=1;i<=path.length();i++){
                char ch=path.charAt(i-1);
                if(ch=='S') Y--;
                else if(ch=='N') Y++;
                else if(ch=='E') X++;
                else if(ch=='W') X--;
                if(i>=Math.abs(X)+Math.abs(Y)){
                    break;
                }
            }
            String ans;
            if(i<=path.length()) ans=""+i;
            else ans="IMPOSSIBLE";
            sb.append("Case #"+mm+": "+ans+"\n");
        }
        System.out.print(sb);
    }
}
            