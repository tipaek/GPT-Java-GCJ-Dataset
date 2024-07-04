import java.util.Scanner;

public class Solution {

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		int tCount = keyboard.nextInt();
		int bitCount = keyboard.nextInt();
		for(int t = 0; t < tCount; t++)
		{
			int[] resultArray = new int[bitCount];
			for(int i = 1; i <= bitCount; i++)
			{
				System.out.println(i);
				resultArray[i-1] = keyboard.nextInt();
			}
			System.out.println(bitArrayToString(resultArray));
			String status = keyboard.nextLine();
			return;
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