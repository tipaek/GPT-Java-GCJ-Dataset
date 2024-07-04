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
			int matrix[][] = new int[lines][lines];
			for(int j=0;j<lines;j++)
			{
				int array[] = toIntArray(input[j]);
				for(int k=0;k<lines;k++)
				{
					matrix[j][k] = array[k];
				}
			}
			
			int sum=0,row_count=0,column_count=0;
			HashMap<Integer,Integer> map1 = new HashMap<Integer,Integer>();
			HashMap<Integer,Integer> map2 = new HashMap<Integer,Integer>();
			
			for(int j=0;j<lines;j++)
			{
				for(int k=0;k<lines;k++)
				{
					if(map1.containsKey(matrix[j][k]))
					{
						row_count++;
						break;
					}
					else
						map1.put(matrix[j][k],0);
					
				}
				map1.clear();
			}
			
			for(int j=0;j<lines;j++)
			{
				for(int k=0;k<lines;k++)
				{
					if(j==k)
						sum=sum+matrix[j][k];
				}
			}
			
			for(int j=0;j<lines;j++)
			{
				for(int k=0;k<lines;k++)
				{
					if(map2.containsKey(matrix[k][j]))
					{
						column_count++;
						break;
					}
					else
						map2.put(matrix[k][j],0);
				}
				map2.clear();
			}
			
			System.out.println("Case #"+i+": "+sum+" "+row_count+" "+column_count);
		}
	}
}