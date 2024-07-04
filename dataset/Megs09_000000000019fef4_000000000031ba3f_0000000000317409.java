import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++)
        {   String s[]=br.readLine().split(" ");
            int x=Integer.parseInt(s[0]);
            int y=Integer.parseInt(s[1]);
            String str=s[2];
            int y1=0;
            int len=str.length();
            if(x>len)
            {   System.out.print("Case #"+i+": IMPOSSIBLE\n");
                continue;
            }
            int j=0;
            for(;j<x;j++)
            {   if(str.charAt(j)=='N')
                    y++;
                else
                    y--;
            }
            int cnt=0;
            for(;j<len;j++)
            {   cnt++;
                if(str.charAt(j)=='N')
                    y++;
                else
                    y--;
                if(y==y1)
                    break;
                else if(y>0)
                    y1++;
                else if(y<0)
                    y1--;
                else
                {   if(y1>0)
                        y1--;
                    else
                        y1++;
                }
            }
            System.out.print("Case #"+i+": ");
            if(y==y1)
                System.out.print(x+cnt+"\n");
            else
                System.out.print("IMPOSSIBLE\n");
        }
    }
}