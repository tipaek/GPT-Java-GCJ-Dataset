import java.util.*;
class Times
{
	int start,end;
	Times(int a,int b)
	{
		start=a;
		end=b;
	}
	public String toString()
	{
		return this.start+" "+this.end;
	}
}
class Frees
{
	char ch;
	int attime;
	Frees(char c,int end)
	{
		ch=c;
		attime=end;
	}
	public String toString()
	{
		return this.ch+" "+this.attime;
	}
}
class Solution
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=0;t<T;t++)
		{
			int n=sc.nextInt();
			ArrayList<Times> times=new ArrayList<>();
			ArrayList<Integer> al=new ArrayList<>();
			for(int i=0;i<n;i++)
			{
				int a=sc.nextInt();
				al.add(a);
				Times ti=new Times(a,sc.nextInt());
				times.add(ti);
			}
			Collections.sort(times,new Comparator<Times>(){
				@Override
				public int compare(Times t1,Times t2)
				{
					return t1.start-t2.start;
				}
			});
			int[] arr=new int[n];
			for(int i=0;i<al.size();i++)
			{
				for(int j=0;j<times.size();j++)
				{
					Times ti=times.get(j);
					if(al.get(i)==ti.start)
					{
						arr[i]=j;
						break;
					}
				}
			}
			ArrayList<Character> avail=new ArrayList<>();
			avail.add('C');
			avail.add('J');
			// System.out.println(avail);
			String sol="";
			ArrayList<Frees> free=new ArrayList<>();
			for(int i=0;i<times.size();i++)
			{
				Times ti=times.get(i);
				for(int j=0;j<free.size();j++)
				{
					Frees f=free.get(j);
					if(f.attime<=ti.start)
					{
						avail.add(f.ch);
						free.remove(f);
					}
				}
				if(avail.size()==0)
				{
					sol="IMPOSSIBLE";
					break;
				}
				else
				{
					Collections.sort(avail);
					sol+=avail.get(0);
					Frees f=new Frees(avail.get(0),ti.end);
					avail.remove(0);
					free.add(f);
				}
			}
			if(sol.equals("IMPOSSIBLE"))
			{
				System.out.println("Case #"+(t+1)+": "+sol);
			}
			else
			{
				String res="";
				for(int k=0;k<n;k++)
				{
					res+=sol.charAt(arr[k]);
				}
				System.out.println("Case #"+(t+1)+": "+res);
			}
		}
	}
}
/*
4
3
360 480
420 540
600 660
3
0 1440
1 3
2 4
5
99 150
1 100
100 301
2 5
150 250
2
0 720
720 1440
*/