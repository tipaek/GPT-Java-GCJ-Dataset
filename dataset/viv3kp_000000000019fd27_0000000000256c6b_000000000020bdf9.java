
import java.io.*;
import java.util.*;
class Solution{
	
	public static void main(String args[])throws IOException
	{
		Scanner sc=new Scanner(System.in);
		
		
		int test=sc.nextInt();
		sc.nextLine();
		int caseNo=1;
		
		
		
		StringBuilder res=new StringBuilder("");
		while(test-->0)
		{
			int cam=0;
			
			int jam=0;
			
			StringBuilder str=new StringBuilder("");
			int n=sc.nextInt();
			boolean imp=false;
			
			List<Ob> arr=new ArrayList();
			
			while(n-->0)
			{
				
				
				int a=sc.nextInt();
				int b=sc.nextInt();
				arr.add(new Ob(a,b));
			}
				
			Comparator<Ob> ok =new Comparator<Ob>()
			{
				public int compare(Ob a,Ob b)
				{
					return a.start-b.start;
				}
			};
			
			Collections.sort(arr,ok);
			
			for(int i=0;i<arr.size();i++)
			{
				if(cam <= arr.get(i).start) 
				{
					str.append("C");
					cam=arr.get(i).end;
				}
				else if (jam <= arr.get(i).start)
				{
					str.append("J");
					jam=arr.get(i).end;
				}
				else
				{
					imp=true;
					break;
				}
				
			}
			
			if(imp)
			{
				res.append("Case #"+caseNo+": IMPOSSIBLE\n");
			}
			else
			{
				res.append("Case #"+caseNo+": "+str.toString()+"\n");
			}
			
			
			caseNo++;
			
			
			
		}
		
		System.out.println(res.toString());
		
	}
	
}

class Ob 
{
	int start;
	int end;
	Ob(int s,int e)
	{
		start=s;
		end=e;
	}
}