import java.io.*;
import java.util.*;
public class Solution {
	public static class NOde{
		
		public long x,y,k;
		public String str="";
		public NOde(long x,long y,long k,String str)
		{
			this.k=k;
			this.x=x;
			this.y=y;
			this.str=str;
		}
	}
public static class place{
		
		public long x,y;
		public place(long x,long y)
		{
			
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int k=s.nextInt();
		for(int t=1;t<=k;t++)
		{
			long x=s.nextLong()	;
			long y=s.nextLong();
			int arrx[]= {0,0,1,-1};
			int arry[]= {1,-1,0,0};
			LinkedList<NOde> queuq=new LinkedList<>();
			queuq.push(new NOde(0,0,0,""));
			HashMap<place,Boolean> seen=new HashMap<>();
			boolean f=false;
			String path="";
			while(queuq.isEmpty()==false)
			{
				NOde temp=queuq.removeFirst();
				long step=temp.k+1;
				String cc=temp.str;
				seen.put(new place(temp.x,temp.y), true);
				if(x==temp.x&&y==temp.y)
				{
					path=temp.str;
					f=true;
					break;
					
				}
				if(step>=(long)Math.pow((double)x+y,(double)4 ))
					break;
				for(int i=0;i<4;i++)
				{
					long cx=temp.x+(arrx[i]*((long)1<<temp.k));
					long cy=temp.y+(arry[i]*((long)1<<temp.k));
					Character p=null;
					if(i==0){
						p='N';
						
						
					}
					else if(i==1)
					{
						p='S';
					}
					else if(i==2)
					{
						p='E';
					}
					else
						p='W';
					
					if((cx<=1000000000 && cx>=-1000000000) && (cy<=1000000000 && cy>=-1000000000))
					{
						if(seen.get(new place(cx,cy))==null)
								{
							seen.put(new place(cx,cy),true);
							queuq.addLast(new NOde(cx,cy,step,cc+p));
							
								}
						else
							{continue;}
						
					}
					
				}
				
				
						
			}
			if(f)
				System.out.println("Case #"+t+": "+path);
			else
				System.out.println("Case #"+t+": IMPOSSIBLE");
				
		}
	
	}

}