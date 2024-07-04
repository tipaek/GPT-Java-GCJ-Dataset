import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0)
        {
            String str = br.readLine();
            int close_rem=0;
            StringBuilder answer = new StringBuilder();
            for(int i=0;i<str.length();i++)
            {
              if((str.charAt(i)-'0')-close_rem>=0)
              {
                 for(int j=0;j<((str.charAt(i)-'0')-close_rem);j++)
                 answer.append("(");
                 close_rem+=((str.charAt(i)-'0')-close_rem);
              }
              else
              {
                for(int j=0;j<(close_rem-(str.charAt(i)-'0'));j++)
                 answer.append(")");  
                 close_rem-=(close_rem-(str.charAt(i)-'0'));
              }
              answer.append(str.charAt(i));
            }
            for(int j=0;j<close_rem;j++)
                 answer.append(")");
                 System.out.println(answer);
        }
	}
}
