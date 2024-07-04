import java.io.*;
import java.util.*;

public class Solution 
{

	public static void main(String[] args) 
	{
		
		Scanner sc= new Scanner (System.in);
		int test= sc.nextInt();
		
		for(int g=0;g<test;g++)
		{
			int n=sc.nextInt();
			String ans=""; 
			int inputs=0;
			ArrayList<Integer> cstart= new ArrayList<Integer>();
			ArrayList<Integer> cend= new ArrayList<Integer>();
			ArrayList<Integer> jstart= new ArrayList<Integer>();
			ArrayList<Integer> jend= new ArrayList<Integer>();
			boolean imp=false;
			for(int x=0;x<n;x++)
			{
				if(x==0)
				{
					cstart.add(sc.nextInt());
					cend.add(sc.nextInt());
					inputs++;
					ans+="C";
				}
				else
				{
					int beg=sc.nextInt();
					int end=sc.nextInt();
					inputs++;
					if(checkavailability(cstart, cend, beg, end))
					{
						cstart.add(beg);
						cend.add(end);
						ans+="C";
					}
					else if(checkavailability(jstart, jend, beg, end))
					{
						jstart.add(beg);
						jend.add(end);
						ans+="J";
					}
					else
					{
						ans="IMPOSSIBLE";
						while(inputs<n)
						{
						    sc.nextInt();
						    sc.nextInt();
						    inputs++;
						}
						//System.out.println("occured");
						break;
					}
				}
			}
			System.out.println("Case #" + (g+1) + ": "+ ans);			
		}

	}
	
	public static boolean checkavailability(ArrayList<Integer> starts, ArrayList<Integer> ends, int start, int end)
	{
		for(int x=0;x<starts.size();x++)
		{
			if(start>=starts.get(x)&&start<ends.get(x))
			{
				//System.out.println("occured");
				//System.out.println(starts.get(x));
				//System.out.println(ends.get(x));
				return false;
			}
			if(end>starts.get(x)&&end<=ends.get(x))
			{
				return false;
			}
			if(start<=starts.get(x)&&end>=ends.get(x))
			{
				return false;
			}
			if(start>=starts.get(x)&&end<=ends.get(x))
			{
				return false;
			}
		}
		return true;
	}

}
