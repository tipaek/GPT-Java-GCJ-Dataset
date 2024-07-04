import java.io.*;
import java.util.*;
import java.math.*;

class Solution
{
	public static void main(String []args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter w = new PrintWriter(System.out);
		int tc=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=tc;++t)
		{
			int n=Integer.parseInt(br.readLine());
			ArrayList<Interval> al = new ArrayList<>();
			for(int i=0;i<n;++i)
			{
				String it[] =br.readLine().split(" ");
				int start=Integer.parseInt(it[0]);
				int end=Integer.parseInt(it[1]);
				al.add(new Interval(start,end,i));
			}
			Collections.sort(al,new sortByStart());
			
			char ans[]= new char[n];
			int jfree=0,cfree=0;
			boolean isPossible=true;
			for(int i=0;i<n;++i)
			{
				Interval it = al.get(i);
				
				if(it.start>=jfree)
				{
					ans[it.index]='J';
					jfree=it.end;
				}
				else if(it.start>=cfree)
				{
					ans[it.index]='C';
					cfree=it.end;
				}
				else
				{
					isPossible=false;
					break;
				}
			}
			
			w.print("Case #"+t+": ");
			if(isPossible) w.println(String.valueOf(ans));
			else w.println("IMPOSSIBLE");
		}
		
		w.flush();
		w.close();
	}
}

class Interval
{
	int start,end,index;
	Interval(int start, int end, int index)
	{
		this.start=start;
		this.end=end;
		this.index=index;
	}
}

class sortByStart implements Comparator<Interval>
{
	public int compare(Interval i1, Interval i2)
	{
		return i1.start-i2.start;
	}
}