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
			ArrayList<Integer> starts= new ArrayList<Integer>();
			ArrayList<Integer> indexes= new ArrayList<Integer>();
			String[] answers= new String[n];
			ArrayList<Integer> ends= new ArrayList<Integer>();
			ArrayList<Integer> cstart= new ArrayList<Integer>();
			ArrayList<Integer> cend= new ArrayList<Integer>();
			ArrayList<Integer> jstart= new ArrayList<Integer>();
			ArrayList<Integer> jend= new ArrayList<Integer>();
			int z=0;
			for(int x=0;x<n;x++)
			{
				if(x==0)
				{
					starts.add(sc.nextInt());
					ends.add(sc.nextInt());
					indexes.add(z);
					z++;
				}
				else
				{
					int curr=sc.nextInt();
					for(int a=0;a<starts.size();a++)
					{
						if(curr<=starts.get(a))
						{
							starts.add(a, curr);
							ends.add(a, sc.nextInt());
							indexes.add(a, z);
							z++;
							break;
						}
					}
					if(curr>starts.get(starts.size()-1))
					{
						starts.add(curr);
						ends.add(sc.nextInt());
						indexes.add(z);
						z++;
					}
				}
			}
			boolean imp=false;
			for(int x=0;x<n;x++)
			{
				if(x==0)
				{
					cstart.add(starts.get(0));
					cend.add(ends.get(0));
					//System.out.println(cstart.get(0));
					//inputs++;
					answers[indexes.get(x)]="C";
				}
				else
				{
					int beg=starts.get(x);
					int end=ends.get(x);
					//inputs++;
					//System.out.println(checkavailability(cstart, cend, beg, end));
					//System.out.println(checkavailability(jstart, jend, beg, end));
					if(checkavailability(cstart, cend, beg, end))
					{
						cstart.add(beg);
						cend.add(end);
						answers[indexes.get(x)]="C";
					}
					else if(checkavailability(jstart, jend, beg, end))
					{
						jstart.add(beg);
						jend.add(end);
						answers[indexes.get(x)]="J";
					}
					else
					{
						answers[0]="Impossible";
						//System.out.println("occured");
						break;
					}
				}
			}
			System.out.print("Case #" + (g+1) + ": ");
			if(answers[0].contentEquals("Impossible"))
			{
				System.out.println("Impossible");
			}
			else
			{
				for(int x=0;x<answers.length;x++)
				{
					System.out.print(answers[x]);
				}
				System.out.println();
			}
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
