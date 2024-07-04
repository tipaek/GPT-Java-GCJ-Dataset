import java.util.*;
import java.io.*;
public class Solution
{
	public static void main (String[] args)throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int l=1;l<=t;l++)
        {
            String s=br.readLine();
            StringBuffer ans=new StringBuffer();
            for(int j=0;j<(int)(s.charAt(0)-48);j++)
            ans.append("(");
            ans.append(s.charAt(0));
            for(int i=1;i<s.length();i++)
            {
                int x=(int)(s.charAt(i)-s.charAt(i-1));
                if(x<0)
                {
                    x*=-1;
                    for(int j=0;j<x;j++)
                    ans.append(")");
                    ans.append(s.charAt(i));
                }
                else
                {
                    for(int j=0;j<x;j++)
                    ans.append("(");
                    ans.append(s.charAt(i));
                }
            }
            for(int j=0;j<(int)(s.charAt(s.length()-1)-48);j++)
            ans.append(")");
            System.out.println("Case #"+l+": "+ans);
        }
	}
}