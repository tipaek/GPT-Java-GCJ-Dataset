import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution 
{
	static class Activity implements Comparable<Activity>
	{
		public int start;
		public int end;
		public String assignedto;
		
		public Activity(int start,int end)
		{
			this.start=start;
			this.end=end;
		}
		
		@Override
		public int compareTo(Activity o) {
			if(this.end>o.end)
			{
				return 1;
			}
			else if(this.end==o.end)
			{
				return 0;
			}
			else
			{
				return -1;
			}
		}
		
		/*@Override
		public boolean equals(Object obj)
		{
			Activity activity=(Activity)obj;
			if(activity.start==this.start&&activity.end==this.end)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}*/
		
	}
	
	
	public static void main(String as[])
	{
		Scanner scan=new Scanner(System.in);
		int T=scan.nextInt();
		for(int i=0;i<T;i++)
		{
			LinkedList<Activity> list=new LinkedList<Activity>();
			int time=scan.nextInt();
			for(int j=0;j<time;j++)
			{
				Activity activity=new Activity(scan.nextInt(),scan.nextInt());
				list.add(activity);
			}
			String op=assignActivity(list);
			System.out.println("Case #"+(i+1)+": "+op);
			
		}
	}
	
	public static String assignActivity(LinkedList<Activity> activity)
	{
		LinkedList<Activity> order=new LinkedList<Activity>(activity);
		ArrayList<Activity> J=new ArrayList<Activity>();
		ArrayList<Activity> C=new ArrayList<Activity>();		
		Collections.sort(activity);
		//assigning activites to C
		int index=0;
		Iterator<Activity> iter=activity.iterator();
		while(iter.hasNext())
		{
			if(index==0)
			{
				C.add(iter.next());
				iter.remove();
			}
			else
			{
				Activity act=iter.next();
				if(C.get(C.size()-1).end>act.start)
				{
					index++;
					continue;
				}
				else
				{
					C.add(act);
					iter.remove();
				}
			}
			index++;
		}
		//assigning activites to J
		index=0;
		iter=activity.iterator();
		while(iter.hasNext())
		{
			if(index==0)
			{
				J.add(iter.next());
				iter.remove();
			}
			else
			{
				Activity act=iter.next();
				if(J.get(J.size()-1).end>act.start)
				{
					index++;
					continue;
				}
				else
				{
					J.add(act);
					iter.remove();
				}
			}
			index++;
		}
		
		if(activity.size()>0)
		{
			return "IMPOSSIBLE";
		}
		else
		{
			String output="";
			Iterator<Activity> it=order.iterator();
			while(it.hasNext())
			{
				Activity a=it.next();
				if(J.contains(a))
				{
					output=output+"J";
				}
				if(C.contains(a))
				{
					output=output+"C";
				}
			}
			return output;
		}
	}

}
