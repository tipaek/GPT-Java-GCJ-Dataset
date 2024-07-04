

import java.util.*;
import java.lang.*;
import java.io.*;


class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
        int o=1;
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t!=0)
        {String s="";
            String p=sc.next();
            char m='0';
            
            int count=0;
            
            for(int j=0;j<p.length();j++)
            {
                char x=p.charAt(j);

                if(x>m)
                {
                  int a= (Integer.parseInt(String.valueOf(x))-Integer.parseInt(String.valueOf(m)));
                    for(int i=0;i<a;i++)
                    s=s+"(";
                    s=s+x;
                    m=x;
                }
                else if(x<m)
                {
                int a= (Integer.parseInt(String.valueOf(x))-Integer.parseInt(String.valueOf(m)))*(-1);
                    for(int i=0;i<a;i++)
                    s=s+")";
                    s=s+x;
                    m=x;
                    
                }
                else
                {
                    s=s+x;
                m=x;
                }
                
            }
            for(int i=0;i<Integer.parseInt(String.valueOf(p.charAt(p.length()-1)));i++)
            s=s+")";
            
            
            System.out.println("Case #"+o+":"+" "+s);
            o++;
            t--;
        }
	}
}