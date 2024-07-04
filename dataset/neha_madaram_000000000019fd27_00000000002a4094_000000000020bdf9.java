

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Solution {
	public static void main(String[] args) {
		int timeSetsCount = 0;
		int timeSets[][] = null;
		int startTime[] = null;
		int endTime[] = null;
		Solution utility = new Solution();
		boolean resbool = false;
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		if(1 > testcases && testcases>100)
		{
			System.exit(1);
		}
		String[] result= new String[testcases];
		for(int i=0; i< testcases; i++)
		{
			//System.out.println("enter the no of time sets");
			timeSetsCount = sc.nextInt();
			if(2>timeSetsCount && timeSetsCount>1000)
			{
				System.exit(1);
			}
			startTime = new int[timeSetsCount];
			endTime =new int[timeSetsCount];
			timeSets = new int[timeSetsCount][2];
			for(int j=0;j<timeSetsCount; j++)
			{
				timeSets[j][0] = sc.nextInt();
				timeSets[j][1] = sc.nextInt();
			}
			result[i] = utility.segragate(resbool, timeSetsCount, timeSets, startTime, endTime);
		}
		
		for(int i=0;i<testcases;i++)
		{
			System.out.println("Case #"+(i+1)+": "+result[i]);
		}
		
		
		sc.close();
	}
	
	public String segragate(boolean resbool, int timeSetsCount, int[][] timeSets, int[] startTime, int[] endTime)
	{
		int imp;
		ArrayList<Integer> array = new ArrayList<>();
		for(int i=0; i<timeSetsCount;i++)
		{
				startTime[i] = timeSets[i][0];
				endTime[i] = timeSets[i][1];
				if(0 <= startTime[i] && startTime[i] <= 1440)
				{
					continue;
				}
				else
				{
					imp=1;
				}
				if(0 <= endTime[i] && endTime[i] <= 1440)
				{
					continue;
				}
				else
				{
					imp=1;
				}
				if(imp==1)
					return "IMPOSSIBLE";
		}
		
		for(int i=0;i<timeSetsCount;i++)
		{
			for(int j=0;j<timeSetsCount;j++)
			{
			if(startTime[j] < startTime[i] && startTime[i] < endTime[j])
			{
				array.add(i);
				array.add(j);
			}
			}
		}
		int i=0;
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		String result = "";
		
			if(i == 0)
			{
				list1.add(array.get(0));
				i++;
				list2.add(array.get(1));
				i++;
			}
			int val1,val2;
			for(;i<array.size();)
			{
			
				val1 = array.get(i);
				if(i<array.size())
					i++;
				val2 = array.get(i);
				if(i<array.size())
					i++;
				if(list1.contains(val1))
				{
					list2.add(val2);
				}
				if(list1.contains(val2))
				{
					list2.add(val1);
				}
				if(list2.contains(val2))
				{
					list1.add(val1);
				}
				if(list2.contains(val1))
				{
					list1.add(val2);
				}
			}
			for(int k=0;k<timeSetsCount;k++)
			{
				if(list1.contains(k))
				{
					result = result + "C";
				}
				else
				{
					result = result + "J";
				}
			}
			return result;
	}
}
