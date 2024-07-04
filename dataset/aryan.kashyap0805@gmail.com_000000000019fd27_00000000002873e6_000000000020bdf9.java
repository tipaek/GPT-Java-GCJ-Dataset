import java.util.*;

public class Solution
{
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int t1=0;t1<t;t1++)
		{
			
			int n = sc.nextInt();
			ArrayList<TimeManagement> al = new ArrayList<TimeManagement>();
			for(int i=0;i<n;i++)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				al.add(new TimeManagement(a,b,i));
			}
			Collections.sort(al);
			int j = -1;
			int c = -1;
			boolean impossible = false;
			for(int i=0;i<al.size();i++)
			{
				TimeManagement time = (TimeManagement)al.get(i);
				int start = time.getStartingTime();
				int endingTime = time.getEndingTime();
				if(start >= j)
				{
					j = endingTime;
					time.setParent("J");
				}
				else if(start >= c)
				{
					c = endingTime;
					time.setParent("C");
				}
				else 
				{
					impossible = true;
					break;
				}
			}
			System.out.print("Case #" +(t1+1)+": ");
			if(impossible)
			{
				System.out.print("IMPOSSIBLE");
			}
			else
			{
				String []arr = new String[n];
				for(int i=0;i<al.size();i++)
				{
					TimeManagement time = (TimeManagement)al.get(i);
					arr[time.getIndex()] = time.getParent();
				}
				for(int i=0;i<arr.length;i++)
				{
					System.out.print(arr[i]);
				}
			}
			System.out.println("");
				
		}
		
	}
}

class TimeManagement implements Comparable 
{
	private int startingTime;
	private int endingTime;
	private String parent;
	private int index;
	
	public TimeManagement(int startingTime, int endingTime, int index)
	{
		this.startingTime = startingTime;
		this.endingTime = endingTime;
		this.index = index;
	}
	
	public String getParent()
	{
		return this.parent;
	}
	
	public int getIndex()
	{
		return this.index;
	}
	
	public void setParent(String parent)
	{
		this.parent = parent;
	}
	
	public int getStartingTime()
	{
		return this.startingTime;
	}
	
	public int getEndingTime()
	{
		return this.endingTime;
	}

    public int compareTo(Object object) {
		TimeManagement time = (TimeManagement)object;
        int start = time.getStartingTime();
		int end = time.getEndingTime();
		
		if(start > this.startingTime)
		{
			return -1;
		}
		else if(start == this.startingTime)
		{
			if(end > this.endingTime)
			{
				return -1;
			}
			else if(end < this.endingTime)
			{
				return 1;
			}
		}
		else if(start < this.startingTime)
		{
			return 1;
		}
		return 0;

    }
}
