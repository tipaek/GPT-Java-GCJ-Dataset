

import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {

	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine().trim());
		
		for(int t=1;t<=test;t++)
		{
			
			int task=Integer.parseInt(br.readLine().trim());
			
			Job arr[]=new Job[task];
			
			for(int i=0;i<task;i++)
			{
				String s[]=br.readLine().split(" ");
				arr[i]=new Job(i+1,Integer.parseInt(s[0].trim()),Integer.parseInt(s[1].trim()));
			}
			
			Arrays.sort(arr,new Comparator<Job>()
			{
				@Override
				public int compare(Job lhs, Job rhs) 
				{	
					return lhs.start-rhs.start;
				}
			});
			
			HashMap<Integer,Integer> Cam=new HashMap<Integer,Integer>();
			
			HashMap<Integer,Integer> Jam=new HashMap<Integer,Integer>();

			int flag=0;

			for(int i=0;i<task;i++)
			{
				if(!isBusy(Cam,arr[i].start,arr[i].end))
				{
					arr[i].setDoer('C');
					Cam.put(arr[i].start, arr[i].end);
					//System.out.print("C");
				}
				else if(!isBusy(Jam,arr[i].start,arr[i].end))
				{
					arr[i].setDoer('J');
					Jam.put(arr[i].start, arr[i].end);
					//System.out.print("J");
				}
				else
				{
					flag=1;
					//System.out.print("hahaha");
				}
				
			}
			
			if(flag==1)
			{
				System.out.println("Case #"+t+": IMPOSSIBLE");
			}
			else
			{
				Arrays.sort(arr,new Comparator<Job>()
				{
					@Override
					public int compare(Job lhs, Job rhs) 
					{	
						return lhs.index-rhs.index;
					}
			
				});
				
				String res="";
				for(int i=0;i<task;i++)
				{
					res+=arr[i].getDoer();
				}
				
				System.out.println("Case #"+t+": "+res);
			}
	
		}
		
		br.close();
	}
	
	private static boolean isBusy(HashMap<Integer,Integer> map,int start,int end)
	{
		for(Integer i:map.keySet())
		{
			if(start<map.get(i))
			{
				return true;
			}
		}
		return false;
	}

}


class Job
{
	int index;
	int start;
	int end;
	private char doer;
	
	Job(int index,int start, int end)
	{
		this.index=index;
		this.start=start;
		this.end=end;
	}

	public char getDoer() {
		return doer;
	}

	public void setDoer(char doer) {
		this.doer = doer;
	}
	
	
}
