import java.util.*;
class Solution
{
	public static String[] readInput(int lines)
	{
		Scanner input = new Scanner(System.in);
		int cases = Integer.parseInt(input.nextLine());
		String result[] = new String[cases*lines+1];
		result[0]=Integer.toString(cases);
		int count=1;
		for(int i=1;i<=cases;i++)
		{
			for(int j=1;j<=lines;j++)
			{
				result[count]=input.nextLine();
				count++;
			}
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
		String input[] = readInput(1);
		for(int i=1;i<input.length;i++)
		{
			int array[] = toIntArray(input[i]);
			int n=array[0];
			int k=array[1];
			int value=0;
			
			for(int j=1;j<=n;j++)
			{
				if(j*n==k)
					value=j;
			}
			System.out.print("Case #"+i+": ");
			if(value!=0)
			{
				System.out.println("POSSIBLE");
				for(int j=1;j<=n;j++)
				{
					int count=value;
					for(int l=1;l<=n;l++)
					{
						if(l==n)
							System.out.println(count);
						else
							System.out.print(count+" ");
						if(count==n)
							count=1;
						else
							count++;
					}
					if(value==1)
						value=n;
					else
						value--;
				}
			}
			else
			{
				System.out.println("IMPOSSIBLE");
			}
		}
	}
}