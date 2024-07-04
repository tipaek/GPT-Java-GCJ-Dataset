import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Solution
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		sc.nextLine();
		outer:for(int t=1;t<=test;t++)
		{
			int n= sc.nextInt();
			Time arr[] = new Time[n];
			for(int i=0;i<n;i++)
			{
				arr[i] = new Time();
				arr[i].id = i;
				arr[i].start = sc.nextInt();
				arr[i].end = sc.nextInt();
			}
			Arrays.sort(arr);
			ArrayList<Time> c = new ArrayList<>();
			ArrayList<Time> j = new ArrayList<>();
			c.add(arr[0]);
			
			for(int i=1;i<n;i++)
			{
				if(arr[i].start < c.get(c.size()-1).end)
					j.add(arr[i]);
				else
					c.add(arr[i]);
			}
			for(int i=0;i<j.size()-1;i++)
			{
				if(j.get(i+1).start < j.get(i).end)
				{
					System.out.println("Case #"+t+": "+"IMPOSSIBLE");
					continue outer;
				}
			}
			char aa[] = new char[n];
			for(Time temp : c)
				aa[temp.id]='C';
			for(Time temp : j)
				aa[temp.id]='J';
			String ans = new String(aa);
			System.out.println("Case #"+t+": "+ans);
		}
	}
}
class Time implements Comparable<Time>
{
	int start;
	int end;
	int id;
	@Override
	public int compareTo(Time o) 
	{
		return this.start-o.start;
	}
}