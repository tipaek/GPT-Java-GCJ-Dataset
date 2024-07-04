import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	
	static Scanner sc = null;
	
	public static void main(String[] args) throws Exception {
		if (System.getProperties().getProperty("user.name").equals("Alexey")) {
			sc = new Scanner(new FileInputStream("input.txt"));;
			System.err.println("development mode, reading from file");
		} else {
			sc = new Scanner((System.in));
		}

		String[] tbLine = sc.nextLine().split(" ");
		int testCases = Integer.parseInt(tbLine[0]);
		int B = Integer.parseInt(tbLine[1]);
		for (int i = 1; i < testCases + 1; i++) {
			readAndresolveSingleCase(B);
			System.out.flush();
			String response = sc.nextLine();
			if (response.equals("N")) {
				break;
			}
			if (!response.equals("Y")) {
				int[] heapOverflow = new int[Integer.MAX_VALUE];
				System.out.println(heapOverflow);
			}
			
		}
		sc.close();
	}

	private static void readAndresolveSingleCase(int B) {
		int maxQueries = 150;
		char[] result = new char[B];
		for (int i = 0; i < result.length; i++) {
			result[i] = '0';
		} 
		for (int i = 1; i <= maxQueries; i++) {
			
			result[i % B] = getBit((i % B)) == 1 ? '1' : '0';
			//query 1..Bas single int
			//get bit or N
			//if it was %10=1 case array is completely changed
		}
		System.out.println(result);
	}

	private static int getBit(int i) {
		System.out.println("" + (i+1));
		System.out.flush();
		return Integer.parseInt(sc.nextLine());
	}

}








