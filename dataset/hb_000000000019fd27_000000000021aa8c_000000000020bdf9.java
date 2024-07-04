import java.util.*;
class Time implements Comparable<Time>
{
	public int start;
	public int end;
	
	public Time(int start,int end)
	{
		this.start = start;
		this.end = end;
	}
	
	public int compareTo(Time timeCompare)
	{
		int startTime = timeCompare.start;
		return this.start - startTime;
	}
}
class Solution
{
	public static Scanner input = new Scanner(System.in);
	public static String[] readInput(int lines)
	{
		String result[] = new String[lines];
		for(int i=0;i<lines;i++)
		{
			result[i]=input.nextLine();
		}
		//System.out.println("Cases: " + cases);
		return result;
	}
	
	public static int[] toIntArray(String input)
	{
		String splitArray[] = input.split(" ");
		int output[] = new int[splitArray.length];
		for(int i=0;i<splitArray.length;i++)
			output[i]=Integer.parseInt(splitArray[i]);
		
		return output;
	}
	
	public static void main(String[] args)
	{
		int cases = Integer.parseInt(input.nextLine());
		for(int i=1;i<=cases;i++)
		{
			int lines = Integer.parseInt(input.nextLine());
			String input[] = readInput(lines);
			Time match[] = new Time[lines];
			Time time[] = new Time[lines];
			String result = new String();
			for(int j=0;j<lines;j++)
			{
				int array[] = toIntArray(input[j]);
				time[j] = new Time(array[0],array[1]);
				
				match[j] = new Time(array[0],array[1]);
			}
			Arrays.sort(time);
			int flag=0;
			int cameron=0,jamie=0;
			System.out.print("Case #"+i+": ");
			for(int j=0;j<lines;j++)
			{
				if(j==0)
				{
					cameron=j;
					jamie=j+1;
					result += "CJ";
				}
				else if(j==1)
					continue;
				else
				{
					if(time[jamie].end>time[j].start && time[cameron].end<=time[j].start)
					{
						cameron=j;
						result += "C";
					}
					else if(time[jamie].end<=time[j].start)
					{
						jamie=j;
						result += "J";
					}
					else if(time[j].start<time[cameron].start && time[j].end<=time[cameron].start)
					{
						cameron=j;
						result += "C";
					}
					else if(time[j].start<time[jamie].start && time[j].end<=time[jamie].start)
					{
						jamie=j;
						result += "J";
					}
					else if(time[jamie].end>time[j].start && time[cameron].end>time[j].start)
					{
						flag=1;
						break;
					}
				}	
			}
			char array[] = result.toCharArray();
			char output[] = new char[array.length];
			if(flag==0)
			{
				for(int j=0;j<lines;j++)
				{	
					for(int k=0;k<lines;k++)
					{
						if(match[k].start==time[j].start && match[k].end==time[j].end)
						{
							output[j]=array[k];
							break;
						}
						
					}
				}
				System.out.println(new String(output));
			}
			else
				System.out.println("IMPOSSIBLE");
		}
	}
}