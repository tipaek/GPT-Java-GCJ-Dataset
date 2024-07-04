import java.lang.*;
import java.util.*;

public class Solution{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++)
		{
			int n=s.nextInt();
			String str="C";
			int stc=s.nextInt();
			int endc=s.nextInt();
			int stj=0;
			int endj=0;
			
			for(int j=1;j<n;j++)
			{
				int st1=s.nextInt();
				int end1=s.nextInt();
				if((st1>stc && st1<endc) || (end1>stc && end1<endc))
				{ 
					if((st1>stj && st1<endj) || (end1>stj && end1<endj))
					{
						str="IMPOSSIBLE";
						break;
					}
					
						str+='J';
						if(st1<stj)
						{
							stj=st1;
						}
						if(end1>endj)
						{
							endj=end1;
						}
					
				}
				else if((st1>stj && st1<endj) || (end1>stj && end1<endj))
				{ 
					if((st1>stc && st1<endc) || (end1>stc && end1<endc))
					{
						str="IMPOSSIBLE";
						break;
					}
					
						str+='C';
						if(st1<stc)
						{
							stc=st1;
						}
						if(end1>endj)
						{
							endc=end1;
						}
					
				}
					
				else 
				{
					if(str.charAt(j-1)=='C')
					{
						str+='C';
						if(st1<stc)
						{
							stc=st1;
						}
						if(end1>endc)
						{
							endc=end1;
						}
					}
					else
					{
						str+='J';
						if(st1>stj)
						{
							stj=st1;
						}
						if(end1>endj)
						{
							endj=end1;
						}
					}
				}
				
				
			}
			System.out.println("Case #"+(i+1)+": "+str);
		}
	}

}
