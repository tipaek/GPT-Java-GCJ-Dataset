import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

// 2020 Code Jam ESAb ATAd Problem
public class Solution {


	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);
		int noOfTestCases = scanner.nextInt();
		int arraySize = scanner.nextInt();
		scanner.close();
		for(int i =0; i<noOfTestCases; i++)
		{
			try {
				if(!findBitArray(arraySize))
				{
					return;
				}
			}
			catch (IOException e) {
					return;
			}
		}




	}

	private static boolean findBitArray(int arraySize) throws IOException {
		InputStream inputStream = System.in;
		int[] bitset = new int[arraySize];
		for(int i=0; i<arraySize; i++)
		{
			System.out.write(i);
			System.out.flush();
			bitset[i] = inputStream.read();
		}
			display(bitset, arraySize);
			char isCorrect = (char)inputStream.read();
			if(isCorrect != 'Y')
			{
				return false;
			}
		return true;
	}

	private static void display(int[] bitset, int arraySize)
	{
		for(int i=0; i<arraySize; i++) {
			System.out.write(bitset[i]);
		}
		System.out.flush();
	}

}
