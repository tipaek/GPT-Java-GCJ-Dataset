import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

// 2020 Code Jam ESAb ATAd Problem
public class Solution {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {



		int noOfTestCases = scanner.nextInt();
		int arraySize = scanner.nextInt();

		for(int i =0; i<noOfTestCases; i++)
		{
			if(!findBitArray(arraySize))
			{
				return;
			}
		}




	}

	private static boolean findBitArray(int arraySize)
	{

		int[] bitset = new int[arraySize];
		for(int i=0; i<arraySize; i++)
		{
			System.out.println(i);
			bitset[i] = scanner.nextInt();
		}
		if(arraySize <=10)
		{
			display(bitset, arraySize);
			String isCorrect = scanner.next();
			if(!isCorrect.equals("Y"))
			{
				return false;
			}
		}
		return true;
	}

	private static void display(int[] bitset, int arraySize)
	{
		for(int i=0; i<arraySize; i++) {
			System.out.println(bitset[i]);
		}
	}

}
