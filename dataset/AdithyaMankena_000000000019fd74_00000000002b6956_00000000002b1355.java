import java.util.*;
class Solution
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T;t++)
		{
			int N=sc.nextInt();
			ArrayList<ArrayList<Integer>> al=new ArrayList<ArrayList<Integer>>();
			ArrayList<ArrayList<Integer>> C=new ArrayList<ArrayList<Integer>>();
			ArrayList<ArrayList<Integer>> J=new ArrayList<ArrayList<Integer>>();
			int[] ch=new int[N];
			boolean flag=false;
			String str="";
		    int n=0;
			for(int i=0;i<N;i++)
			{
				ArrayList<Integer>  a=new ArrayList<Integer>();
				int k=0;	
				while(k<2)
				{
					a.add(sc.nextInt());
					k++;	
				}
				a.add(n);
				n++;
				al.add(a);
			}
			Collections.sort(al, new Comparator<ArrayList<Integer>>() 
			{    
        			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) 
				{
            				return o1.get(0).compareTo(o2.get(0));
        			}               
			});
			C.add(al.get(0));
			ch[al.get(0).get(2)]=1;
			J.add(al.get(1));
			ch[al.get(1).get(2)]=0;
			for(int i=2;i<al.size();i++)
			{
					if(al.get(i).get(0)>=C.get(C.size()-1).get(1))
					{
						C.add(al.get(i));
						ch[al.get(i).get(2)]=1;
					}
					else if(al.get(i).get(0)>=J.get(J.size()-1).get(1))
					{
						J.add(al.get(i));
						ch[al.get(i).get(2)]=0;
					}
					else
					{
						flag=true;
						break;
					}
			}
			if(!flag)
			{
				for(int k=0;k<ch.length;k++)
				{
					if(ch[k]==1)
						str=str+"C";
					else
						str=str+"J";
				}
				System.out.println("Case"+" "+"#"+t+":"+" "+str);
			}
			else
				System.out.println("Case"+" "+"#"+t+":"+" "+"IMPOSSIBLE");
			
		}
	}
}