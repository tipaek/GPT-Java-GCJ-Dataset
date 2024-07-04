import java.util.*;

class pair
{int st;
int en;
pair(int st, int en){
	this.en=en;
	this.st=st;
	
}
	}



class my implements Comparator<pair>{
	public int compare(pair p1,pair p2)
	{
		return  p1.st-p2.st;
		
	}
	
	
}



public class Solution{
	
	
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		
		int t=in.nextInt();
		int ind=1;
		while(t-->0) {
		int n=in.nextInt();
		pair a[]=new pair[n];
		pair bb[]=new pair[n];
		for(int i=0;i<n;i++) {
			
			int st=in.nextInt();
			int en=in.nextInt();
			
			a[i]=new pair(st,en);
			bb[i]=new pair(st,en);
		}
		Arrays.sort(a,new my());
		
		
			
			
		HashSet<String>hs1=new HashSet<>();
		HashSet<String>hs2=new HashSet<>();
		int en1=0;
		int s1,en2=0,st2,f=0;
		
		for(int i=0;i<n;i++)
		{int aa=a[i].st;
		int b=a[i].en;
			if(aa>=en1)
			{
				en1=b;
				String s=String.valueOf(aa)+"#"+String.valueOf(b);
				hs1.add(s);
				
			}
			else {
				
				if(aa>=en2)
				{
					en2=b;
					String s=String.valueOf(aa)+"#"+String.valueOf(b);
					hs2.add(s);
				}
				
				else {
					f=1;
					break;
				}
				
				
			}
			
		}
			 
			 StringBuilder sb=new StringBuilder();
			 
			if(f==1)
			sb.append("IMPOSSIBLE");
			else {
				
				for(int i=0;i<n;i++)
				{
					String s=String.valueOf(bb[i].st)+"#"+String.valueOf(bb[i].en);
					if(hs1.contains(s))
						sb.append('J');
					else
						sb.append('C');
				}
			}
		
		
		
		System.out.println("Case"+" "+"#"+ind+":"+" "+sb.toString());
		ind++;
		
	}
	
	
	}
}