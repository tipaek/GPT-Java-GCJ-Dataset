import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args)
	{
		Scanner in=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T=in.nextInt();
		for(int i=1;i<=T;i++)
		{
			String S=in.next();
			String opS="";
			String opE="";
			int start=0,end=0;
			int startpos=0,endpos=S.length()-1;
			char c=S.charAt(startpos);  
			start=Integer.parseInt(String.valueOf(c));
			c=S.charAt(endpos);  
			end=Integer.parseInt(String.valueOf(c));
			for(int j=0;j<start;j++)
				opS+="(";
			for(int j=0;j<end;j++)
				opE+=")";
			while(startpos<endpos)
			{				
				c=S.charAt(startpos);  
				String str=String.valueOf(c);
				int t=Integer.parseInt(String.valueOf(c));
				if(t>start)
				{
					for(int j=start;j<t;j++)
						opS+="(";
					start=t;
				}
				else if(t<start)
				{
					for(int j=t;j<start;j++)
						opS+=")";
					start=t;
				}				
				opS+=str;
				c=S.charAt(endpos);  
				str=String.valueOf(c);
				t=Integer.parseInt(String.valueOf(c));
				if(t>end)
				{
					for(int j=end;j<t;j++)
						opE=")"+opE;
					end=t;
					
				}
				else if(t<end)
				{
					for(int j=t;j<end;j++)
						opE="("+ opE;
					end=t;
				}
					opE=str+opE;
					startpos++;
					endpos--;
				
			}
				
			if(startpos==endpos)
			{
				
				c=S.charAt(endpos);  
				String str=String.valueOf(c);
				int t=Integer.parseInt(String.valueOf(c));
				if(start>t)
				{
					for(int j=t;j<start;j++)
						opS+=")";
						
				}
				else if(start<t)
				{
					for(int j=start;j<t;j++)
						opS+="(";
				}	
				if(end>t)
				{
					for(int j=t;j<end;j++)
						opE="("+opE;
						
				}
				else if(end<t)
				{
					for(int j=start;j<end;j++)
						opE=")"+ opE;
				}	
				
				opS+=str + opE;;
			}
			else
			{
				if(start>end)
				{
					for(int j=end;j<start;j++)
						opS+=")";
						
				}
				else if(start<end)
				{
					for(int j=start;j<end;j++)
						opE="("+opE;
				}				
				opS+=opE;
			}

			System.out.println("Case #" + i + ": "  +opS);    		    
			}
			
			

	}
}