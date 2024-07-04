import java.util.*;
import java.io.*;
class Solution
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for(int a=0;a<T;a++)
		{
			String str = "C";
		int n = sc.nextInt();
		int[] start = new int[n];
		int[] end = new int[n];
		int cam = 0;
		int jam =0;
		for(int i=0;i<n;i++)
		{
			start[i]=sc.nextInt();
			end[i]=sc.nextInt();
		}
		Solution obj = new Solution();
		String pri = obj.Schedule(start,end,n,str);
		System.out.println("case #"+(a+1)+": "+pri);
	}
	}
	
	
	String Schedule(int[] start, int[] end, int n, String str)
	{
	 int cam=end[0];int jam=0;
		for(int i=1;i<n;i++ )
		{
			if(str.charAt(str.length()-1)=='C'){
			if(start[i]-cam>=0)
			{
				cam = end[i];
				str=str+'C';
			}
			else if(start[i]-jam>=0)
			{
				jam = end[i];
				str=str+'J';
			}}
			else
			{
				if(start[i]-jam>=0)
			{
				jam = end[i];
				str=str+'J';
			}
			else if(start[i]-cam>=0)
			{
				cam = end[i];
				str=str+'C';
			}
			}
		}
			
			
			
			if(str.length()!=n)
			{
				return "IMPOSSIBLE";
			}
			return str;
	}
	

}