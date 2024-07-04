import java.io.*;
import java.util.*;

class Solution
{
	static int r=0;
	
	public static String addP(String s)
	{
		return "("+s+")";
	}
	
	public static String solve(String s,int d,int limit)
	{
		if(s.length()==0)
		{
			return "";
		}
		
		int a=-1,f=0;
		String st="";
		int sm=10;
		int y=Character.getNumericValue(s.charAt(0));
		for(int i=0;i<s.length();i++)
		{
			y=Character.getNumericValue(s.charAt(i));
			if(y<sm)
			{
				sm=y;
			}
			if(y>d && f==0)
			{
				a=i;
				f=1;
			}
			else
			if(y==d)
			{
				if(a!=-1 && f==1)
				{
					st+=solve(s.substring(a,i),d+1,d)+s.charAt(i);
					f=0;
					a=-1;
				}
				else
					st+=s.charAt(i);
			}

			if(i==s.length()-1 && y>d)
			{
				if(a!=-1 && f==1)
				{
					st+=solve(s.substring(a,i+1),d+1,d);
				}
			}
		}
		
		
		int j=d-limit;
		while(j>0)
		{
			st=addP(st);
			j--;
			r++;
		}
		return st;
	}
	
    public static void main(String agrs[]) throws Exception
    {
        try
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int T=Integer.parseInt(br.readLine());
            for(int t=1;t<=T;t++)
            {
                String s=(br.readLine());
                String st=solve(s,0,0);
                System.out.println("Case #"+t+": "+st);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
}