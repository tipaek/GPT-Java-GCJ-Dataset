
import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T;t++)
		{
			String str=sc.next();
			
			ArrayList<Character> ch=new ArrayList<Character>();
			if(str.length()==1)
			{
				int v=Integer.parseInt(String.valueOf(str.charAt(0)));
				if(v>0)
				{
					for(int j=0;j<v;j++)
						ch.add('(');
					ch.add((char)(v+'0'));
					for(int j=0;j<v;j++)
						ch.add(')');
				}
				else
				{
					ch.add((char)(v+'0'));
				}
				System.out.print("Case "+"#"+t+":"+" ");
				for(int i=0;i<ch.size();i++)
				{
					System.out.print(ch.get(i)+"");
				}
				System.out.println();
				continue;
				
					
			}
			
			for(int i=0;i<str.length();i++)
			{
				if(i==0)
				{
					int v=Integer.parseInt(String.valueOf(str.charAt(i)));
					if(v>0)
					{
						for(int j=0;j<v;j++)
							ch.add('(');
						ch.add((char)(v+'0'));
					}
					else
					{
						ch.add((char)(v+'0'));
					}
					continue;
				}
				
				int nextv=Integer.parseInt(String.valueOf(str.charAt(i)));
				int prevv=Integer.parseInt(String.valueOf(str.charAt(i-1)));
				if(i==str.length()-1)
				{
					if(nextv>prevv)
					{
						int diff=nextv-prevv;
						for(int j=0;j<diff;j++)
						{
							ch.add('(');
						}
						ch.add((char)(nextv+'0'));
						
						for(int j=0;j<nextv;j++)
						{
							ch.add(')');
						}
					}
					else if(nextv<prevv)
					{
						int diff=prevv-nextv;
						for(int j=0;j<diff;j++)
						{
							ch.add(')');
						}
						ch.add((char)(nextv+'0'));
						for(int j=0;j<nextv;j++)
						{
							ch.add(')');
						}
					}
					else if(nextv==prevv)
					{
						ch.add((char)(nextv+'0'));
						for(int j=0;j<nextv;j++)
						{
							ch.add(')');
						}
					}
					
					
				}
				
				else if(nextv>prevv)
				{
					int diff=nextv-prevv;
					for(int j=0;j<diff;j++)
					{
						ch.add('(');
					}
					ch.add((char)(nextv+'0'));
				}
				else if(nextv<prevv)
				{
					int diff=prevv-nextv;
					for(int j=0;j<diff;j++)
					{
						ch.add(')');
					}
					ch.add((char)(nextv+'0'));
				}
				else if(nextv==prevv)
				{
					ch.add((char)(nextv+'0'));
				}
				
			}
			System.out.print("Case "+"#"+t+":"+" ");
			for(int i=0;i<ch.size();i++)
			{
				System.out.print(ch.get(i)+"");
			}
			System.out.println();
			
			
		}
	}

}
