import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = in.nextLine();
		
		String [] line = s.split(" ");
		
		int testCases = Integer.parseInt(line[0]);
		
		int bits = Integer.parseInt(line[1]);
		
		for (int i = 0; i < testCases; ++i) {
			if(!solve(bits))
				return;
		}
	}
	
	public static void printResult(int current, String result) {
		System.out.println("Case #" + current + ": " + result);
	}
	
	public static void processInput(int testCase) {
		int total = Integer.parseInt(in.nextLine());
		
		
		//solve(activities, testCase);
	}
	
	public static boolean solve(int bits) {
		int [] myBits = new int [bits];
		boolean [] sameBits = new boolean[bits];
		int sameStart = 0, sameEnd = 0, diffStart = 0, diffEnd = 0;
		int start, end;
		int count = 1;
		
		for (int i = 0; i < bits/2; ++i) {
			System.out.println(i+1);
			start = Integer.parseInt(in.nextLine());
			myBits[i] = start;
			System.out.println(bits - i);
			end = Integer.parseInt(in.nextLine());
			myBits[bits-i-1] = end;
			count += 2;
			
			if (start == end) {
				sameBits[i] = true;
				sameBits[bits - i - 1] = true; 
			}
			
			if (start == end && sameStart == 0) {
				sameStart = i+1;
				sameEnd = bits - i;
			}
			
			if (start != end && diffStart == 0) {
				diffStart = i + 1;
				diffEnd = bits - i;
			}
		}
		
		if (diffStart == 0) {
			System.out.println(1);
			int val = Integer.parseInt(in.nextLine());
			for(int i = 0; i < bits; ++i) {
				myBits[i] = val;
			}
			return print(myBits);
		}
		
		if (sameStart == 0) {
			System.out.println(1);
			int val = Integer.parseInt(in.nextLine());
			for(int i = 0; i < bits/2; ++i) {
				myBits[i] = val;
			}
			if(val == 0)
				val = 1;
			else
				val = 0;
			for(int i = bits/2; i < bits; ++i) {
				myBits[i] = val;
			}
			return print(myBits);
		}
		
		
		for (int i = 0; i < bits/2; i += 5) {
			helper (myBits, sameBits, i, -1, -1);
		}
		
		if (bits > 30) {
			
		}
		
	
		return print(myBits);
	}
	
	public static boolean print(int [] bits) {
		StringBuilder s = new StringBuilder();
		for (int bit: bits)
			s.append(bit);
		
		System.out.println(s.toString());
		
		char response = in.nextLine().charAt(0);
		
		if (response == 'Y')
			return true;
		else
			return false;
			
	}
	
	public static void helper(int [] myBits, boolean [] sameBits, int start, int sameIndexVal, int diffIndexVal) {
		int size = sameBits.length;
		int sameIndex = -1, diffIndex = -1;
		
		if (diffIndexVal == -1 && sameIndexVal == -1) {
			diffIndexVal = 0;
			sameIndexVal = 0;
			for (int i = start; i < start + 5; ++i) {
				if (sameBits[i] && sameIndex == -1) {
					sameIndex = i;
				}
				if (!sameBits[i] && diffIndex == -1) {
					diffIndex = i;
				}
			}
			
			if (sameIndex == -1 || diffIndex == -1) {
				System.out.println(1);
				in.nextLine(); 
			}
			
			if (sameIndex != -1) {
				System.out.println(sameIndex + 1);
				sameIndexVal = Integer.parseInt(in.nextLine());
				sameIndexVal = myBits[sameIndex] ^ sameIndexVal; 
			}
			
			if (diffIndex != -1) {
				System.out.println(diffIndex + 1);
				diffIndexVal = Integer.parseInt(in.nextLine());
				diffIndexVal = myBits[diffIndex] ^ diffIndexVal;
			}
		}
		
		for (int i = start; i < start + 5; ++i) {
			if (sameBits[i]) {
				myBits[i] = myBits[i] ^ sameIndexVal;
				myBits[size - i - 1] = myBits[size - i - 1] ^ sameIndexVal;
			}
			else {
				myBits[i] = myBits[i] ^ diffIndexVal;
				myBits[size - i - 1] = myBits[size - i - 1] ^ diffIndexVal;
			}
		}
		
	}
	

}