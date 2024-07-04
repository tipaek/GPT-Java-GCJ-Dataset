
import java.io.*;
import java.util.*;
public class Solution {
	
	public static void main(String args[])throws IOException
	{
		Scanner sc=new Scanner(System.in);
		
		
		int test=sc.nextInt();
		int caseNo=1;
		
		
	
		while(test-->0)
		{
			int cam=0;
			
			int jam=0;
			
			StringBuilder str=new StringBuilder("");
			int n=sc.nextInt();
			boolean imp=false;
			
			List<Ob> arr=new ArrayList<Ob>();
			List<Ob> orignal=new ArrayList<Ob>();
			
			Map<String,String> map=new HashMap();
			
			while(n-->0)
			{
				
				
				int a=sc.nextInt();
				int b=sc.nextInt();
				arr.add(new Ob(a,b));
				
				orignal.add(new Ob(a,b));
				
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
					if(map.putIfAbsent(arr.get(i).start+" "+arr.get(i).end,"C")!=null)
						map.put(arr.get(i).start+"1"+arr.get(i).end,"C");
					cam=arr.get(i).end;
				}
				else if (jam <= arr.get(i).start)
				{
					if(map.putIfAbsent(arr.get(i).start+" "+arr.get(i).end,"J")!=null)
						map.put(arr.get(i).start+"1"+arr.get(i).end,"J");
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
				System.out.println("Case #"+caseNo+": IMPOSSIBLE");
			}
			else
			{
				Set<String > set=new HashSet();
				for(int i=0;i<orignal.size();i++)
				{
					String find="";
					if(set.contains(orignal.get(i).start+" "+orignal.get(i).end))
						find=orignal.get(i).start+"1"+orignal.get(i).end;
					else
					{
						find=orignal.get(i).start+" "+orignal.get(i).end;
						set.add(orignal.get(i).start+" "+orignal.get(i).end);
					}
					
				str.append(	map.get(find));
				}
				
				System.out.println("Case #"+caseNo+": "+str.toString());
			}
			
			
			caseNo++;
			
			
			
		}
		
		
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