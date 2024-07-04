import java.util.Scanner;

public class Solution {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int tCount = input.nextInt();
		int bitCount = input.nextInt();
		for(int t = 0; t < tCount; t++)
		{
			int[] resultArray = new int[bitCount];
			for(int i = 1; i <= bitCount; i++)
			{
				System.out.println(i);
				resultArray[i-1] = input.nextInt();
			}
			System.out.println(bitArrayToString(resultArray));
			input.nextLine();
			String status = input.nextLine();
			if(status.equals("N"))
		    {
		        return;
		    }
		}
	}
	
	private static String bitArrayToString(int[] bits)
	{
		String result = "";
		for(int i = 0; i < bits.length; i++)
		{
			result += bits[i];
		}
		return result;
	}
}
