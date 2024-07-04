
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static Scanner in;
	static int T, B;
	
	static int[] bits;
	
	static int bitPairsRead = 0;
	static int query = 0;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		T = in.nextInt();
		B = in.nextInt();
		
		for(int c = 1; c <= T; c++) {
			reset();
			
			readFirstLastFive();
			
			while(bitPairsRead < B / 2 || query % 10 == 0) {
				if(query % 10 == 0) {
					updateUsingChange(identifyChange());
				}
				else {
					getNextPair();
				}
			}
			
			for(int i : bits)
				System.out.print(i);
			System.out.println();
			
			if(in.next().equals("N"))
				throw new Error();
		}
		
		in.close();
	}
	
	public static void reset() {
		bits = new int[B];
		bitPairsRead = 0;
	}
	
	public static void readFirstLastFive() {
		for(int i = 0; i < 5; i++)
			getNextPair();
	}
	
	public static void getNextPair() {
		System.out.println(bitPairsRead + 1);
		bits[bitPairsRead] = in.nextInt();
		
		System.out.println(B - bitPairsRead);
		bits[B - bitPairsRead - 1] = in.nextInt();
		
		bitPairsRead++;
		query += 2;
	}
	
	public static String identifyChange() {
		List<Integer> bits = new ArrayList<>();
		for(int i : Solution.bits)
			bits.add(i);
		List<Integer> reverseBits = new ArrayList<>(bits);
		Collections.reverse(reverseBits);
		
		int sameBit = -1;
		for(int i = 0; i < bitPairsRead; i++) {
			if(bits.get(i) == reverseBits.get(i)) {
				sameBit = i + 1;
				break;
			}
		}
		
		int diffBit = -1;
		for(int i = 0; i < bitPairsRead; i++) {
			if(bits.get(i) != reverseBits.get(i)) {
				diffBit = i + 1;
				break;
			}
		}
		
		boolean invert = false;
		if(sameBit != -1) {
			System.out.println(sameBit);
			int queriedSameBit = in.nextInt();
			
			if(queriedSameBit != bits.get(sameBit - 1))
				invert = true;
		}
		
		boolean reverse = false;
		if(diffBit != -1) {
			System.out.println(diffBit);
			int queriedDiffBit = in.nextInt();
			
			if(queriedDiffBit == bits.get(diffBit - 1)) {
				if(invert)
					reverse = true;
				else
					reverse = false;
			} else {
				if(invert)
					reverse = false;
				else
					reverse = true;
			}
		}
		
		if(diffBit == -1 || sameBit == -1) {
			System.out.println(1);
			in.nextInt();
		}
		
		query += 2;
		
		if(invert) {
			if(reverse) {
				return "IR";
			} else {
				return "IN";
			}
		} else {
			if(reverse) {
				return "NR";
			} else {
				return "NN";
			}
		}
	}
	
	public static void updateUsingChange(String change) {
		if(change.charAt(0) == 'I')
			invert();
		if(change.charAt(1) == 'R')
			reverse();
	}
	
	public static void invert() {
		for(int i = 0; i < B; i++)
			bits[i] = (bits[i] + 1) % 2;
	}
	
	public static void reverse() {
		for(int i = 0; i < B / 2; i++) {
			int t = bits[i];
			bits[i] = bits[B - i - 1];
			bits[B - i - 1] = t;
		}
	}
}
