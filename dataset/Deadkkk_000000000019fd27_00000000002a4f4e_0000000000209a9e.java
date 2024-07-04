import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

public class Solution {


	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);
		int noOfTestCases = scanner.nextInt();
		int arraySize = scanner.nextInt();
		for(int i =0; i<noOfTestCases; i++)
		{
			try {
				if(!findBitArray(arraySize))
				{
					return;
				}
			}
			catch (IOException e) {
					e.printStackTrace();
			}
		}




	}

	private static boolean findBitArray(int arraySize) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int[] bitset = new int[arraySize];
		if(arraySize <= 10) {
			for (int i = 0; i < arraySize; i++) {
				System.out.println(i + 1);
				System.out.flush();
				bitset[i] = scanner.nextInt();
			}
			display(bitset, arraySize);
			char isCorrect = (char) System.in.read();
			if (isCorrect != 'Y') {
				return false;
			}
		}
		else
		{
		    int j = 1;
			for (int i = 0; i < arraySize; ) {
				if((j%40 <= 10 && j%40 > 0)) {
					System.out.println(i + 1);
					System.out.flush();
					bitset[i] = scanner.nextInt();
					i++;
				}
				else
				{
					System.out.println(1);
					scanner.nextInt();
				}
				j++;
			}
			display(bitset, arraySize);
			char isCorrect = (char) System.in.read();
			if (isCorrect != 'Y') {
				return false;
			}
		}
		return true;
	}

	private static void display(int[] bitset, int arraySize)
	{
		for(int i=0; i<arraySize; i++) {
			System.out.print(bitset[i]);
		}
		System.out.println();
		System.out.flush();
	}

}
