import java.util.*;
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
			int start[] = new int[lines];
			int end[] = new int[lines];
			String result = new String();
			for(int j=0;j<lines;j++)
			{
				int array[] = toIntArray(input[j]);
				start[j]=array[0];
				end[j]=array[1];
			}
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
					if(end[jamie]>start[j] && end[cameron]<=start[j])
					{
						cameron=j;
						result += "C";
					}
					else if(end[jamie]<=start[j])
					{
						jamie=j;
						result += "J";
					}
					else if(start[j]<start[cameron] && end[j]<=start[cameron])
					{
						cameron=j;
						result += "C";
					}
					else if(start[j]<start[jamie] && end[j]<=start[jamie])
					{
						jamie=j;
						result += "J";
					}
					else if(end[jamie]>start[j] && end[cameron]>start[j])
					{
						flag=1;
						break;
					}
				}
					
			}
			if(flag==0)
				System.out.println(result);
			else
				System.out.println("IMPOSSIBLE");
		}
	}
}