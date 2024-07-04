import java.util.*;

class pair
{
	int s,e;
	
	pair(int s,int e)
	{
		this.s=s;
		this.e=e;
	}
}

class Solution{
	
    public static void main(String[] args)
    {
        Scanner sin= new Scanner(System.in);
        int t = sin.nextInt();
		HashMap<Character,ArrayList<pair>> h=new HashMap<Character,ArrayList<pair>>();
		
		h.put('C',new ArrayList<pair>());
		h.put('J',new ArrayList<pair>());
		int t1=1;
		
		while(t-->0)
		{
			h.get('C').clear();
			h.get('J').clear();
			
			int n=sin.nextInt();
			int s,e;
			String ss="";
			boolean g=true;
			
			for(int j=0;j<n;j++)
			{
				s=sin.nextInt();
				e=sin.nextInt();
				
				pair p;
				boolean f=true;
				
				if(g)
				{
				ArrayList<pair> a=h.get('C');
				
				for(int i=0;i<a.size();i++)
				{
					p=a.get(i);
					if(!(p.s>=e||p.e<=s))
					{
						f=false;
						break;
					}	
				}
				
				if(f)
				{
					h.get('C').add(new pair(s,e));
					ss+="C";
				}
				else
				{
					f=true;
					
					ArrayList<pair> b1=h.get('J');
				
					for(int i=0;i<b1.size();i++)
					{
						p=b1.get(i);
						if(!(p.s>=e||p.e<=s))
						{
							f=false;
							break;
						}
					}
					
					if(f)
					{
						h.get('J').add(new pair(s,e));
						ss+="J";
					}
					else
					{
						g=false;
						ss="IMPOSSIBLE";
					}
				}
				//new pair(s,e);
				}
			}
			
			System.out.println("Case #"+t1+": "+ss);
			t1++;
		}
	}
}